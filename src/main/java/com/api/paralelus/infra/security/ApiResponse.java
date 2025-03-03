package com.api.paralelus.infra.security;

public record ApiResponse<T>(boolean sucesso,String mensagem, T data) {
}