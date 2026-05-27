package ru.itis.controller.admin;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.form.AnimalCreateForm;
import ru.itis.model.AnimalSpecies;
import ru.itis.service.AnimalService;
import ru.itis.service.EnclosureService;

@Controller
@RequestMapping("/admin/animals")
@RequiredArgsConstructor
public class AnimalAdminController {

    private final AnimalService animalService;
    private final EnclosureService enclosureService;


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("enclosures", enclosureService.findAll());
        model.addAttribute("species", AnimalSpecies.values());
        return "add_animal";
    }


    @PostMapping("/add")
    public String createAnimal(@ModelAttribute AnimalCreateForm form) {
        animalService.createAnimal(form);
        return "redirect:/admin";
    }



}
