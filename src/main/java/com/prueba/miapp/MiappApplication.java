package com.prueba.miapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
	org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class MiappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiappApplication.class, args);
	}

}
