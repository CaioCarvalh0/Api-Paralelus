package com.api.paralelus.models.dto;

public record CampanhaDTO(
        Integer id,
        String nome,
        UsuarioDTO mestre,
        Integer nivel,
        Boolean ativa) {
}
