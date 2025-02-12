package com.api.paralelus.services;

import com.api.paralelus.models.Raca;
import com.api.paralelus.models.dto.RacaDTO;
import com.api.paralelus.models.mappers.RacaMapper;
import com.api.paralelus.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacaService {

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private RacaMapper racaMapper;

    public List<RacaDTO> getRacas() {
        var racas = this.racaRepository.findAll();
        return racas.stream().map(racaMapper::toDTO).toList();
    }
}
