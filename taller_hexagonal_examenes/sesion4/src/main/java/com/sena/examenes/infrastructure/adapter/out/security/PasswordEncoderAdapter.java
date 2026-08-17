package com.sena.examenes.infrastructure.adapter.out.security;

import com.sena.examenes.application.port.out.PasswordEncoderPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderAdapter implements PasswordEncoderPort {

    private final PasswordEncoder encoderDeSpring;

    public PasswordEncoderAdapter(PasswordEncoder encoderDeSpring) {
        this.encoderDeSpring = encoderDeSpring;
    }

    @Override
    public String codificar(String textoPlano) {
        return encoderDeSpring.encode(textoPlano);
    }

    @Override
    public boolean verificar(String textoPlano, String hashAlmacenado) {
        return encoderDeSpring.matches(textoPlano, hashAlmacenado);
    }
}
