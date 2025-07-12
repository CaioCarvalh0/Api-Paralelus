package com.api.paralelus.dto;

import com.api.paralelus.entity.Usuario;

public record LoginRespondeDTO(String token, Usuario user) {
}
