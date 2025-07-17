package com.api.paralelus.controllers;

import com.api.paralelus.dto.CampanhaDTO;
import com.api.paralelus.infra.security.ApiResponse;
import com.api.paralelus.services.CampanhaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/campanha")
public class CampanhaController {

    private final CampanhaService campanhaService;

    @GetMapping("/listar")
    public ResponseEntity<List<CampanhaDTO>> listCampanhas() {
        var campanhas = campanhaService.getCampanhas();
        return ResponseEntity.ok(campanhas);
    }

    @GetMapping("/listar/ativas")
    public ResponseEntity<List<CampanhaDTO>> listCampanhasAtivas() {
        var campanhas = campanhaService.getCampanhasAtivas();
        return ResponseEntity.ok(campanhas);
    }

    @PostMapping("/criar")
    public ResponseEntity<ApiResponse<CampanhaDTO>> criarCamapanha(@RequestBody CampanhaDTO dto){
        var camapanha = campanhaService.criarCamanha(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Campanha Criada", camapanha));
    }
}
