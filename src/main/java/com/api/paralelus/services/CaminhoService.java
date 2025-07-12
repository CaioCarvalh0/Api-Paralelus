package com.api.paralelus.services;

import com.api.paralelus.dto.CaminhoDTO;
import com.api.paralelus.mappers.CaminhoMapper;
import com.api.paralelus.repository.CaminhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaminhoService {

    @Autowired
    private CaminhoRepository caminhoRepository;

    @Autowired
    private CaminhoMapper caminhoMapper;

    public List<CaminhoDTO> getCaminhos(){
        var caminhos = this.caminhoRepository.findAll();
        return caminhos.stream().map(caminhoMapper::toDTO).toList();
    }
}
