package com.api.paralelus.mappers;

import com.api.paralelus.entity.Campanha;
import com.api.paralelus.dto.CampanhaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;

@Mapper(componentModel = "spring")
public interface CampanhaMapper {

    @Mapping(source = "capa", target = "capaBase64", qualifiedByName = "bytesParaBase64")
    @Mapping(source = "jogadoresCampanha", target = "jogadores")
    CampanhaDTO toDTO(Campanha campanha);

    @Mapping(source = "capaBase64", target = "capa", qualifiedByName = "base64ParaBytes")
    @Mapping(source = "jogadores", target = "jogadoresCampanha")
    Campanha toEntity(CampanhaDTO campanhaDTO);

    @Named("base64ParaBytes")
    static byte[] base64ParaBytes(String base64) {
        return base64 != null ? Base64.getDecoder().decode(base64) : null;
    }

    @Named("bytesParaBase64")
    static String bytesParaBase64(byte[] bytes) {
        return bytes != null ? Base64.getEncoder().encodeToString(bytes) : null;
    }
}
