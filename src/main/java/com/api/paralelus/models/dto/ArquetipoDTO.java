package com.api.paralelus.models.dto;

import com.api.paralelus.models.Caminho;

public record ArquetipoDTO(
        Integer id,
        String nome,
        Caminho caminho
) {
}
