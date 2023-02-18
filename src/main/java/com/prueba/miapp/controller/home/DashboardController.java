package com.prueba.miapp.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
    
    @GetMapping("/dashboard/usuarios")
    public String usuarios() {
        return "dashboard/usuarios";
    }
    
    @GetMapping("/dashboard/info")
    public String info() {
        return "dashboard/info";
    }

}
