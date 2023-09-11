package br.com.dsl.agrogpt.api.config;

import br.com.dsl.agrogpt.api.repository.ClienteRepository;
import br.com.dsl.agrogpt.api.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        var token = getToken(request);

        // se for valido, autenticar
        if (token != null) {
            var cliente = tokenService.valideAndGetUserBy(token);
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    cliente.getEmail(),
                    null,
                    cliente.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String prefix = "Bearer ";
        var header = request.getHeader("Authorization");

        if (header == null || header.isEmpty() || !header.startsWith(prefix)){
            return null;
        }

        return header.replace(prefix, "");

    }
}
