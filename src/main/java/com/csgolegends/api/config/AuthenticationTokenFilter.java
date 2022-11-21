package com.csgolegends.api.config;

import com.csgolegends.api.model.Usuario;
import com.csgolegends.api.repository.UsuarioRepository;
import com.csgolegends.api.service.TokenService;
import com.csgolegends.api.service.UsuarioService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationTokenFilter  extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuarioService usuarioService;

    public AuthenticationTokenFilter(TokenService tokenService, UsuarioService usuarioService) {
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValido(token);
        if(valido){
            authenticarCliente(token);
        }
        filterChain.doFilter(request, response);

    }

    private void authenticarCliente(String token) {
        Integer idUsuario = tokenService.getIdUsuario(token);
        Usuario usuario = usuarioService.listarPorId(idUsuario);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


    private String recuperarToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }
}
