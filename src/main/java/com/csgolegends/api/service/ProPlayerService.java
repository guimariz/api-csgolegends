package com.csgolegends.api.service;


import com.csgolegends.api.model.ProPlayer;
import com.csgolegends.api.repository.ProPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProPlayerService {

    @Autowired
    ProPlayerRepository proPlayerRepository;


    public List<ProPlayer> listarTudo(){
        List<ProPlayer> lista = proPlayerRepository.findAll();
        return lista;
    }
}
