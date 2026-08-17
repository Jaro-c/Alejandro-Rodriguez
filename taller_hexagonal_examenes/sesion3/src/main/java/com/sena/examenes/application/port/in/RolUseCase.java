package com.sena.examenes.application.port.in;

import com.sena.examenes.domain.Rol;
import java.util.List;

public interface RolUseCase {

    Rol crear(String nombre, String descripcion);

    List<Rol> listarTodos();
}
