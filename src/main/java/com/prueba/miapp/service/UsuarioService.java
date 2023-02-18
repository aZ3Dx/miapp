package com.prueba.miapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.miapp.api.UsuarioServiceAPI;
import com.prueba.miapp.model.Usuario;
import com.prueba.miapp.repository.UsuarioRepository;

@Service
public class UsuarioService implements UsuarioServiceAPI {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioGuardado;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        return usuarioActualizado;
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        return usuario;
    }
    
}
