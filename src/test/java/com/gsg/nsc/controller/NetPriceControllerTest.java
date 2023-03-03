package com.gsg.nsc.controller;

import com.gsg.nsc.model.NetPriceResponse;
import com.gsg.nsc.service.NetPriceCalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(NetPriceController.class)
public class NetPriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NetPriceCalculatorService netPriceCalculatorService;

    @Test
    public void testCalculateNetPrice() throws Exception {
        double grossPrice = 100.00;
        String countryIso = "DE";
        NetPriceResponse expectedResponse = new NetPriceResponse(grossPrice, 84.03, BigDecimal.valueOf(0.19));
        given(netPriceCalculatorService.calculateNetPrice(grossPrice, countryIso)).willReturn(expectedResponse);

        mockMvc.perform(get("/net-price/{grossPrice}/{countryIso}", grossPrice, countryIso))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.grossPrice", is(expectedResponse.getGrossPrice())))
                .andExpect(jsonPath("$.netPrice", is(expectedResponse.getNetPrice())))
                .andExpect(jsonPath("$.taxRate", is(expectedResponse.getTaxRate().doubleValue())));
    }

}
