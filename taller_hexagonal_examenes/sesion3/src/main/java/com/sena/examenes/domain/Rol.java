package com.sena.examenes.domain;

import java.util.Objects;

public class Rol {

    private final String nombre;
    private final String descripcion;

    public Rol(String nombre, String descripcion) {
        validarNombre(nombre);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Debes indicar un nombre de rol.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rol otroRol = (Rol) obj;
        return nombre.equalsIgnoreCase(otroRol.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre.toLowerCase());
    }
}
