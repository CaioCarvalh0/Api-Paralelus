package com.api.paralelus.controllers;

import com.api.paralelus.infra.security.ApiResponse;
import com.api.paralelus.models.dto.SalvarPersonagemDTO;
import com.api.paralelus.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<SalvarPersonagemDTO> getPersonagem(@PathVariable Integer id){
        SalvarPersonagemDTO personagem = this.personagemService.getPersonagem(id);
        return ResponseEntity.ok(personagem);
    }


    @PostMapping("/salvar")
    public ResponseEntity<ApiResponse> salvarPersonagem(@RequestBody  SalvarPersonagemDTO dto){
        this.personagemService.salvarPersonagem(dto);
        return ResponseEntity.ok( new ApiResponse("Personagem salvo com sucesso"));
    }

}
