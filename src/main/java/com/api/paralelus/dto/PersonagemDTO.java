package com.api.paralelus.dto;


import java.util.List;


public record PersonagemDTO(
        Integer id,
        UsuarioDTO usuario,
        String nome,
        RacaDTO raca,
        List<CaminhoDTO> caminhos,
        List<ArquetipoDTO> arquetipos,
        List<PericiaDTO> pericias,
        AtributosDTO atributos,
        SingularidadeDTO singularidade,
        Integer vidaMax,
        Integer vidaAtual,
        Integer energiaMax,
        Integer energiaAtual,
        Integer defesa,
        String inventario,
        String cibernetica,
        String historia,
        String imagemBase64,
        Integer level,
        String caracteristica
) {
}