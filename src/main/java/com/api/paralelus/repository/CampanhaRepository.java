package com.api.paralelus.repository;

import com.api.paralelus.models.Campanha;
import com.api.paralelus.models.dto.CampanhaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Integer> {

}
