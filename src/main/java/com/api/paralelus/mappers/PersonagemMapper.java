package com.api.paralelus.mappers;

import com.api.paralelus.entity.*;
import com.api.paralelus.dto.PericiaDTO;
import com.api.paralelus.dto.PersonagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PersonagemMapper {

    @Mapping(source = "imagemBase64", target = "imagem", qualifiedByName = "base64ParaBytes")
    Personagem toEntity(PersonagemDTO dto);

    @Mapping(target = "pericias", expression = "java(ordenaPericias(entity.getPericias()))")
    @Mapping(source = "imagem", target = "imagemBase64", qualifiedByName = "bytesParaBase64")
    PersonagemDTO toDTO(Personagem entity);

    default List<PericiaDTO> ordenaPericias(Set<PersonagemPericia> personagemPericias) {
        return personagemPericias.stream()
                .sorted(Comparator.comparing(pp -> pp.getPericia().getId()))
                .map(this::toPericiaDTO)
                .collect(Collectors.toList());
    }

    @Mapping(target = "id", source = "pericia.id")
    @Mapping(target = "nome", source = "pericia.nome")
    PericiaDTO toPericiaDTO(PersonagemPericia personagemPericia);


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
