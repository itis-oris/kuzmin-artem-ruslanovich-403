package ru.itis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Booking;
import ru.itis.model.User;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByUser(User user);

}
