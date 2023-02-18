package com.prueba.miapp.controller.home;

import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@PreAuthorize("hasRole('Administrador') or hasRole('Cliente')")
@Controller
public class DashboardController {
    
    @GetMapping("/dashboard/inicio")
    public String dashboard(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        Set<String> roles = AuthorityUtils.authorityListToSet(userDetails.getAuthorities());
    
        model.addAttribute("username", username);
        model.addAttribute("roles", roles);
    
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
