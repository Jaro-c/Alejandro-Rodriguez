package com.sena.examenes.application.port.out;

import com.sena.examenes.domain.Usuario;
import java.util.Optional;

public interface TokenPort {

    String generar(Usuario usuario);

    Optional<String> validarYObtenerUsername(String token);
}
