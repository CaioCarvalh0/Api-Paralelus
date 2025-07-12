package com.api.paralelus.mappers;

import com.api.paralelus.entity.Pericia;
import com.api.paralelus.entity.PersonagemPericia;
import com.api.paralelus.dto.PericiaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PericiaMapper {

    PericiaDTO toDTO(Pericia pericia);

    Pericia toEntity(PericiaDTO periciaDTO);

    @Named("mapPersonagemPericia")
    default PericiaDTO mapPersonagemPericia(PersonagemPericia personagemPericia) {
        if (personagemPericia == null) {
            return null;
        }
        return new PericiaDTO(
                personagemPericia.getPericia().getId(),
                personagemPericia.getPericia().getNome(),
                personagemPericia.getPontos()
        );
    }
}
