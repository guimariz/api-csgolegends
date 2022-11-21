package com.csgolegends.api.controller;



import com.csgolegends.api.model.ProPlayer;
import com.csgolegends.api.service.ProPlayerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/proplayer")
public class ProPlayerController {

    @Autowired
    ProPlayerService proPlayerService;

    @GetMapping(value = "/listarTodos")
    public List<ProPlayer> listarTodos() {
        return proPlayerService.listarTudo();
    }
}
