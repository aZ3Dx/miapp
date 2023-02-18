package com.prueba.miapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.miapp.api.RolServiceAPI;
import com.prueba.miapp.model.Rol;
import com.prueba.miapp.repository.RolRepository;

@Service
public class RolService implements RolServiceAPI {

    @Autowired
    private RolRepository rolRepository;
    
    @Override
    public List<Rol> obtenerTodosLosRoles() {
        List<Rol> roles = rolRepository.findAll();
        return roles;
    }

    @Override
    public Optional<Rol> obtenerRolPorId(Long id) {
        Optional<Rol> rol = rolRepository.findById(id);
        return rol;
    }

    @Override
    public List<Rol> obtenerRolPorNombre(String nombreRol) {
        List<Rol> roles = rolRepository.findByNombreRol(nombreRol);
        return roles;
    }

    @Override
    public Rol guardarRol(Rol rol) {
        Rol rolGuardado = rolRepository.save(rol);
        return rolGuardado;
    }

    @Override
    public Rol actualizarRol(Rol rol) {
        Rol rolActualizado = rolRepository.save(rol);
        return rolActualizado;
    }

    @Override
    public void eliminarRol(Long id) {
        rolRepository.deleteById(id);
    }
    
}
