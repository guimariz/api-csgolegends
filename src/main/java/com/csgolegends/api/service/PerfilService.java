package com.csgolegends.api.service;


import com.csgolegends.api.model.Perfil;
import com.csgolegends.api.repository.PerfilsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilsRepository perfilsRepository;

    public List<Perfil> buscarTodos(){
        return perfilsRepository.findAll();
    }

}
