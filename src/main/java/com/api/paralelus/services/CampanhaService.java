package com.api.paralelus.services;

import com.api.paralelus.entity.Campanha;
import com.api.paralelus.dto.CampanhaDTO;
import com.api.paralelus.mappers.CampanhaMapper;
import com.api.paralelus.repository.CampanhaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CampanhaService {

    private final CampanhaRepository campanhaRepository;

    private final CampanhaMapper campanhaMapper;

    private final FileStorageService storageService;

    public List<CampanhaDTO> getCampanhas() {
        var campanhas = this.campanhaRepository.findAll();
        return campanhas.stream().map(campanhaMapper::toDTO).toList();
    }

    public List<CampanhaDTO> getCampanhasAtivas() {
        var campanhas = this.campanhaRepository.findByAtivaTrue();
        return campanhas.stream().map(campanhaMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public CampanhaDTO criarCampanha(CampanhaDTO dto) {
        Campanha campanha = campanhaMapper.toEntity(dto);
        return campanhaMapper.toDTO(campanhaRepository.save(campanha));
    }

    @Transactional
    public String salvarCapa(Integer id, MultipartFile file) {
        Campanha campanha = campanhaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        try {
            String url = storageService.salvarArquivo(file, "campanhas", id + ".png");
            campanha.setCapa(url);
            campanhaRepository.save(campanha);
            return url;
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao salvar capa", e);
        }
    }
}
