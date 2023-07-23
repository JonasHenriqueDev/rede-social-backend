package com.jonas.redesocialbackend.dominio.dto;

import com.jonas.redesocialbackend.dominio.enums.CargoUsuario;

public record CadastroDTO(String login, String password, CargoUsuario cargo) {
}
