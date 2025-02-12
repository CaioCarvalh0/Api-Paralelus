package com.api.paralelus.repository;

import com.api.paralelus.models.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Integer> {
}
