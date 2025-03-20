package com.api.paralelus.models.dto;

public record SingularidadeDTO(
        Integer id,
        Integer criacao,
        Integer manipulacao,
        Integer ampliacao ,
        Integer difusao,
        Integer corporeo,
        Integer espacial,
        String descricao
) {
}
