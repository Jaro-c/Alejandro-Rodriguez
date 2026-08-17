package com.sena.examenes.infrastructure.adapter.out.persistence;

import com.sena.examenes.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioEntity aEntity(Usuario usuario) {
        return new UsuarioEntity(null, usuario.getUsername(), usuario.getEmail(),
                usuario.isActivo());
    }

    public Usuario aDominio(UsuarioEntity entidad) {
        Usuario usuario = new Usuario(entidad.getUsername(), entidad.getEmail());
        if (!entidad.isActivo()) {
            usuario.desactivar();
        }
        return usuario;
    }
}
