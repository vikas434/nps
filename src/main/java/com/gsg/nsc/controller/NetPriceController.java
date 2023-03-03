package com.gsg.nsc.controller;

import com.gsg.nsc.model.NetPriceResponse;
import com.gsg.nsc.service.NetPriceCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetPriceController {

    @Autowired
    private NetPriceCalculatorService netPriceCalculatorService;

    @GetMapping("/net-price/{grossPrice}/{countryIso}")
    public NetPriceResponse calculateNetPrice(@PathVariable double grossPrice, @PathVariable String countryIso) {
        return netPriceCalculatorService.calculateNetPrice(grossPrice, countryIso);
    }
}

