package com.prueba.miapp.api;

import java.util.List;
import java.util.Optional;

import com.prueba.miapp.model.Rol;

public interface RolServiceAPI {
    List<Rol> obtenerTodosLosRoles();
    Optional<Rol> obtenerRolPorId(Long id);
    List<Rol> obtenerRolPorNombre(String nombreRol);
    Rol guardarRol(Rol rol);
    Rol actualizarRol(Rol rol);
    void eliminarRol(Long id);
}
