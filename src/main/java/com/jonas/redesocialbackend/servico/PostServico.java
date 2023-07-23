package com.jonas.redesocialbackend.servico;

import com.jonas.redesocialbackend.dominio.Post;
import com.jonas.redesocialbackend.dominio.Usuario;
import com.jonas.redesocialbackend.repositorio.PostRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServico {

    private final PostRepositorio postRepositorio;

    public List<Post> findAll() {
       return postRepositorio.findAll();
    }

    public Post findPostById(Long id) {
        return postRepositorio.findById(id).get();
    }

    public Post salvarPost(Post post) {
        return postRepositorio.save(post);
    }
}
