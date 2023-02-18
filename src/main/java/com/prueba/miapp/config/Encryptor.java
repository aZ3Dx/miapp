package com.prueba.miapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Encryptor implements CommandLineRunner {
    
    @Autowired
    private SecurityBeans securityBeans;

    @Override
    public void run(String... args) throws Exception {
        String password = "1234";
        System.out.println(securityBeans.passwordEncoder().encode(password));
    }

}
