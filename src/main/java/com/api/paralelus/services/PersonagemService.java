package com.api.paralelus.services;

import com.api.paralelus.models.Personagem;
import com.api.paralelus.models.dto.SalvarPersonagemDTO;
import com.api.paralelus.models.mappers.SalvarPersonagemMapper;
import com.api.paralelus.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private SalvarPersonagemMapper personagemMapper;


    public SalvarPersonagemDTO getPersonagem(Integer id){
        Personagem personagem = personagemRepository.findByUsuarioId(id).orElse(null);
        if (personagem == null) {
            var vazio = new Personagem();
            vazio.setId(0);
            return personagemMapper.toDTO(vazio);
        }
        return personagemMapper.toDTO(personagem);
    }

    public Personagem salvarPersonagem(SalvarPersonagemDTO dto){
        var personagem = personagemMapper.toEntity(dto);
        Personagem personagemExistente = this.personagemRepository.findByIdAndUsuarioId(personagem.getId(), personagem.getUsuario().getId());
        if (personagemExistente != null) {
            personagem.setId(personagemExistente.getId());
            var atributoID = personagemExistente.getAtributos().getId();
            personagem.getAtributos().setId(atributoID);
        }
        return personagemRepository.save(personagem);
    }

    public String getImagemPersonagem(Integer id) {
        Optional<Personagem> personagem = personagemRepository.findById(id);

        if (personagem.isEmpty() || personagem.get().getImagem() == null) {
            return null;
        }

        return "data:image/png;base64," + Base64.getEncoder().encodeToString(personagem.get().getImagem());
    }


}
