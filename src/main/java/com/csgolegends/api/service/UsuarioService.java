package com.csgolegends.api.service;


import com.csgolegends.api.model.Perfil;
import com.csgolegends.api.model.Usuario;
import com.csgolegends.api.repository.UsuarioRepository;
import com.csgolegends.api.repositoryimpl.UsuarioRepositoryCustom;
import com.csgolegends.api.util.NegocioException;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private UsuarioRepositoryCustom usuarioRepositoryCustom;

    @Autowired
    private PerfilService perfilService;

    public List<Usuario> listarTodos(){
        return userRepository.findAll();
    }

    public Usuario listarPorId(Integer id){
        Usuario usuario = userRepository.findById(id).get();
        return usuario;
    }


    public Usuario cadastrar(Usuario user) {

        Usuario usuario = validarCadastro(user);
        usuario = userRepository.save(user);
        return usuario;

    }

    public Usuario procurarPorUsername(String username) {
        return usuarioRepositoryCustom.procurarUsuarioPorUsername(username);
    }

    public Usuario validarCadastro(Usuario user){
        boolean usernameTrigger = usuarioRepositoryCustom.isUsernameCadastrado(user);
        boolean emailTrigger = usuarioRepositoryCustom.isEmailCadastrado(user);
        boolean cpfTrigger = usuarioRepositoryCustom.isCpfCadastrado(user);
        Date dataHoje = new Date();

        if (usernameTrigger) {
            throw new NegocioException("Usuario já Cadastrado");
        }

        if(emailTrigger){
            throw new NegocioException("Email já Cadastrado");
        }

        if(cpfTrigger){
            throw new NegocioException("CPF já Cadastrado");
        }
        user.setDataCadastro(dataHoje);
        user.setLastLogin(dataHoje);
        List<Perfil> listaPerfils = new ArrayList<>();
        listaPerfils = perfilService.buscarTodos();
        user.adicionarPerfil(listaPerfils.get(2));
        //UsuariosPerfils perfil = new UsuariosPerfils();
        //perfil.setPerfil(listaPerfils.get(2));
        //user.adicionarPerfil(perfil);
        user.setSenha(new BCryptPasswordEncoder().encode(user.getPassword()));

        return user;

    }
}
