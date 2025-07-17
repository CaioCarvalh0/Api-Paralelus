package com.api.paralelus.controllers;

import com.api.paralelus.dto.PericiaDTO;
import com.api.paralelus.services.PericiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pericia")
public class PericiaController {

    private final  PericiaService periciaService;

    @GetMapping
    public ResponseEntity<List<PericiaDTO>> listarPericias(){
        var pericias = this.periciaService.getPericias();
        return ResponseEntity.ok(pericias);
    }


}
