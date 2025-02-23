package com.api.paralelus.models.mappers;

import com.api.paralelus.models.*;
import com.api.paralelus.models.dto.ArquetipoDTO;
import com.api.paralelus.models.dto.CaminhoDTO;
import com.api.paralelus.models.dto.PericiaDTO;
import com.api.paralelus.models.dto.SalvarPersonagemDTO;
import com.api.paralelus.models.mappers.ArquetipoMapper;
import com.api.paralelus.models.mappers.PericiaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Base64;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface SalvarPersonagemMapper {

    @Mapping(target = "personagemPericias", source = "pericias")
    @Mapping(target = "personagemCaminhos", source = "caminho")
    @Mapping(target = "energiaAtual", source = "energiaAtual")
    @Mapping(target = "personagemArquetipos", source = "arquetipo")
    Personagem toEntity(SalvarPersonagemDTO dto);

    @Mapping(target = "pericias", source = "personagemPericias")
    @Mapping(target = "arquetipo", source = "personagemArquetipos")
    @Mapping(target = "caminho", source = "personagemCaminhos")
    @Mapping(target = "energiaAtual", source = "energiaAtual")
    SalvarPersonagemDTO toDTO(Personagem entity);

    List<ArquetipoDTO> personagemArquetipoSetToArquetipoDTOList(Set<PersonagemArquetipo> personagemArquetipos);

    @Mapping(target = "id", source = "pericia.id")
    @Mapping(target = "nome", source = "pericia.nome")
    @Mapping(target = "pontos", source = "pontos")
    PericiaDTO personagemPericiaToPericiaDTO(PersonagemPericia personagemPericia);

    @Mapping(target = "pericias", source = "personagemPericias")
    List<PericiaDTO> personagemPericiaSetToPericiaDTOList(Set<PersonagemPericia> personagemPericias);


    default byte[] map(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return Base64.getDecoder().decode(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    default String map(byte[] value) {
        return value != null ? Base64.getEncoder().encodeToString(value) : null;
    }


}
