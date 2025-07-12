package com.api.paralelus.controllers;

import com.api.paralelus.dto.PericiaDTO;
import com.api.paralelus.services.PericiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pericia")
public class PericiaController {

    @Autowired
    private PericiaService periciaService;

    @GetMapping
    public ResponseEntity<List<PericiaDTO>> listarPericias(){
        var pericias = this.periciaService.getPericias();
        return ResponseEntity.ok(pericias);
    }


}
