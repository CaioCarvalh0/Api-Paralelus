package com.api.paralelus.models.dto;

import com.api.paralelus.models.Usuario;

public record LoginRespondeDTO(String token, Usuario user) {
}
