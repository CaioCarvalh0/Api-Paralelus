package com.api.paralelus.services;

import com.api.paralelus.dto.CaminhoDTO;
import com.api.paralelus.mappers.CaminhoMapper;
import com.api.paralelus.repository.CaminhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaminhoService {

    private final CaminhoRepository caminhoRepository;

    private final CaminhoMapper caminhoMapper;

    public List<CaminhoDTO> getCaminhos(){
        var caminhos = this.caminhoRepository.findAll();
        return caminhos.stream().map(caminhoMapper::toDTO).toList();
    }
}
