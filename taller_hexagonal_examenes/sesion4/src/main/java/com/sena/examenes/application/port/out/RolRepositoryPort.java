package com.sena.examenes.application.port.out;

import com.sena.examenes.domain.Rol;
import java.util.List;
import java.util.Optional;

public interface RolRepositoryPort {

    Rol guardar(Rol rol);

    Optional<Rol> buscarPorNombre(String nombre);

    List<Rol> listarTodos();
}
