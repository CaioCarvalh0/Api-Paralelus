package com.api.paralelus.services;

import com.api.paralelus.models.Personagem;
import com.api.paralelus.models.dto.SalvarPersonagemDTO;
import com.api.paralelus.models.mappers.SalvarPersonagemMapper;
import com.api.paralelus.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private SalvarPersonagemMapper salvarPersonagemMapper;


    public SalvarPersonagemDTO getPersonagem(Integer id){
        Personagem personagem = personagemRepository.findByUsuarioId(id).orElse(null);

        if (personagem == null) {
            var vazio = new Personagem();
            vazio.setId(0);
            return salvarPersonagemMapper.toDTO(vazio);
        }
        return salvarPersonagemMapper.toDTO(personagem);
    }

    public Personagem salvarPersonagem(SalvarPersonagemDTO dto){
        var personagem = salvarPersonagemMapper.toEntity(dto);
        Personagem personagemExistente = this.personagemRepository.findByIdAndUsuarioId(personagem.getId(), personagem.getUsuario().getId());
        if(personagemExistente != null){
            personagem.setId(personagemExistente.getId());
        }
        return this.personagemRepository.save(personagem);
    }
}
