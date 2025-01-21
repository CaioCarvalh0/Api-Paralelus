package com.api.paralelus.models.mappers;

import com.api.paralelus.models.Arquetipo;
import com.api.paralelus.models.dto.ArquetipoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArquetipoMapper {

    ArquetipoDTO toDTO(Arquetipo arquetipo);

    Arquetipo toEntity(ArquetipoDTO arquetipoDTO);
}
