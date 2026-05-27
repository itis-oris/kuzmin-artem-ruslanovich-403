package ru.itis.form;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingCreateForm {
    private LocalDate visitDate;
    private Integer adultCount;
    private Integer studentCount;
    private Integer childCount;
    private String currency;
}