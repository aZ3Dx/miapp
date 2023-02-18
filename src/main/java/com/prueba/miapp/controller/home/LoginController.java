package com.prueba.miapp.controller.home;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prueba.miapp.service.CustomUserDetailsService;

@Controller
public class LoginController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/login")
    public String showLoginForm() {
        System.out.println("Mostrando formulario de login");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/dashboard/inicio";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        System.out.println("Procesando formulario de login");

        try {
            // Manejar la lógica de login
            UserDetails user = customUserDetailsService.loadUserByUsername(username);

            if (user != null && new BCryptPasswordEncoder().matches(password, user.getPassword())) {
                // Crea un objeto de autenticación y lo guarda en la sesión del usuario
                Authentication authentication = new UsernamePasswordAuthenticationToken(user, null,
                        user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                        SecurityContextHolder.getContext());
                // Imprimir el usuario autenticado y su rol
                System.out.println("Usuario autenticado: " + user.getUsername());
                System.out.println("Rol del usuario: " + user.getAuthorities());
                return "redirect:/dashboard/inicio";
            } else {
                return "redirect:/login?error";
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "redirect:/login?error";
        }

    }

    @GetMapping("/logout")
    public String logout() {
        System.out.println("Procesando logout");
        return "redirect:/";
    }

}
