package com.api.paralelus.mappers;

import com.api.paralelus.entity.Caminho;
import com.api.paralelus.dto.CaminhoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CaminhoMapper {

    CaminhoDTO toDTO(Caminho caminho);

    Caminho toEntity(CaminhoDTO caminhoDTO);
}
