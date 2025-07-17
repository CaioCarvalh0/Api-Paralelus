package com.api.paralelus.services;

import com.api.paralelus.entity.Campanha;
import com.api.paralelus.dto.CampanhaDTO;
import com.api.paralelus.mappers.CampanhaMapper;
import com.api.paralelus.repository.CampanhaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CampanhaService {

    private final CampanhaRepository campanhaRepository;

    private final CampanhaMapper campanhaMapper;

    public List<CampanhaDTO> getCampanhas() {
        var campanhas = this.campanhaRepository.findAll();
        return campanhas.stream().map(campanhaMapper::toDTO).toList();
    }

    public List<CampanhaDTO> getCampanhasAtivas() {
        var campanhas = this.campanhaRepository.findByAtivaTrue();
        return campanhas.stream().map(campanhaMapper::toDTO).collect(Collectors.toList());
    }

    public CampanhaDTO criarCamanha(CampanhaDTO dto) {
        Campanha campanha = campanhaMapper.toEntity(dto);
        return campanhaMapper.toDTO(campanhaRepository.save(campanha));
    }
}
