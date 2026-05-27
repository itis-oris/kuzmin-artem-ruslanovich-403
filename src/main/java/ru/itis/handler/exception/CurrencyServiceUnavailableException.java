package ru.itis.handler.exception;

import org.springframework.http.HttpStatus;

public class CurrencyServiceUnavailableException extends AppException {
    public CurrencyServiceUnavailableException(String message) {
        super(message, HttpStatus.SERVICE_UNAVAILABLE);
    }
}