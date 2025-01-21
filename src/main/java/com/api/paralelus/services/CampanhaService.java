package com.api.paralelus.services;

import com.api.paralelus.models.dto.CampanhaDTO;
import com.api.paralelus.models.mappers.CampanhaMapper;
import com.api.paralelus.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
