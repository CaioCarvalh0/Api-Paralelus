package com.api.paralelus.models.mappers;

import com.api.paralelus.models.Pericia;
import com.api.paralelus.models.dto.PericiaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PericiaMapper {

    PericiaDTO toDTO(Pericia pericia);

    Pericia toEntity(PericiaDTO periciaDTO);
}
