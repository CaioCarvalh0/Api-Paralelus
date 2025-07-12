package com.api.paralelus.repository;

import com.api.paralelus.entity.Pericia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PericiaRepository extends JpaRepository<Pericia, Integer> {
}
