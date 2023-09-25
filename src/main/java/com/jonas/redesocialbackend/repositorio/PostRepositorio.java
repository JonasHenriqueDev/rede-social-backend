package com.jonas.redesocialbackend.repositorio;

import com.jonas.redesocialbackend.dominio.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositorio extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.usuario.id = :id")
    List<Post> findPostsByUsuario(@Param("id") Long id);
}
