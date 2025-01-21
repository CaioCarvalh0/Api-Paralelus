package com.api.paralelus.repository;

import com.api.paralelus.models.Arquetipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquetipoRepository extends JpaRepository<Arquetipo, Integer> {
}
