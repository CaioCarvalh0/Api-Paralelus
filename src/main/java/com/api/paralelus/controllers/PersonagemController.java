package com.api.paralelus.controllers;

import com.api.paralelus.dto.PersonagemDTO;
import com.api.paralelus.infra.security.ApiResponse;
import com.api.paralelus.services.PersonagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personagem")
public class PersonagemController {

    private final PersonagemService personagemService;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<ApiResponse<List<PersonagemDTO>>> getPersonagem(@PathVariable Integer id) {
        List<PersonagemDTO> personagem = this.personagemService.getPersonagensUsuario(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "", personagem));
    }

    @PostMapping("/salvar")
    public ResponseEntity<ApiResponse<PersonagemDTO>> salvarPersonagem(@RequestBody PersonagemDTO dto) {
        PersonagemDTO personagem = this.personagemService.salvarPersonagem(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Personagem salvo com sucesso", personagem));
    }

    @PostMapping("/{id}/upload-capa")
    public ResponseEntity<ApiResponse<String>> uploadCapa(
            @PathVariable Integer id,
            @RequestParam("file") MultipartFile file
    ) {
        var url = personagemService.salvarImagem(id, file);
        return ResponseEntity.ok(new ApiResponse<>(true, "Imagem atualizada", url));
    }


//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<ApiResponse<Boolean>> deletePersonagem(@PathVariable Integer id) {
//        this.personagemService.deletePersonagem(id);
//        return ResponseEntity.ok(new ApiResponse<>(true, "Personagem removido com sucesso", true));
//    }
}
