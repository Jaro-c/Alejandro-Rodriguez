package com.sena.examenes.application.service;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.Usuario;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioUseCase {

    private final UsuarioRepositoryPort repositorioUsuarios;

    public UsuarioService(UsuarioRepositoryPort repositorioUsuarios) {
        this.repositorioUsuarios = repositorioUsuarios;
    }

    @Override
    public Usuario registrar(String username, String email) {
        validarUsernameDisponible(username);
        return repositorioUsuarios.guardar(new Usuario(username, email));
    }

    private void validarUsernameDisponible(String username) {
        if (repositorioUsuarios.existePorUsername(username)) {
            throw new IllegalStateException("El username '" + username + "' ya esta en uso.");
        }
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return repositorioUsuarios.buscarPorUsername(username);
    }

    @Override
    public List<Usuario> listarActivos() {
        return repositorioUsuarios.listarActivos();
    }
}
