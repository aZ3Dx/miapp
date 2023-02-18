package com.prueba.miapp.controller.home;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@PreAuthorize("hasRole('Administrador') or hasRole('Cliente')")
@Controller
public class DashboardController {
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        System.out.println("Mostrando dashboard");
        return "dashboard";
    }
    
    // @GetMapping("/dashboard/usuarios")
    // public String usuarios() {
    //     return "dashboard/usuarios";
    // }
    
    // @GetMapping("/dashboard/info")
    // public String info() {
    //     return "dashboard/info";
    // }

}
