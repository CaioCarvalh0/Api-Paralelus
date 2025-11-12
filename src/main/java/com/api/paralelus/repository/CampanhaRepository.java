package com.api.paralelus.repository;

import com.api.paralelus.entity.Campanha;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Integer> {

    @EntityGraph(attributePaths = {
            "jogadoresCampanha"
    })
    List<Campanha> findByAtivaTrue();
}
