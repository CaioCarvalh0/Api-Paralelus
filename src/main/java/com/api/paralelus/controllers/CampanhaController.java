package com.api.paralelus.controllers;

import com.api.paralelus.models.Campanha;
import com.api.paralelus.models.dto.CampanhaDTO;
import com.api.paralelus.repository.CampanhaRepository;
import com.api.paralelus.services.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/campanha")
public class CampanhaController {

    @Autowired
    private CampanhaService campanhaService;

    @GetMapping("/listar")
    public ResponseEntity<List<CampanhaDTO>> listCampanhas() {
        var campanhas = this.campanhaService.getCampanhas();
        return ResponseEntity.ok(campanhas);
    }
}
