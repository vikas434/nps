package com.gsg.nsc.service;

import com.gsg.nsc.model.NetPriceResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetPriceCalculatorServiceTest {

    private final NetPriceCalculatorService netPriceCalculatorService = new NetPriceCalculatorService();

    @Test
    public void testCalculateNetPrice() {
        assertEquals(81, netPriceCalculatorService.calculateNetPrice(100, "DE").getNetPrice(), 0.01);
        assertEquals(1.60, netPriceCalculatorService.calculateNetPrice(1.99, "FR").getNetPrice(), 0.01);
        assertEquals(0, netPriceCalculatorService.calculateNetPrice(0, "DE").getNetPrice(), 0.01);
    }

    @Test
    public void testCalculateNetPriceWithValidCountry() {
        NetPriceResponse expectedResponse = new NetPriceResponse(100.0, 81.0, new BigDecimal("0.19"));
        NetPriceResponse actualResponse = netPriceCalculatorService.calculateNetPrice(100.0, "DE");
        assertEquals(expectedResponse, actualResponse);
    }

}
