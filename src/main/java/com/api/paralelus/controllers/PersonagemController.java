package com.api.paralelus.controllers;

import com.api.paralelus.models.dto.SalvarPersonagemDTO;
import com.api.paralelus.services.PersonagemService;
import jakarta.validation.Valid;
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
    public ResponseEntity<String> salvarPersonagem(@RequestBody  SalvarPersonagemDTO dto){
        this.personagemService.salvarPersonagem(dto);

        return ResponseEntity.ok("Personagem salvo com sucesso");
    }

}
