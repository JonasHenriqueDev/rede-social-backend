package com.jonas.redesocialbackend.controlador;


import com.jonas.redesocialbackend.dominio.Post;
import com.jonas.redesocialbackend.dominio.Usuario;
import com.jonas.redesocialbackend.servico.PostServico;
import com.jonas.redesocialbackend.servico.UsuarioServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")


@RequiredArgsConstructor
public class UsuarioControlador {

    private final UsuarioServico usuarioServico;
    private final PostServico postServico;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioServico.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Long id) {
        Usuario entity = usuarioServico.findUsuarioById(id);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> listarPostsPorId(@PathVariable("id") Long id) {
        List<Post> entity = postServico.findPostsById(id);
        return ResponseEntity.ok(entity);
    }

    //Temporário
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionar(@RequestBody Usuario usuario) {
        return usuarioServico.salvarUsuario(usuario);
    }
}
