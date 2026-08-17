package com.sena.examenes.domain;

public class Usuario {

    private final String username;
    private final String email;
    private boolean activo;

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
}
