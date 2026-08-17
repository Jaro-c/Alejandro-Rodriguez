package com.sena.examenes.infrastructure.adapter.out.persistence;

import com.sena.examenes.application.port.out.RolRepositoryPort;
import com.sena.examenes.domain.Rol;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class RolRepositoryAdapter implements RolRepositoryPort {

    private final RolJpaRepository repositorioJpa;

    public RolRepositoryAdapter(RolJpaRepository repositorioJpa) {
        this.repositorioJpa = repositorioJpa;
    }

    @Override
    public Rol guardar(Rol rol) {
        RolEntity entidad = new RolEntity(null, rol.getNombre(), rol.getDescripcion());
        RolEntity entidadGuardada = repositorioJpa.save(entidad);
        return new Rol(entidadGuardada.getNombre(), entidadGuardada.getDescripcion());
    }

    @Override
    public Optional<Rol> buscarPorNombre(String nombre) {
        return repositorioJpa.findByNombreIgnoreCase(nombre)
                .map(entidad -> new Rol(entidad.getNombre(), entidad.getDescripcion()));
    }

    @Override
    public List<Rol> listarTodos() {
        return repositorioJpa.findAll().stream()
                .map(entidad -> new Rol(entidad.getNombre(), entidad.getDescripcion()))
                .toList();
    }
}
