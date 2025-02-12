package com.api.paralelus.controllers;

import com.api.paralelus.models.dto.AuthenticationDTO;
import com.api.paralelus.models.dto.LoginRespondeDTO;
import com.api.paralelus.models.dto.RegisterDTO;
import com.api.paralelus.models.Usuario;
import com.api.paralelus.repository.UsuarioRepository;
import com.api.paralelus.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var user = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = this.authenticationManager.authenticate(user);
        var usuario = (Usuario) auth.getPrincipal();
        var token = tokenService.generateToken(usuario);
        return ResponseEntity.ok(new LoginRespondeDTO(token, usuario));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if(this.usuarioRepository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedSenha = new BCryptPasswordEncoder().encode(data.senha());
        Usuario usuario = new Usuario(data.login(), data.nome(), data.email(), encryptedSenha);
        this.usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();
    }

}
