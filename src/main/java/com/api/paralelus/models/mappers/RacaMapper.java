package com.api.paralelus.models.mappers;

import com.api.paralelus.models.Raca;
import com.api.paralelus.models.dto.RacaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RacaMapper {

    RacaDTO toDTO(Raca raca);

    Raca toEntity(RacaDTO racaDTO);
}
