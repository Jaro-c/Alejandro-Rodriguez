package com.sena.examenes.application.service;

import com.sena.examenes.application.port.in.AutenticacionUseCase;
import com.sena.examenes.application.port.out.PasswordEncoderPort;
import com.sena.examenes.application.port.out.TokenPort;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.Usuario;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements AutenticacionUseCase {

    private static final String MENSAJE_LOGIN_INVALIDO =
            "Credenciales incorrectas.";

    private final UsuarioRepositoryPort repositorioUsuarios;
    private final PasswordEncoderPort encoder;
    private final TokenPort generadorToken;

    public AutenticacionService(UsuarioRepositoryPort repositorioUsuarios,
                                 PasswordEncoderPort encoder,
                                 TokenPort generadorToken) {
        this.repositorioUsuarios = repositorioUsuarios;
        this.encoder = encoder;
        this.generadorToken = generadorToken;
    }

    @Override
    public String login(String username, String password) {
        Usuario usuario = repositorioUsuarios.buscarPorUsername(username)
                .orElseThrow(() -> new IllegalStateException(MENSAJE_LOGIN_INVALIDO));

        if (!encoder.verificar(password, usuario.getPasswordHash())) {
            throw new IllegalStateException(MENSAJE_LOGIN_INVALIDO);
        }
        return generadorToken.generar(usuario);
    }
}
