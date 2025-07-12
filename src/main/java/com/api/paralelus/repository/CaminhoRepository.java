package com.api.paralelus.repository;

import com.api.paralelus.entity.Caminho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaminhoRepository extends JpaRepository<Caminho, Integer>{
}
