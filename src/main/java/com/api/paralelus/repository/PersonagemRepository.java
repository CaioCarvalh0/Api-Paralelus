package com.api.paralelus.repository;

import com.api.paralelus.models.Personagem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {

    Personagem findByIdAndUsuarioId(Integer id, Integer usuarioId);

    @EntityGraph(attributePaths = {
            "personagemPericias.pericia",
            "personagemArquetipos",
            "personagemCaminhos"
    })
    Optional<Personagem> findByUsuarioId(Integer usuarioId);
}
