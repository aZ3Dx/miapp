package com.prueba.miapp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prueba.miapp.model.Rol;
import com.prueba.miapp.model.Usuario;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    // @Autowired
    // private SecurityBeans securityBeans;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.obtenerUsuarioPorNombreUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        Rol rol = usuario.getRol();
        String nombreRol = rol.getNombreRol();
        GrantedAuthority authority = new SimpleGrantedAuthority(nombreRol);
        List<GrantedAuthority> authorities = Collections.singletonList(authority);
        return User.builder()
                .username(usuario.getNombreUsuario())
                .password(usuario.getCredencial())
                .authorities(authorities)
                .build();
        // return User.withUsername(usuario.getNombreUsuario())
        //         .password(securityBeans.passwordEncoder().encode(usuario.getCredencial()))
        //         .roles(nombreRol)
        //         .build();
        // return new User(usuario.getNombreUsuario() , usuario.getCredencial(), getAuthorities(usuario));
    }

    // private Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
    //     List<GrantedAuthority> authorities = new ArrayList<>();
    //     // for (Rol rol : usuario.getRol()) {
    //     //     authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.getNombreRol()));
    //     // }
    //     Rol rol = usuario.getRol();
    //     String nombreRol = "ROLE_" + rol.getNombreRol();
    //     authorities.add(new SimpleGrantedAuthority(nombreRol));
    //     return authorities;
    // }

}
