package ru.itis.controller.ui;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animals-page")
public class AnimalsShowController {


    @GetMapping
    public String animalsPage() {
        return "animals-page";
    }
}
