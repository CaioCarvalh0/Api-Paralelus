package com.api.paralelus.models.mappers;

import com.api.paralelus.models.Caminho;
import com.api.paralelus.models.dto.CaminhoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CaminhoMapper {

    CaminhoDTO toDTO(Caminho caminho);

    Caminho toEntity(CaminhoDTO caminhoDTO);
}
