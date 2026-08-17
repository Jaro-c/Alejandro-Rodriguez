package com.sena.examenes.infrastructure.adapter.out.persistence;

import com.sena.examenes.domain.Rol;
import com.sena.examenes.domain.Usuario;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    private final RolJpaRepository rolJpaRepository;

    public UsuarioMapper(RolJpaRepository rolJpaRepository) {
        this.rolJpaRepository = rolJpaRepository;
    }

    public UsuarioEntity aEntity(Usuario usuario) {
        UsuarioEntity entidad = new UsuarioEntity(null, usuario.getUsername(),
                usuario.getEmail(), usuario.getPasswordHash(), usuario.isActivo());
        entidad.setRoles(convertirRolesAEntity(usuario.getRoles()));
        return entidad;
    }

    private Set<RolEntity> convertirRolesAEntity(Set<Rol> roles) {
        return roles.stream()
                .map(this::localizarRolEntity)
                .collect(Collectors.toSet());
    }

    private RolEntity localizarRolEntity(Rol rol) {
        return rolJpaRepository.findByNombreIgnoreCase(rol.getNombre())
                .orElseThrow(() -> new IllegalStateException(
                        "El rol " + rol.getNombre() + " todavia no existe en la base de datos."));
    }

    public Usuario aDominio(UsuarioEntity entidad) {
        Usuario usuario = new Usuario(entidad.getUsername(), entidad.getEmail(),
                entidad.getPasswordHash());
        if (!entidad.isActivo()) {
            usuario.desactivar();
        }
        for (RolEntity rolEntity : entidad.getRoles()) {
            usuario.asignarRol(new Rol(rolEntity.getNombre(), rolEntity.getDescripcion()));
        }
        return usuario;
    }
}
