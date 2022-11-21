package com.csgolegends.api.controller;

import com.csgolegends.api.model.Usuario;
import com.csgolegends.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UsuarioController {


    @Autowired
    private UsuarioService userService;


    @Transactional
    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(userService.listarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable ("id") Integer id) {
        Usuario usuario = userService.listarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Usuario> cadastrar (@Valid @RequestBody Usuario user ) {
        return ResponseEntity.ok(userService.cadastrar(user));
    }






}
