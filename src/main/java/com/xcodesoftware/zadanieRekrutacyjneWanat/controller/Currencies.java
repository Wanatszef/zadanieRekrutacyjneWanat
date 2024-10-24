package com.xcodesoftware.zadanieRekrutacyjneWanat.controller;

import com.xcodesoftware.zadanieRekrutacyjneWanat.model.*;
import com.xcodesoftware.zadanieRekrutacyjneWanat.repository.UserRepository;
import com.xcodesoftware.zadanieRekrutacyjneWanat.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@RestController
@RequestMapping("/currencies")
public class Currencies {

    private final CurrencyService currencyService;
    private final UserRepository userRepository;

    public Currencies(CurrencyService currencyService, UserRepository userRepository) {
        this.currencyService = currencyService;
        this.userRepository = userRepository;
    }

    @PostMapping("/get-current-currency-value-command")
    public ResponseEntity<CurrencyResponse> getCurrency(@RequestBody CurrencyRequest currencyRequest) throws IOException {
        if(!currencyRequest.getFirstName().isEmpty() && !currencyRequest.getLastName().isEmpty() && !currencyRequest.getCurrency().isEmpty()) {
            Currency currency = currencyService.getCurrencyByCode(currencyRequest.getCurrency());

            if(currency != null) {
                User user = userRepository.findByFirstNameAndLastName(currencyRequest.getFirstName(), currencyRequest.getLastName());
                if (user == null) {
                    user = new User();
                    user.setFirstName(currencyRequest.getFirstName());
                    user.setLastName(currencyRequest.getLastName());
                    userRepository.save(user);
                }

                currencyService.logCurrencyQuery(user, currency.getCode(), currency.getMid());

                CurrencyResponse currencyResponse = new CurrencyResponse(currencyRequest, currency);
                return ResponseEntity.ok(currencyResponse);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
