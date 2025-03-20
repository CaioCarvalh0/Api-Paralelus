package com.api.paralelus.models.mappers;

import com.api.paralelus.models.*;
import com.api.paralelus.models.dto.ArquetipoDTO;
import com.api.paralelus.models.dto.CaminhoDTO;
import com.api.paralelus.models.dto.PericiaDTO;
import com.api.paralelus.models.dto.SalvarPersonagemDTO;
import com.api.paralelus.models.mappers.ArquetipoMapper;
import com.api.paralelus.models.mappers.PericiaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface SalvarPersonagemMapper {

    @Mapping(target = "personagemPericias", ignore = true)
    @Mapping(target = "personagemCaminhos", source = "caminho")
    @Mapping(target = "energiaAtual", source = "energiaAtual")
    @Mapping(target = "personagemArquetipos", source = "arquetipo")
    @Mapping(source = "imagemBase64", target = "imagem", qualifiedByName = "base64ParaBytes")
    Personagem toEntity(SalvarPersonagemDTO dto);

    @Mapping(target = "pericias", expression = "java(ordenaPericias(entity.getPersonagemPericias()))")
    @Mapping(target = "arquetipo", source = "personagemArquetipos")
    @Mapping(target = "caminho", source = "personagemCaminhos")
    @Mapping(target = "energiaAtual", source = "energiaAtual")
    @Mapping(source = "imagem", target = "imagemBase64", qualifiedByName = "bytesParaBase64")
    SalvarPersonagemDTO toDTO(Personagem entity);

    default List<PericiaDTO> ordenaPericias(Set<PersonagemPericia> personagemPericias) {
        return personagemPericias.stream()
                .sorted(Comparator.comparing(pp -> pp.getPericia().getId()))
                .map(this::toPericiaDTO)
                .collect(Collectors.toList());
    }

    @Mapping(target = "id", source = "pericia.id")
    @Mapping(target = "nome", source = "pericia.nome")
    PericiaDTO toPericiaDTO(PersonagemPericia personagemPericia);

//    @Mapping(target = "id", source = "pericia.id")
//    @Mapping(target = "nome", source = "pericia.nome")
//    @Mapping(target = "pontos", source = "pontos")
//    default PericiaDTO personagemPericiaToPericiaDTO(PersonagemPericia personagemPericia) {
//        if (personagemPericia.getPericia() == null) {
//            System.out.println("Pericia está nula para PersonagemPericia com ID: " + personagemPericia.getId());
//            return null; // ou retornar um PericiaDTO com valores padrão, caso necessário
//        }
//        return new PericiaDTO(personagemPericia.getPericia().getId(), personagemPericia.getPericia().getNome(), personagemPericia.getPontos());
//    }

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "pericia.id", source = "id")
//    @Mapping(target = "pericia.nome", source = "nome")
//    @Mapping(target = "pontos", source = "pontos")
//    default PersonagemPericia periciaDTOToPersonagemPericia(PericiaDTO periciaDTO) {
//
//        PersonagemPericia personagemPericia = new PersonagemPericia();
//        personagemPericia.setPericia(new Pericia(periciaDTO.id(), periciaDTO.nome()));
//        personagemPericia.setPontos(periciaDTO.pontos());
//        return personagemPericia;
//    }

//    @Named("periciaDTOListToPersonagemPericiaSet")
//    default Set<PersonagemPericia> periciaDTOListToPersonagemPericiaSet(List<PericiaDTO> pericias) {
//        if (pericias == null) {
//            return new HashSet<>();
//        }
//        System.out.println("Convertendo lista de PericiaDTO para PersonagemPericia...");
//        pericias.forEach(periciaDTO -> System.out.println("Converting PericiaDTO: " + periciaDTO));
//        return pericias.stream()
//                .map(this::periciaDTOToPersonagemPericia)
//                .collect(Collectors.toSet());
//    }

    @Named("base64ParaBytes")
    static byte[] base64ParaBytes(String base64) {
        return base64 != null ? Base64.getDecoder().decode(base64) : null;
    }

    @Named("bytesParaBase64")
    static String bytesParaBase64(byte[] bytes) {
        return bytes != null ? Base64.getEncoder().encodeToString(bytes) : null;
    }

    default byte[] map(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return Base64.getDecoder().decode(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    default String map(byte[] value) {
        return value != null ? Base64.getEncoder().encodeToString(value) : null;
    }


}
