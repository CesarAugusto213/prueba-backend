package com.prueba.pruebabackend.service;

import com.prueba.pruebabackend.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listarUsuario();
    Usuario guardarUsuario(Usuario usuario);
    Optional<Usuario> buscarUsuario(Integer id);
    void eliminarUsuario(Integer id);
}
