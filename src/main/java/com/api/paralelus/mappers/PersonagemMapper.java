package com.api.paralelus.mappers;

import com.api.paralelus.entity.*;
import com.api.paralelus.dto.PericiaDTO;
import com.api.paralelus.dto.PersonagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PersonagemMapper {

    @Mapping(source = "imagemUrl", target = "imagem")
    Personagem toEntity(PersonagemDTO dto);

    @Mapping(target = "pericias", expression = "java(ordenaPericias(entity.getPericias()))")
    @Mapping(source = "imagem", target = "imagemUrl")
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



}
