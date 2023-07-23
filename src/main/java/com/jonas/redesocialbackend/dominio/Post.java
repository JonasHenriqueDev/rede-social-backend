package com.jonas.redesocialbackend.dominio;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String titulo;

    @Column(length = 280, nullable = false)
    private String conteudo;

    @Column(nullable = false)
    private Boolean isPrivado = false;

    private Integer likes;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

}
