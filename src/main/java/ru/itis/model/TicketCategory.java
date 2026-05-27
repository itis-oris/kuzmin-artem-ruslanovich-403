package ru.itis.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum TicketCategory {
    ADULT(BigDecimal.valueOf(1000)),
    STUDENT(BigDecimal.valueOf(700)),
    CHILD(BigDecimal.valueOf(500));

    private final BigDecimal basePrice;

    TicketCategory(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

}
