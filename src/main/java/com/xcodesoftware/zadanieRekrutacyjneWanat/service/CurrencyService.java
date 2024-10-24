package com.xcodesoftware.zadanieRekrutacyjneWanat.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xcodesoftware.zadanieRekrutacyjneWanat.model.Currency;
import com.xcodesoftware.zadanieRekrutacyjneWanat.model.CurrencyApiResponse;
import com.xcodesoftware.zadanieRekrutacyjneWanat.model.CurrencyQuery;
import com.xcodesoftware.zadanieRekrutacyjneWanat.model.User;
import com.xcodesoftware.zadanieRekrutacyjneWanat.repository.CurrencyQueryRepository;
import com.xcodesoftware.zadanieRekrutacyjneWanat.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyQueryRepository currencyQueryRepository;
    private final UserRepository userRepository;

    public CurrencyService(CurrencyQueryRepository currencyQueryRepository, UserRepository userRepository) {
        this.currencyQueryRepository = currencyQueryRepository;
        this.userRepository = userRepository;
    }

    public Currency getCurrencyByCode(String code) throws IOException {
        String url = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        List<CurrencyApiResponse> currencyResponses = objectMapper.readValue(
                jsonResponse,
                new TypeReference<List<CurrencyApiResponse>>() {}
        );

        List<Currency> currencies = currencyResponses.get(0).getRates();
        for (Currency currency : currencies) {
            if (currency.getCode().equalsIgnoreCase(code)) {
                return currency;
            }
        }
        return null;
    }

    public void logCurrencyQuery(User user, String currencyCode, double currencyRate) {
        CurrencyQuery query = new CurrencyQuery(user, currencyCode, currencyRate);
        currencyQueryRepository.save(query);
    }
}
