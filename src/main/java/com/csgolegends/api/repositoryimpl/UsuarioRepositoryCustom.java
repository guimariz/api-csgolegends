package com.csgolegends.api.repositoryimpl;


import com.csgolegends.api.model.Usuario;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepositoryCustom {

    boolean isUsernameCadastrado(Usuario usuario);
    boolean isEmailCadastrado(Usuario usuario);
    boolean isCpfCadastrado(Usuario usuario);
    Usuario procurarUsuarioPorUsername(String username);
    void atualizarUltimoLogin(Integer id);
}
