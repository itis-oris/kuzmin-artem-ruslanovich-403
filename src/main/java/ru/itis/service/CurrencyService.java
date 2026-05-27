package ru.itis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.handler.exception.CurrencyServiceUnavailableException;

import java.math.BigDecimal;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final RestTemplate restTemplate;
    private final String API_URL = "https://api.exchangerate-api.com/v4/latest/RUB";

    public BigDecimal getExchangeRate(String targetCurrency) {
        if ("RUB".equals(targetCurrency)) return BigDecimal.ONE;

        try {
            Map<String, Object> response = restTemplate.getForObject(API_URL, Map.class);
            Map<String, Double> rates = (Map<String, Double>) response.get("rates");
            
            Double rate = rates.get(targetCurrency);
            
            return BigDecimal.valueOf(rate);
        } catch (Exception e) {
            throw new CurrencyServiceUnavailableException("Ошибка сервиса валют");
        }
    }
}