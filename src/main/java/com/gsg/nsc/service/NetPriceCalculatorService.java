package com.gsg.nsc.service;

import com.gsg.nsc.model.NetPriceResponse;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Data
@Service
public class NetPriceCalculatorService {

    private static final Map<Object, BigDecimal> TAX_RATES = new HashMap<>();

    static {
        TAX_RATES.put("DE", BigDecimal.valueOf(0.19));
        TAX_RATES.put("FR", BigDecimal.valueOf(0.20));
        TAX_RATES.put("US", BigDecimal.valueOf(0.0)); // tax rate is 0 for US
    }

    public NetPriceResponse calculateNetPrice(double grossPrice, String countryIso) {
        BigDecimal grossPriceDecimal = BigDecimal.valueOf(grossPrice);
        BigDecimal taxRate = TAX_RATES.getOrDefault(countryIso, BigDecimal.ZERO);
        BigDecimal taxAmount = grossPriceDecimal.multiply(taxRate);
        BigDecimal netPriceDecimal = grossPriceDecimal.subtract(taxAmount);

        double netPrice = netPriceDecimal.setScale(1, RoundingMode.HALF_UP).doubleValue();

        return new NetPriceResponse(grossPrice, netPrice, taxRate);
    }

}

