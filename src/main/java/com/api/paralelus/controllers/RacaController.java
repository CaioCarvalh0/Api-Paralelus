package com.api.paralelus.controllers;

import com.api.paralelus.dto.RacaDTO;
import com.api.paralelus.services.RacaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/raca")
public class RacaController {

    private final RacaService racaService;

    @GetMapping
    public ResponseEntity<List<RacaDTO>> getRacas(){
        var racas = this.racaService.getRacas();
        return ResponseEntity.ok(racas);
    }
}
