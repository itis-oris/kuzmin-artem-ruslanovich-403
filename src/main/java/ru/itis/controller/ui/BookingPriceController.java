package ru.itis.controller.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.form.BookingCreateForm;
import ru.itis.model.TicketCategory;
import ru.itis.service.CurrencyService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingPriceController {

    private final CurrencyService currencyService;

    @GetMapping("/calculate")
    public ResponseEntity<Map<String, Object>> calculate(@ModelAttribute BookingCreateForm form) {
        BigDecimal rate = currencyService.getExchangeRate(form.getCurrency());

        BigDecimal total = BigDecimal.ZERO
            .add(TicketCategory.ADULT.getBasePrice().multiply(BigDecimal.valueOf(form.getAdultCount())))
            .add(TicketCategory.STUDENT.getBasePrice().multiply(BigDecimal.valueOf(form.getStudentCount())))
            .add(TicketCategory.CHILD.getBasePrice().multiply(BigDecimal.valueOf(form.getChildCount())))
            .multiply(rate);

        return ResponseEntity.ok(Map.of(
            "totalPrice", total.setScale(2, RoundingMode.HALF_UP),
            "currency", form.getCurrency()
        ));
    }
}