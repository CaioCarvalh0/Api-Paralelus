package com.api.paralelus.repository;

import com.api.paralelus.entity.Personagem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {

    Personagem findByIdAndUsuarioId(Integer id, Integer usuarioId);

    @EntityGraph(attributePaths = {
            "pericias.pericia",
            "arquetipo",
            "caminho"
    })
    List<Personagem> findByUsuarioId(Integer usuarioId);
}
