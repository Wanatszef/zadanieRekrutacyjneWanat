package com.xcodesoftware.zadanieRekrutacyjneWanat.controller;

import com.xcodesoftware.zadanieRekrutacyjneWanat.model.Currency;
import com.xcodesoftware.zadanieRekrutacyjneWanat.model.CurrencyRequest;
import com.xcodesoftware.zadanieRekrutacyjneWanat.model.CurrencyResponse;
import com.xcodesoftware.zadanieRekrutacyjneWanat.service.CurrencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class CurrenciesTest {

    @Mock
    private CurrencyService currencyService;

    @InjectMocks
    private Currencies currenciesController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(currenciesController).build();
    }

    @Test
    void testGetCurrency_ValidRequest() throws Exception {
        // Przygotuj dane testowe
        Currency currency = new Currency();
        currency.setCode("USD");
        currency.setMid(4.20);

        CurrencyRequest request = new CurrencyRequest();
        request.setFirstName("John");
        request.setLastName("Travolta");
        request.setCurrency("USD");

        when(currencyService.getCurrencyByCode("USD")).thenReturn(currency);


        mockMvc.perform(post("/currencies/get-current-currency-value-command")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"John\", \"lastName\":\"Travolta\", \"currency\":\"USD\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currency.code").value("USD"))
                .andExpect(jsonPath("$.currency.mid").value(4.20));
    }

    @Test
    void testGetCurrency_InvalidRequest() throws Exception {
        mockMvc.perform(post("/currencies/get-current-currency-value-command")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"\", \"lastName\":\"Travolta\", \"currency\":\"USD\"}"))
                .andExpect(status().isBadRequest());
    }
}
