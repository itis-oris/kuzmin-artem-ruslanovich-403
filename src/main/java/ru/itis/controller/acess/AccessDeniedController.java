package ru.itis.controller.acess;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
