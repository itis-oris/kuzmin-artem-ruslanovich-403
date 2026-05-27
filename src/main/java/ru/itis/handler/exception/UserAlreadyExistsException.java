package ru.itis.handler.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends AppException {
    public UserAlreadyExistsException(String email) {
        super("Пользователь с email " + email + " уже существует", HttpStatus.CONFLICT);
    }
}