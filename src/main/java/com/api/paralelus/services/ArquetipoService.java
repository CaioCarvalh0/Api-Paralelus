package com.api.paralelus.services;

import com.api.paralelus.models.dto.ArquetipoDTO;
import com.api.paralelus.models.mappers.ArquetipoMapper;
import com.api.paralelus.repository.ArquetipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArquetipoService {

    @Autowired
    private ArquetipoRepository arquetipoRepository;

    @Autowired
    private ArquetipoMapper arquetipoMapper;

    public List<ArquetipoDTO> getArquetipos(){
        var arquetipos = this.arquetipoRepository.findAll();
        return arquetipos.stream().map(arquetipoMapper::toDTO).toList();
    }


}
