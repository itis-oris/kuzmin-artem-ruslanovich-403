package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
