package ru.itis.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.form.RegistrationForm;
import ru.itis.service.UserService;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Неверный email или пароль!");
        }
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "registered";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegistrationForm form) {
        userService.register(form);
        return "redirect:/login";
    }
}