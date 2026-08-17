package com.sena.examenes.infrastructure.adapter.in.rest;

import com.sena.examenes.domain.Usuario;

public record UsuarioResponse(String username, String email, boolean activo) {

    public static UsuarioResponse desde(Usuario usuario) {
        return new UsuarioResponse(usuario.getUsername(), usuario.getEmail(),
                usuario.isActivo());
    }
}
