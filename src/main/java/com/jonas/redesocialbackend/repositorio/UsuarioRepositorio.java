package com.jonas.redesocialbackend.repositorio;

import com.jonas.redesocialbackend.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
