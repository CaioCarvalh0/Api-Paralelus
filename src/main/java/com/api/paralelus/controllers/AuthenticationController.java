package com.api.paralelus.controllers;

import com.api.paralelus.infra.security.ApiResponse;
import com.api.paralelus.dto.AuthenticationDTO;
import com.api.paralelus.dto.LoginRespondeDTO;
import com.api.paralelus.dto.RegisterDTO;
import com.api.paralelus.entity.Usuario;
import com.api.paralelus.dto.UsuarioDTO;
import com.api.paralelus.repository.UsuarioRepository;
import com.api.paralelus.services.PasswordResetService;
import com.api.paralelus.services.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UsuarioRepository usuarioRepository;

    private final TokenService tokenService;

    private final PasswordResetService passwordResetService;

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
            return ResponseEntity.ok(new ApiResponse(false, "Login já em uso", null));
        }
        if(this.usuarioRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.ok(new ApiResponse(false, "Email já em uso", null));
        }
        return ResponseEntity.ok(new ApiResponse(true, "", null));
    }

    @PostMapping("/resetpassword")
    public ResponseEntity<ApiResponse> resetPassword(@RequestParam String email) {
        String novaSenha = passwordResetService.resetPassword(email, null);
        if (novaSenha != null) {
            return ResponseEntity.ok(new ApiResponse(true,  "", novaSenha));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Email não encontrado", null));
        }
    }




}
