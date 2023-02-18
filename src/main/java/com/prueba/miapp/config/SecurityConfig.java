package com.prueba.miapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.prueba.miapp.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private SecurityBeans securityBeans;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.userDetailsService(userDetailsService);
        auth.userDetailsService(userDetailsService).passwordEncoder(securityBeans.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                // .antMatchers("/dashboard/usuarios/**").hasRole("ROLE_Administrador")
                // .antMatchers("/dashboard/**").hasAnyRole("Cliente", "Administrador")
                .anyRequest().authenticated()
                .and()
                .httpBasic().disable()
                .formLogin().disable()
                // .loginProcessingUrl("/login")
                // .successForwardUrl("/dashboard/inicio")
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();
    }

}
