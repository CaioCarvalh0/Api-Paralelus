package com.api.paralelus.services;

import com.api.paralelus.dto.ArquetipoDTO;
import com.api.paralelus.mappers.ArquetipoMapper;
import com.api.paralelus.repository.ArquetipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArquetipoService {

    private final ArquetipoRepository arquetipoRepository;

    private final ArquetipoMapper arquetipoMapper;

    public List<ArquetipoDTO> getArquetipos(){
        var arquetipos = this.arquetipoRepository.findAll();
        return arquetipos.stream().map(arquetipoMapper::toDTO).toList();
    }


}
