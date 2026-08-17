package com.sena.examenes.application.port.out;

public interface PasswordEncoderPort {

    String codificar(String textoPlano);

    boolean verificar(String textoPlano, String hashAlmacenado);
}
