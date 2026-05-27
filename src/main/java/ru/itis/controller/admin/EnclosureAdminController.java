package ru.itis.controller.admin;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.form.EnclosureCreateForm;
import ru.itis.model.EnclosureType;
import ru.itis.service.EnclosureService;
import ru.itis.service.KeeperService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/enclosures")
public class EnclosureAdminController {

    private final EnclosureService enclosureService;
    private final KeeperService keeperService;

    @GetMapping()
    public String showAddForm(Model model) {
        model.addAttribute("enclosures", enclosureService.findAll());
        model.addAttribute("keepers", keeperService.findAll());
        model.addAttribute("types", EnclosureType.values());
        return "enclosures_page";
    }


    @PostMapping()
    public String createEnclosure(@ModelAttribute EnclosureCreateForm form) {
        enclosureService.create(form);
        return "redirect:/admin/enclosures";
    }

    @GetMapping("/over-loaded")
    public String showOverLoadedEnclosures(Model model) {
        model.addAttribute("overLoadedEnclosures", enclosureService.findOverLoadedEnclosures());
        return "over_loaded_enclosures_page";
    }


}
