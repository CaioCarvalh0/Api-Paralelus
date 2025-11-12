package com.api.paralelus.mappers;

import com.api.paralelus.entity.Campanha;
import com.api.paralelus.dto.CampanhaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;

@Mapper(componentModel = "spring")
public interface CampanhaMapper {

    @Mapping(source = "capa", target = "capaUrl")
    @Mapping(source = "jogadoresCampanha", target = "jogadores")
    CampanhaDTO toDTO(Campanha campanha);

    @Mapping(source = "capaUrl", target = "capa")
    @Mapping(source = "jogadores", target = "jogadoresCampanha")
    Campanha toEntity(CampanhaDTO campanhaDTO);

}
