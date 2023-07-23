package com.jonas.redesocialbackend.controlador;


import com.jonas.redesocialbackend.dominio.Usuario;
import com.jonas.redesocialbackend.repositorio.UsuarioRepositorio;
import com.jonas.redesocialbackend.servico.UsuarioServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuario")


@RequiredArgsConstructor
public class UsuarioControlador {

    private final UsuarioServico usuarioServico;

    @GetMapping("/listar")
    public List<Usuario> listar() {
        return usuarioServico.findAll();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable("id") UUID id) {
        Usuario entity = usuarioServico.findUsuarioById(id);
        return ResponseEntity.ok(entity);
    }

    //Temporário
    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionar(@RequestBody Usuario usuario) {
        return usuarioServico.salvarUsuario(usuario);
    }

}
