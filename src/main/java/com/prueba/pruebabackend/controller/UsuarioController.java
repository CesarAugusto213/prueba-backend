package com.prueba.pruebabackend.controller;

import com.prueba.pruebabackend.model.Usuario;
import com.prueba.pruebabackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> getUsuarios(){
        return usuarioService.listarUsuario();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable int id){

        Usuario usuario = usuarioService.buscarUsuario(id).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado: " + id)
        );

        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/usuario")
    public Usuario agregar(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/usuario")
    public ResponseEntity<Usuario> actualizar(@RequestBody Usuario usuarioBody){
        Usuario usuario = usuarioService.buscarUsuario(usuarioBody.getId_user()).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado: " + usuarioBody.getId_user())
        );
        usuario.setId_user(usuarioBody.getId_user());
        usuario.setTx_uid(usuarioBody.getTx_uid());
        usuario.setTx_user(usuarioBody.getTx_user());
        usuario.setTx_email(usuarioBody.getTx_email());
        usuario.setTx_pass(usuarioBody.getTx_pass());
        usuario.setTx_rol(usuarioBody.getTx_rol());
        usuario.setTx_fullname(usuarioBody.getTx_fullname());
        usuario.setTx_avatar(usuario.getTx_avatar());

        Usuario response = usuarioService.guardarUsuario(usuario);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/usuario/{id}")
    public void eliminar(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
    }

}
