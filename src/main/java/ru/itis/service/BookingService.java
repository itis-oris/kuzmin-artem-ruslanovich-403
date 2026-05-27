package ru.itis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.form.BookingCreateForm;
import ru.itis.model.Booking;
import ru.itis.model.Ticket;
import ru.itis.model.TicketCategory;
import ru.itis.model.User;
import ru.itis.repository.BookingRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CurrencyService currencyService;

    @Transactional
    public void save(BookingCreateForm form, User user) {
        BigDecimal rate = currencyService.getExchangeRate(form.getCurrency());

        Booking booking = Booking.builder()
                .visitDate(form.getVisitDate())
                .currency(form.getCurrency())
                .tickets(new ArrayList<>())
                .user(user)
                .build();

        BigDecimal totalSum = BigDecimal.ZERO;

        totalSum = totalSum.add(addTickets(booking, TicketCategory.ADULT, form.getAdultCount(), rate));
        totalSum = totalSum.add(addTickets(booking, TicketCategory.STUDENT, form.getStudentCount(), rate));
        totalSum = totalSum.add(addTickets(booking, TicketCategory.CHILD, form.getChildCount(), rate));

        booking.setTotalPrice(totalSum);

        bookingRepository.save(booking);
    }

    private BigDecimal addTickets(Booking booking, TicketCategory category, Integer count, BigDecimal rate) {
        if (count == null || count <= 0) return BigDecimal.ZERO;


        BigDecimal priceInCurrency = category.getBasePrice().multiply(rate);
        
        for (int i = 0; i < count; i++) {
            Ticket ticket = Ticket.builder()
                    .category(category)
                    .price(priceInCurrency)
                    .booking(booking)
                    .build();
            booking.getTickets().add(ticket);
        }
        
        return priceInCurrency.multiply(BigDecimal.valueOf(count));
    }

    public List<Booking> findAllByUser(User user) {
        return bookingRepository.findAllByUser(user);
    }
}