package com.sena.examenes.application.service;

import com.sena.examenes.application.port.out.PasswordEncoderPort;
import com.sena.examenes.application.port.out.RolRepositoryPort;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.Rol;
import com.sena.examenes.domain.Usuario;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UsuarioServiceTest {

    static class UsuarioRepositoryPortEnMemoria implements UsuarioRepositoryPort {
        private final List<Usuario> usuarios = new ArrayList<>();

        public Usuario guardar(Usuario usuario) {
            usuarios.add(usuario);
            return usuario;
        }

        public Optional<Usuario> buscarPorUsername(String username) {
            return usuarios.stream()
                    .filter(u -> u.getUsername().equalsIgnoreCase(username))
                    .findFirst();
        }

        public List<Usuario> listarActivos() {
            return usuarios.stream().filter(Usuario::isActivo).toList();
        }

        public boolean existePorUsername(String username) {
            return buscarPorUsername(username).isPresent();
        }
    }

    static class RolRepositoryPortEnMemoria implements RolRepositoryPort {
        private final List<Rol> roles = new ArrayList<>();

        public Rol guardar(Rol rol) {
            roles.add(rol);
            return rol;
        }

        public Optional<Rol> buscarPorNombre(String nombre) {
            return roles.stream()
                    .filter(r -> r.getNombre().equalsIgnoreCase(nombre))
                    .findFirst();
        }

        public List<Rol> listarTodos() {
            return roles;
        }
    }

    static class PasswordEncoderPortFijo implements PasswordEncoderPort {
        public String codificar(String textoPlano) {
            return "codificado::" + textoPlano;
        }

        public boolean verificar(String textoPlano, String hashAlmacenado) {
            return ("codificado::" + textoPlano).equals(hashAlmacenado);
        }
    }

    @Test
    void noPermiteRegistrarDosVecesElMismoUsername() {
        UsuarioService servicio = new UsuarioService(
                new UsuarioRepositoryPortEnMemoria(),
                new RolRepositoryPortEnMemoria(),
                new PasswordEncoderPortFijo());

        servicio.registrar("arodriguez", "arodriguez@sena.edu.co", "clave1234");

        assertThrows(IllegalStateException.class, () ->
                servicio.registrar("arodriguez", "otro@correo.com", "otraClave"));
    }
}
