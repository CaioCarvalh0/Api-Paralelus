package com.api.paralelus.services;

import com.api.paralelus.entity.Usuario;
import com.api.paralelus.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PasswordResetService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String resetPassword(String email, String newPassword) {
        UserDetails usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) return null;
        String novaSenha = generateRandomPassword(12);
        Usuario user = (Usuario) usuario;
        user.setSenha(passwordEncoder.encode(novaSenha));
        usuarioRepository.save(user);
        return novaSenha;
    }

    private String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        return IntStream.range(0, length)
                .mapToObj(i -> String.valueOf(chars.charAt(random.nextInt(chars.length()))))
                .collect(Collectors.joining());
    }
}
