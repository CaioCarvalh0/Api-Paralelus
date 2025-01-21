package com.api.paralelus.models.mappers;

import com.api.paralelus.models.Campanha;
import com.api.paralelus.models.dto.CampanhaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CampanhaMapper {

    CampanhaDTO toDTO(Campanha campanha);

    Campanha toEntity(CampanhaDTO campanhaDTO);
}
