package com.api.paralelus.controllers;

import com.api.paralelus.infra.security.ApiResponse;
import com.api.paralelus.models.dto.AuthenticationDTO;
import com.api.paralelus.models.dto.LoginRespondeDTO;
import com.api.paralelus.models.dto.RegisterDTO;
import com.api.paralelus.models.Usuario;
import com.api.paralelus.models.dto.UsuarioDTO;
import com.api.paralelus.repository.UsuarioRepository;
import com.api.paralelus.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        try {
            var user = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
            var auth = this.authenticationManager.authenticate(user);
            var usuario = (Usuario) auth.getPrincipal();
            var token = tokenService.generateToken(usuario);
            var response = new LoginRespondeDTO(token, usuario);
            return ResponseEntity.ok().body(new ApiResponse(true, "Login efetuado com sucesso", response));
        }catch (UsernameNotFoundException e) {
            return ResponseEntity.ok().body(new ApiResponse(false, "Usuário não encontrado", null));
        } catch (BadCredentialsException e) {
            return ResponseEntity.ok().body(new ApiResponse(false, "Senha inválida", null));
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if(this.usuarioRepository.findByLogin(data.login()) != null) {
            return ResponseEntity.ok(new ApiResponse(false, "Usuario Já Cadastrado", null));
        }
        String encryptedSenha = new BCryptPasswordEncoder().encode(data.senha());
        Usuario usuario = new Usuario(data.login(), data.nome(), data.email(), encryptedSenha);
        this.usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/checkcadastro")
    public ResponseEntity<ApiResponse> checkCadastro(@RequestBody @Valid UsuarioDTO data) {
        if(this.usuarioRepository.findByLogin(data.login()) != null) {
            return ResponseEntity.ok(new ApiResponse(false, "Login invalido", null));
        }
        if(this.usuarioRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.ok(new ApiResponse(false, "Email invalido", null));
        }
        return ResponseEntity.ok(new ApiResponse(true, "", null));
    }

}
