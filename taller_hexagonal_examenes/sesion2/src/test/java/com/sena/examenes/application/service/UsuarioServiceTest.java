package com.sena.examenes.application.service;

import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
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

    @Test
    void noPermiteRegistrarDosVecesElMismoUsername() {
        UsuarioService servicio = new UsuarioService(new UsuarioRepositoryPortEnMemoria());
        servicio.registrar("arodriguez", "arodriguez@sena.edu.co");

        assertThrows(IllegalStateException.class, () ->
                servicio.registrar("arodriguez", "otro@correo.com"));
    }
}
