package com.api.paralelus.controllers;

import com.api.paralelus.dto.ArquetipoDTO;
import com.api.paralelus.services.ArquetipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/arquetipo")
public class ArquetipoController {

    @Autowired
    private ArquetipoService arquetipoService;

    @GetMapping
    public ResponseEntity<List<ArquetipoDTO>> getArquetipos(){
        var arquetipos = this.arquetipoService.getArquetipos();
        return ResponseEntity.ok(arquetipos);
    }
}
