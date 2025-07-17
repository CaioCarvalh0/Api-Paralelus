package com.api.paralelus.controllers;

import com.api.paralelus.dto.CaminhoDTO;
import com.api.paralelus.services.CaminhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/caminho")
public class CaminhoController {

    private final CaminhoService caminhoService;

    @GetMapping
    public ResponseEntity<List<CaminhoDTO>> listarCaminhos(){
        var caminhos = this.caminhoService.getCaminhos();
        return ResponseEntity.ok(caminhos);
    }
}
