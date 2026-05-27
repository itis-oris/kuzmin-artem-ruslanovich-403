package ru.itis.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.form.RegistrationForm;
import ru.itis.form.UserUpdateForm;
import ru.itis.handler.exception.NotFoundException;
import ru.itis.handler.exception.UserAlreadyExistsException;
import ru.itis.model.Role;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void register(RegistrationForm form) {
        if (userRepository.findByEmail(form.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(form.getEmail());
        }

        User user = User.builder()
                .username(form.getUsername())
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(user);
    }

    public User findById(Long id) {

        return userRepository.findUserById(id)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
    }

    public Long getBookingsCount(Long userId) {
        return userRepository.countBookingsByUserId(userId);
    }

    @Transactional
    public void updateProfile(Long userId, UserUpdateForm form
    ) {

        User user = findById(userId);
        user.setUsername(form.getUsername());
        userRepository.save(user);
    }

    @Transactional
    public void deleteProfile(Long userId) {
        User user = findById(userId);
        userRepository.delete(user);
    }


}
