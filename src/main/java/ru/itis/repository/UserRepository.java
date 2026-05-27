package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findUserById(Long id);


    @Query("""
        select (
            select count(b)
            from Booking b
            where b.user.id = u.id
               )
        from User u
        where u.id = :userId
        """)
    Long countBookingsByUserId(Long userId);


}

