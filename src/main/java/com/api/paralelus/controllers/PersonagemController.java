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
    public ResponseEntity<ApiResponse<SalvarPersonagemDTO>> getPersonagem(@PathVariable Integer id){
        SalvarPersonagemDTO personagem = this.personagemService.getPersonagem(id);
        return ResponseEntity.ok(new ApiResponse(true, "", personagem));
    }


    @PostMapping("/salvar")
    public ResponseEntity salvarPersonagem(@RequestBody  SalvarPersonagemDTO dto){
        this.personagemService.salvarPersonagem(dto);
        return ResponseEntity.ok( new ApiResponse(true,"Personagem salvo com sucesso", "" ));
    }

    @GetMapping("/{id}/imagem")
    public ResponseEntity getImagemPersonagem(@PathVariable Integer id) {
        String imagemBase64 = personagemService.getImagemPersonagem(id);
        if (imagemBase64 == null) {
            return ResponseEntity.ok().body(new ApiResponse(true, "", null));
        }
        return ResponseEntity.ok().body(imagemBase64);
    }
}
