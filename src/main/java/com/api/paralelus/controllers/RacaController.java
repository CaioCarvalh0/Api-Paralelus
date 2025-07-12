package com.api.paralelus.controllers;

import com.api.paralelus.dto.RacaDTO;
import com.api.paralelus.services.RacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/raca")
public class RacaController {

    @Autowired
    private RacaService racaService;

    @GetMapping
    public ResponseEntity<List<RacaDTO>> getRacas(){
        var racas = this.racaService.getRacas();
        return ResponseEntity.ok(racas);
    }
}
