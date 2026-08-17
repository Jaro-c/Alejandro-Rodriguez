package com.sena.examenes.application.port.in;

import com.sena.examenes.domain.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioUseCase {

    Usuario registrar(String username, String email);

    Optional<Usuario> buscarPorUsername(String username);

    List<Usuario> listarActivos();
}
