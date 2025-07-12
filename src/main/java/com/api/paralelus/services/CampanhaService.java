package com.api.paralelus.services;

import com.api.paralelus.entity.Campanha;
import com.api.paralelus.dto.CampanhaDTO;
import com.api.paralelus.mappers.CampanhaMapper;
import com.api.paralelus.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    @Autowired
    private CampanhaMapper campanhaMapper;

    public List<CampanhaDTO> getCampanhas() {
        var campanhas = this.campanhaRepository.findAll();
        return campanhas.stream().map(campanhaMapper::toDTO).toList();
    }

    public List<CampanhaDTO> getCampanhasAtivas() {
        var campanhas = this.campanhaRepository.findByAtivaTrue();
        return campanhas.stream().map(campanhaMapper::toDTO).collect(Collectors.toList());
    }

    public CampanhaDTO criarCamanha(CampanhaDTO dto){
        Campanha campanha = campanhaMapper.toEntity(dto);
        campanhaRepository.save(campanha);
        return campanhaMapper.toDTO(campanha);
    }
}
