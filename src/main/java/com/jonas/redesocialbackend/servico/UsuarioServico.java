package com.jonas.redesocialbackend.servico;

import com.jonas.redesocialbackend.dominio.Usuario;
import com.jonas.redesocialbackend.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServico implements UserDetailsService {

    private final UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioRepositorio.findById(id).get();
    }

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepositorio.findByLogin(username);
    }

    public UserDetails findByLogin(String login) {
        return usuarioRepositorio.findByLogin(login);
    }
}
