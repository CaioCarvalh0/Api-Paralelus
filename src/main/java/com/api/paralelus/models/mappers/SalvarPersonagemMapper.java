package com.api.paralelus.models.mappers;

import com.api.paralelus.models.Personagem;
import com.api.paralelus.models.dto.SalvarPersonagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Base64;

@Mapper(componentModel = "spring")
public interface SalvarPersonagemMapper {

    @Mapping(target = "personagemPericias", source = "pericias")
    @Mapping(target = "imagem", source = "imagemBase64")
    Personagem toEntity(SalvarPersonagemDTO dto);

    @Mapping(target = "pericias", source = "personagemPericias")
    @Mapping(target = "imagemBase64", source = "imagem")
    SalvarPersonagemDTO toDTO(Personagem entity);


    default byte[] map(String value) {
        return value != null ? Base64.getDecoder().decode(value) : null;
    }

    default String map(byte[] value) {
        return value != null ? Base64.getEncoder().encodeToString(value) : null;
    }
}
