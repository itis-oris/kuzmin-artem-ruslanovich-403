package ru.itis.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.form.BookingCreateForm;
import ru.itis.model.Booking;
import ru.itis.model.User;
import ru.itis.service.BookingService;
import ru.itis.service.UserDetailsImpl;

import java.util.List;

@Controller
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;


    @GetMapping
    public String showBookingPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<Booking> bookingList = bookingService.findAllByUser(userDetails.getUser());
        model.addAttribute("bookings", bookingList);
        return "booking_page";
    }


    @PostMapping
    public String createBooking(@ModelAttribute BookingCreateForm form, 
                                @AuthenticationPrincipal UserDetailsImpl userDetails) {

        bookingService.save(form, userDetails.getUser());
        return "redirect:/booking";
    }
}