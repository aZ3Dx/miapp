package com.prueba.miapp.api;

import java.util.List;
import java.util.Optional;

import com.prueba.miapp.model.Usuario;

public interface UsuarioServiceAPI {
    List<Usuario> obtenerTodosLosUsuarios();
    Optional<Usuario> obtenerUsuarioPorId(Long id);
    Usuario guardarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);
    Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario);
}
