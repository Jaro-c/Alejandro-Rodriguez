package com.sena.examenes.application.service;

import com.sena.examenes.application.port.in.RolUseCase;
import com.sena.examenes.application.port.out.RolRepositoryPort;
import com.sena.examenes.domain.Rol;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService implements RolUseCase {

    private final RolRepositoryPort repositorioRoles;

    public RolService(RolRepositoryPort repositorioRoles) {
        this.repositorioRoles = repositorioRoles;
    }

    @Override
    public Rol crear(String nombre, String descripcion) {
        boolean yaExiste = repositorioRoles.buscarPorNombre(nombre).isPresent();
        if (yaExiste) {
            throw new IllegalStateException("El rol '" + nombre + "' ya existe.");
        }
        return repositorioRoles.guardar(new Rol(nombre, descripcion));
    }

    @Override
    public List<Rol> listarTodos() {
        return repositorioRoles.listarTodos();
    }
}
