package com.api.paralelus.services;

import com.api.paralelus.dto.PericiaDTO;
import com.api.paralelus.mappers.PericiaMapper;
import com.api.paralelus.repository.PericiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PericiaService {

    private final PericiaRepository periciaRepository;

    private final PericiaMapper periciaMapper;

    public List<PericiaDTO> getPericias(){
        var pericias = this.periciaRepository.findAll();
        return pericias.stream().map(periciaMapper::toDTO).toList();
    }
}
