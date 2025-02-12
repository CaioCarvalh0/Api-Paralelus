package com.api.paralelus.models.dto;

import com.api.paralelus.models.Atributos;
import lombok.Getter;

import java.util.List;


public record SalvarPersonagemDTO(
        Integer id,
        UsuarioDTO usuario,
        String nome,
        RacaDTO raca,
        List<CaminhoDTO> caminho,
        List<ArquetipoDTO> arquetipo,
        List<PericiaDTO> pericias,
        AtributosDTO atributos,
        Integer vidaMax,
        Integer vidaAtual,
        Integer energiaMax,
        Integer energiaAtual,
        Integer defesa,
        String inventario,
        String imagemBase64
) {
}