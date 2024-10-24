package com.xcodesoftware.zadanieRekrutacyjneWanat.service;

import com.xcodesoftware.zadanieRekrutacyjneWanat.model.Currency;
import com.xcodesoftware.zadanieRekrutacyjneWanat.model.CurrencyQuery;
import com.xcodesoftware.zadanieRekrutacyjneWanat.model.User;
import com.xcodesoftware.zadanieRekrutacyjneWanat.repository.CurrencyQueryRepository;
import com.xcodesoftware.zadanieRekrutacyjneWanat.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CurrencyServiceTest {

    @Mock
    private CurrencyQueryRepository currencyQueryRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CurrencyService currencyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCurrencyByCode() throws IOException {
        String code = "USD";
        Currency currency = new Currency();
        currency.setCode("USD");
        currency.setMid(4.20);

        CurrencyService serviceSpy = spy(currencyService);
        doReturn(currency).when(serviceSpy).getCurrencyByCode(code);

        Currency result = serviceSpy.getCurrencyByCode(code);

        assertNotNull(result);
        assertEquals("USD", result.getCode());
        assertEquals(4.20, result.getMid());
    }

    @Test
    void testLogCurrencyQuery() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Travolta");

        String currencyCode = "EUR";
        double currencyRate = 4.50;

        currencyService.logCurrencyQuery(user, currencyCode, currencyRate);

        verify(currencyQueryRepository, times(1)).save(any(CurrencyQuery.class));
    }
}
