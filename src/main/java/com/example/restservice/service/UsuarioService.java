/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.service;

import com.example.restservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */

@Service
public class UsuarioService {
    
    @Autowired
    private final UsuarioRepository usuarioRepository;
    
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
 
    public int comprobarNickname(String nick){
        return usuarioRepository.comprobarNickname(nick);
    }
    
    public Integer comprobarLogin(String nickname, String password) {
        return usuarioRepository.comprobarLogin(nickname, password);
    }

    public int crearUsuario(String nickname, String password) {
        return usuarioRepository.crearUsuario(nickname, password);
    }
}
