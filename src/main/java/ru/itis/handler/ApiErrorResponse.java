package ru.itis.handler;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Builder
@Getter
public class ApiErrorResponse {
    private LocalDateTime timestamp;
    private String message;
}
