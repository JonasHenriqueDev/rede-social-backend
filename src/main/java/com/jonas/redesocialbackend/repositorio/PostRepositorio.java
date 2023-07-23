package com.jonas.redesocialbackend.repositorio;

import com.jonas.redesocialbackend.dominio.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositorio extends JpaRepository<Post, Long> {

}
