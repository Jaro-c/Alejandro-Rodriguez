package com.sena.examenes.infrastructure.adapter.in.rest;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.domain.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioRequest cuerpo) {
        Usuario creado = usuarioUseCase.registrar(cuerpo.username(), cuerpo.email());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UsuarioResponse.desde(creado));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UsuarioResponse> buscar(@PathVariable String username) {
        return usuarioUseCase.buscarPorUsername(username)
                .map(UsuarioResponse::desde)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<UsuarioResponse> listarActivos() {
        return usuarioUseCase.listarActivos().stream()
                .map(UsuarioResponse::desde)
                .toList();
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> manejarConflicto(IllegalStateException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> manejarSolicitudInvalida(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
