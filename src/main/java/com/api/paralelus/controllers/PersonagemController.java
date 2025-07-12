package com.api.paralelus.controllers;

import com.api.paralelus.infra.security.ApiResponse;
import com.api.paralelus.dto.PersonagemDTO;
import com.api.paralelus.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<ApiResponse<List<PersonagemDTO>>> getPersonagem(@PathVariable Integer id) {
        List<PersonagemDTO> personagem = this.personagemService.getPersonagensUsuario(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "", personagem));
    }


    @GetMapping("/{id}/imagem")
    public ResponseEntity getImagemPersonagem(@PathVariable Integer id) {
        String imagemBase64 = personagemService.getImagemPersonagem(id);
        if (imagemBase64 == null) {
            return ResponseEntity.ok().body(new ApiResponse(true, "", null));
        }
        return ResponseEntity.ok().body(imagemBase64);
    }


    @PostMapping("/salvar")
    public ResponseEntity<ApiResponse<PersonagemDTO>> salvarPersonagem(@RequestBody PersonagemDTO dto) {
        PersonagemDTO personagem = this.personagemService.salvarPersonagem(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Personagem salvo com sucesso", personagem));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deletePersonagem(@PathVariable Integer id) {
        this.personagemService.deletePersonagem(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Personagem removido com sucesso", true));
    }
}
