package com.sena.examenes.infrastructure.adapter.out.security;

import com.sena.examenes.application.port.out.TokenPort;
import com.sena.examenes.domain.Rol;
import com.sena.examenes.domain.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JwtTokenAdapter implements TokenPort {

    private static final long DURACION_TOKEN_MS = 3_600_000L;
    private final SecretKey claveSecreta;

    public JwtTokenAdapter(@Value("${jwt.secret}") String secretoBase64) {
        this.claveSecreta = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secretoBase64));
    }

    @Override
    public String generar(Usuario usuario) {
        String rolesConcatenados = usuario.getRoles().stream()
                .map(Rol::getNombre)
                .collect(Collectors.joining(","));

        Date ahora = new Date();
        Date expiracion = new Date(ahora.getTime() + DURACION_TOKEN_MS);

        return Jwts.builder()
                .subject(usuario.getUsername())
                .claim("roles", rolesConcatenados)
                .issuedAt(ahora)
                .expiration(expiracion)
                .signWith(claveSecreta)
                .compact();
    }

    @Override
    public Optional<String> validarYObtenerUsername(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(claveSecreta)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return Optional.of(claims.getSubject());
        } catch (JwtException excepcion) {
            return Optional.empty();
        }
    }
}
