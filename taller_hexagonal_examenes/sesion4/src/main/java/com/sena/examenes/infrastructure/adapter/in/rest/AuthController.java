package com.sena.examenes.infrastructure.adapter.in.rest;

import com.sena.examenes.application.port.in.AutenticacionUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AutenticacionUseCase autenticacionUseCase;

    public AuthController(AutenticacionUseCase autenticacionUseCase) {
        this.autenticacionUseCase = autenticacionUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest cuerpo) {
        String token = autenticacionUseCase.login(cuerpo.username(), cuerpo.password());
        return ResponseEntity.ok(new TokenResponse(token));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> manejarNoAutorizado(IllegalStateException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
}
