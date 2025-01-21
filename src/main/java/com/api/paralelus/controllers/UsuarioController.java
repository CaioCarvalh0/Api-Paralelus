package com.api.paralelus.controllers;

import com.api.paralelus.models.dto.UsuarioDTO;
import com.api.paralelus.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/checklogin")
    public ResponseEntity checkLogin(@RequestBody @Valid UsuarioDTO data) {
        if(this.usuarioRepository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/checkemail")
    public ResponseEntity checkEmail(@RequestBody @Valid UsuarioDTO data) {
        if(this.usuarioRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/checkname")
    public ResponseEntity checkName(@RequestBody @Valid UsuarioDTO data) {
        if(this.usuarioRepository.findByNome(data.nome()) != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
