package com.prueba.miapp.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        System.out.println("Mostrando formulario de login");
        return "login";
    }

    @PostMapping("/login")
    public String login() {
        System.out.println("Procesando formulario de login");
        return "redirect:/dashboard";
    }

    @GetMapping("/logout")
    public String logout() {
        // Manejar la lógica de logout
        return "redirect:/";
    }

}
