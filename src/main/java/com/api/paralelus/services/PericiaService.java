package com.api.paralelus.services;

import com.api.paralelus.models.dto.PericiaDTO;
import com.api.paralelus.models.mappers.PericiaMapper;
import com.api.paralelus.repository.PericiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PericiaService {

    @Autowired
    private PericiaRepository periciaRepository;

    @Autowired
    private PericiaMapper periciaMapper;

    public List<PericiaDTO> getPericias(){
        var pericias = this.periciaRepository.findAll();
        return pericias.stream().map(periciaMapper::toDTO).toList();
    }
}
