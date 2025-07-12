package com.api.paralelus.dto;

import java.util.List;

public record CampanhaDTO(
        Integer id,
        String nome,
        UsuarioDTO mestre,
        Integer nivel,
        Boolean ativa,
        String introducao,
        List<PersonagemDTO> jogadores,
        String capaBase64
) {
}
