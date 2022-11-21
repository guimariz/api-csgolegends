package com.csgolegends.api.service;


import com.csgolegends.api.model.Usuario;
import com.csgolegends.api.repositoryimpl.UsuarioRepositoryCustom;
import com.csgolegends.api.util.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {


    @Autowired
    UsuarioRepositoryCustom usuarioRepositoryCustom;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = null;
        try {
            usuario = Optional.ofNullable(usuarioRepositoryCustom.procurarUsuarioPorUsername(username));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(usuario.isPresent()){
            return usuario.get();
        }
        throw new NegocioException("Dados Invalidos");
    }
}
