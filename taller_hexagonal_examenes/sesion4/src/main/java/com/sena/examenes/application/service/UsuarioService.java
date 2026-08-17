package com.sena.examenes.application.service;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.application.port.out.PasswordEncoderPort;
import com.sena.examenes.application.port.out.RolRepositoryPort;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.Rol;
import com.sena.examenes.domain.Usuario;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioUseCase {

    private final UsuarioRepositoryPort repositorioUsuarios;
    private final RolRepositoryPort repositorioRoles;
    private final PasswordEncoderPort encoder;

    public UsuarioService(UsuarioRepositoryPort repositorioUsuarios,
                           RolRepositoryPort repositorioRoles,
                           PasswordEncoderPort encoder) {
        this.repositorioUsuarios = repositorioUsuarios;
        this.repositorioRoles = repositorioRoles;
        this.encoder = encoder;
    }

    @Override
    public Usuario registrar(String username, String email, String password) {
        validarUsernameDisponible(username);
        String hash = encoder.codificar(password);
        return repositorioUsuarios.guardar(new Usuario(username, email, hash));
    }

    private void validarUsernameDisponible(String username) {
        if (repositorioUsuarios.existePorUsername(username)) {
            throw new IllegalStateException("El username '" + username + "' ya esta en uso.");
        }
    }

    @Override
    public Usuario asignarRol(String username, String nombreRol) {
        Usuario usuario = obtenerUsuarioOFallar(username);
        Rol rol = obtenerRolOFallar(nombreRol);
        usuario.asignarRol(rol);
        return repositorioUsuarios.guardar(usuario);
    }

    private Usuario obtenerUsuarioOFallar(String username) {
        return repositorioUsuarios.buscarPorUsername(username)
                .orElseThrow(() -> new NoSuchElementException(
                        "No hay un usuario registrado con ese username."));
    }

    private Rol obtenerRolOFallar(String nombreRol) {
        return repositorioRoles.buscarPorNombre(nombreRol)
                .orElseThrow(() -> new NoSuchElementException(
                        "No hay un rol registrado con ese nombre."));
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
