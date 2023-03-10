package com.prueba.miapp.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        System.out.println("Mostrando home");
        return "home";
    }

    @GetMapping("/error")
    public String error() throws Exception {
        throw new Exception("Error en la aplicación");
    }

}
