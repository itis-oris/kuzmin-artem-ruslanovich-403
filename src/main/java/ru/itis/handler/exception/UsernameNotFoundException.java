package ru.itis.handler.exception;

import org.springframework.http.HttpStatus;

public class UsernameNotFoundException extends AppException {
    public UsernameNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
