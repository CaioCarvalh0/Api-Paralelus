package com.api.paralelus.services;

import com.api.paralelus.dto.RacaDTO;
import com.api.paralelus.mappers.RacaMapper;
import com.api.paralelus.repository.RacaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RacaService {

    private final RacaRepository racaRepository;

    private final RacaMapper racaMapper;

    public List<RacaDTO> getRacas() {
        var racas = this.racaRepository.findAll();
        return racas.stream().map(racaMapper::toDTO).toList();
    }
}
