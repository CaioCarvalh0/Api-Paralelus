package com.api.paralelus.models.mappers;

import com.api.paralelus.models.Pericia;
import com.api.paralelus.models.PersonagemPericia;
import com.api.paralelus.models.dto.PericiaDTO;
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
