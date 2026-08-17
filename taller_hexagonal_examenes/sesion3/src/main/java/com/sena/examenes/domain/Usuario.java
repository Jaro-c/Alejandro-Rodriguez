package com.sena.examenes.domain;

import java.util.HashSet;
import java.util.Set;

public class Usuario {

    private final String username;
    private final String email;
    private boolean activo;
    private final Set<Rol> rolesAsignados;

    public Usuario(String username, String email) {
        if (esVacio(username)) {
            throw new IllegalArgumentException("Debes indicar un username.");
        }
        if (esVacio(email)) {
            throw new IllegalArgumentException("Debes indicar un email.");
        }
        this.username = username;
        this.email = email;
        this.activo = true;
        this.rolesAsignados = new HashSet<>();
    }

    private boolean esVacio(String valor) {
        return valor == null || valor.isBlank();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void desactivar() {
        this.activo = false;
    }

    public void asignarRol(Rol rol) {
        if (rol == null) {
            throw new IllegalArgumentException("No se puede asignar un rol nulo.");
        }
        rolesAsignados.add(rol);
    }

    public boolean tieneRol(String nombreRol) {
        for (Rol rol : rolesAsignados) {
            if (rol.getNombre().equalsIgnoreCase(nombreRol)) {
                return true;
            }
        }
        return false;
    }

    public Set<Rol> getRoles() {
        return Set.copyOf(rolesAsignados);
    }
}
