package ru.itis.handler.exception;

import org.springframework.http.HttpStatus;

public class FileStorageException extends AppException {
    public FileStorageException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}