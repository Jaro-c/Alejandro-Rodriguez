package com.sena.examenes.infrastructure.security;

import com.sena.examenes.application.port.out.TokenPort;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.Rol;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String PREFIJO_BEARER = "Bearer ";

    private final TokenPort tokenPort;
    private final UsuarioRepositoryPort repositorioUsuarios;

    public JwtAuthenticationFilter(TokenPort tokenPort,
                                    UsuarioRepositoryPort repositorioUsuarios) {
        this.tokenPort = tokenPort;
        this.repositorioUsuarios = repositorioUsuarios;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String encabezado = request.getHeader("Authorization");
        if (encabezado != null && encabezado.startsWith(PREFIJO_BEARER)) {
            String token = encabezado.substring(PREFIJO_BEARER.length());
            tokenPort.validarYObtenerUsername(token)
                    .ifPresent(this::establecerAutenticacion);
        }
        filterChain.doFilter(request, response);
    }

    private void establecerAutenticacion(String username) {
        repositorioUsuarios.buscarPorUsername(username).ifPresent(usuario -> {
            List<SimpleGrantedAuthority> permisos = usuario.getRoles().stream()
                    .map(Rol::getNombre)
                    .map(nombre -> new SimpleGrantedAuthority("ROLE_" + nombre))
                    .toList();
            var autenticacion = new UsernamePasswordAuthenticationToken(
                    usuario.getUsername(), null, permisos);
            SecurityContextHolder.getContext().setAuthentication(autenticacion);
        });
    }
}
