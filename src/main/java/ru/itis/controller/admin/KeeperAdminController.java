package ru.itis.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.form.KeeperCreateForm;
import ru.itis.model.Keeper;
import ru.itis.service.KeeperService;

import java.util.List;

@Controller
@RequestMapping("/admin/keepers")
@RequiredArgsConstructor
public class KeeperAdminController {

    private final KeeperService keeperService;

    @GetMapping()
    public String showAddForm(Model model) {
        List<Keeper> keeperList = keeperService.findAll();

        model.addAttribute("keepers", keeperList);

        return "keepers_page";
    }

    @PostMapping()
    public String create(@ModelAttribute KeeperCreateForm form) {
        keeperService.create(form);
        return "redirect:/admin/keepers";
    }
}