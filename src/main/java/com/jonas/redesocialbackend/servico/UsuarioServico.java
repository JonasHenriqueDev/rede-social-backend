package com.jonas.redesocialbackend.servico;

import com.jonas.redesocialbackend.dominio.Usuario;
import com.jonas.redesocialbackend.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    public Usuario findUsuarioById(UUID id) {
        return usuarioRepositorio.findById(id).get();
    }

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

}
