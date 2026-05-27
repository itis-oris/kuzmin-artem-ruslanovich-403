package ru.itis.controller.user;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.form.UserUpdateForm;
import ru.itis.model.User;
import ru.itis.service.UserDetailsImpl;
import ru.itis.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;


    @GetMapping
    public String profilePage(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            Model model
    ) {

        User user = userService.findById(userDetails.getUser().getId()
        );

        Long bookingsCount = userService.getBookingsCount(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("bookingsCount", bookingsCount);

        return "profile";
    }

    @GetMapping("/edit")
    public String editProfilePage(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            Model model
    ) {

        User user = userService.findById(
                userDetails.getUser().getId()
        );

        UserUpdateForm form = new UserUpdateForm();
        form.setUsername(user.getUsername());
        model.addAttribute("form", form);

        return "edit_profile";
    }

    @PostMapping("/edit")
    public String updateProfile(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @ModelAttribute UserUpdateForm form
    ) {

        userService.updateProfile(
                userDetails.getUser().getId(),
                form
        );

        return "redirect:/profile";
    }

    @PostMapping("/delete")
    public String deleteProfile(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        userService.deleteProfile(
                userDetails.getUser().getId()
        );

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        new SecurityContextLogoutHandler()
                .logout(request, response, auth);

        return "redirect:/";
    }
}
