package com.sena.examenes.infrastructure.adapter.in.rest;

import com.sena.examenes.domain.Rol;
import com.sena.examenes.domain.Usuario;
import java.util.Set;
import java.util.stream.Collectors;

public record UsuarioResponse(String username, String email,
                               boolean activo, Set<String> roles) {

    public static UsuarioResponse desde(Usuario usuario) {
        Set<String> nombresRoles = usuario.getRoles().stream()
                .map(Rol::getNombre)
                .collect(Collectors.toSet());
        return new UsuarioResponse(usuario.getUsername(), usuario.getEmail(),
                usuario.isActivo(), nombresRoles);
    }
}
