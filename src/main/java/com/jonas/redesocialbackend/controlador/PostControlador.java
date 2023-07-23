package com.jonas.redesocialbackend.controlador;

import com.jonas.redesocialbackend.dominio.Post;
import com.jonas.redesocialbackend.dominio.Usuario;
import com.jonas.redesocialbackend.servico.PostServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")

@RequiredArgsConstructor
public class PostControlador {

    private final PostServico postServico;

    @GetMapping
    public List<Post> listar() {
        return postServico.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> listarPorId(@PathVariable("id") Long id) {
        Post entity = postServico.findPostById(id);
        return ResponseEntity.ok(entity);
    }

    //Temporário
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post adicionar(@RequestBody Post post) {
        return postServico.salvarPost(post);
    }
}
