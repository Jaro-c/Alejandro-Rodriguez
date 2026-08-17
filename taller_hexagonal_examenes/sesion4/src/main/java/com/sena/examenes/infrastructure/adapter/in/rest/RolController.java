package com.sena.examenes.infrastructure.adapter.in.rest;

import com.sena.examenes.application.port.in.RolUseCase;
import com.sena.examenes.domain.Rol;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolUseCase rolUseCase;

    public RolController(RolUseCase rolUseCase) {
        this.rolUseCase = rolUseCase;
    }

    @PostMapping
    public ResponseEntity<RolResponse> crear(@RequestBody RolRequest cuerpo) {
        Rol creado = rolUseCase.crear(cuerpo.nombre(), cuerpo.descripcion());
        return ResponseEntity.status(HttpStatus.CREATED).body(RolResponse.desde(creado));
    }

    @GetMapping
    public List<RolResponse> listarTodos() {
        return rolUseCase.listarTodos().stream()
                .map(RolResponse::desde)
                .toList();
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> manejarConflicto(IllegalStateException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
