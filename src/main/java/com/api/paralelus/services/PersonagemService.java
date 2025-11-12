package com.api.paralelus.services;

import com.api.paralelus.dto.PericiaDTO;
import com.api.paralelus.dto.PersonagemDTO;
import com.api.paralelus.entity.Campanha;
import com.api.paralelus.entity.Pericia;
import com.api.paralelus.entity.Personagem;
import com.api.paralelus.entity.PersonagemPericia;
import com.api.paralelus.mappers.PersonagemMapper;
import com.api.paralelus.repository.PericiaRepository;
import com.api.paralelus.repository.PersonagemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonagemService {

    private final PersonagemRepository personagemRepository;

    private final PersonagemMapper personagemMapper;

    private final PericiaRepository periciaRepository;

    private final FileStorageService storageService;

    public List<PersonagemDTO> getPersonagensUsuario(Integer id){
        List<Personagem> personagem = personagemRepository.findByUsuarioId(id);
        return personagem.stream().map(personagemMapper::toDTO).collect(Collectors.toList());
    }

    public PersonagemDTO salvarPersonagem(PersonagemDTO dto) {
        Personagem personagem = personagemMapper.toEntity(dto);

        Personagem personagemExistente = this.personagemRepository.findByIdAndUsuarioId(personagem.getId(), personagem.getUsuario().getId());
        if (personagemExistente != null) {
            personagem.setId(personagemExistente.getId());
        }

        Set<PersonagemPericia> personagemPericias = new HashSet<>();
        for (PericiaDTO periciaDTO : dto.pericias()) {
            Pericia pericia = periciaRepository.findById(periciaDTO.id())
                    .orElseThrow(() -> new RuntimeException("Perícia não encontrada"));

            PersonagemPericia personagemPericia = new PersonagemPericia();
            if(personagemExistente != null){
                Optional<PersonagemPericia> personagemPericiaExistente = personagemExistente.getPericias().stream()
                        .filter(p -> p.getPericia().getId().equals(periciaDTO.id()))
                        .findFirst();
                personagemPericiaExistente.ifPresent(value -> personagemPericia.setId(value.getId()));
            }
            personagemPericia.setPersonagem(personagem);
            personagemPericia.setPericia(pericia);
            personagemPericia.setPontos(periciaDTO.pontos());

            personagemPericias.add(personagemPericia);
        }
        personagem.setPericias(personagemPericias);

        Personagem personagemSalvo = personagemRepository.save(personagem);

        return personagemMapper.toDTO(personagemSalvo);
    }

    @Transactional
    public String salvarImagem(Integer id, MultipartFile file) {
        Personagem personagem = personagemRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        try {
            String url = storageService.salvarArquivo(file, "personagem", id + ".png");
            personagem.setImagem(url);
            personagemRepository.save(personagem);
            return url;
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao salvar capa", e);
        }
    }
//    public void deletePersonagem(Integer id) {
//        Optional<Personagem> personagem = personagemRepository.findById(id);
//        personagem.ifPresent(value -> personagemRepository.delete(value));
//    }

}
