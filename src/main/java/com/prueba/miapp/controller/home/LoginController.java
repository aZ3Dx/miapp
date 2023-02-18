package com.prueba.miapp.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        System.out.println("Mostrando formulario de login");
        return "login";
    }

    @PostMapping("/login")
    public String login() {
        System.out.println("Procesando formulario de login");

        // Manejar la lógica de login
        User user = userService.findByUsername(username);

        return "redirect:/dashboard/inicio";
    }

    @GetMapping("/logout")
    public String logout() {
        // Manejar la lógica de logout
        return "redirect:/";
    }

}
