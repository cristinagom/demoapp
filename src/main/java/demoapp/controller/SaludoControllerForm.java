package demoapp.controller;

import demoapp.dto.UserData;
import demoapp.service.SaludoService;
import demoapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class SaludoControllerForm {

    @Autowired
    private SaludoService service;

    @Autowired
    private UserService userService;

    @GetMapping("/saludoform")
    // Hay que declarar un parámetro con el tipo usado en el modelo del formulario (UserData)
    public String saludoForm(UserData userData) {
        return "formRegistro";
    }

    @PostMapping("/saludoform")
    public String checkPersonInfo(@ModelAttribute @Valid UserData userData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "formRegistro";
        }
        userService.save(userData.getNombre());
        model.addAttribute("mensaje", service.saluda(userData.getNombre()));
        return "saludo";
    }
}

