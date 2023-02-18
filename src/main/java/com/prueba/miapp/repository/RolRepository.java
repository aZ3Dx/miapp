package com.prueba.miapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.miapp.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    List<Rol> findByNombreRol (String nombreRol);
}
