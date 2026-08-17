package com.sena.examenes.infrastructure.adapter.out.persistence;

import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.Usuario;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository repositorioJpa;
    private final UsuarioMapper mapeador;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository repositorioJpa,
                                     UsuarioMapper mapeador) {
        this.repositorioJpa = repositorioJpa;
        this.mapeador = mapeador;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity entidadGuardada = repositorioJpa.save(mapeador.aEntity(usuario));
        return mapeador.aDominio(entidadGuardada);
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return repositorioJpa.findByUsernameIgnoreCase(username)
                .map(mapeador::aDominio);
    }

    @Override
    public List<Usuario> listarActivos() {
        return repositorioJpa.findByActivoTrue().stream()
                .map(mapeador::aDominio)
                .toList();
    }

    @Override
    public boolean existePorUsername(String username) {
        return repositorioJpa.existsByUsernameIgnoreCase(username);
    }
}
