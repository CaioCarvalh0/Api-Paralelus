package com.api.paralelus.mappers;

import com.api.paralelus.entity.Raca;
import com.api.paralelus.dto.RacaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RacaMapper {

    RacaDTO toDTO(Raca raca);

    Raca toEntity(RacaDTO racaDTO);
}
