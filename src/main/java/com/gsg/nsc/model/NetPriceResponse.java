package com.gsg.nsc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class NetPriceResponse {

    private double grossPrice;
    private double netPrice;
    private BigDecimal taxRate;

}


