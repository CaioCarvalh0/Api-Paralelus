package com.api.paralelus.controllers;

import com.api.paralelus.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;



}
