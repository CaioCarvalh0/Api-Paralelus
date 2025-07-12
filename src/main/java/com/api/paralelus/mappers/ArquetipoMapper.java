package com.api.paralelus.mappers;

import com.api.paralelus.entity.Arquetipo;
import com.api.paralelus.dto.ArquetipoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArquetipoMapper {

    ArquetipoDTO toDTO(Arquetipo arquetipo);

    Arquetipo toEntity(ArquetipoDTO arquetipoDTO);
}
