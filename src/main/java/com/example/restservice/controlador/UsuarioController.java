/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.controlador;

import com.example.restservice.domain.Usuario;
import com.example.restservice.exception.ResourceNotFoundException;
import com.example.restservice.service.UsuarioService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author franc
 */
@RestController
public class UsuarioController {
    
    private UsuarioService usuarioService;
    
    private Usuario usuarioLogeado = new Usuario();

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    //Comprueba el login
    @GetMapping("/login")
    public Usuario login(@RequestParam(value = "nickname") String nickname,
            @RequestParam(value = "password") String password) {
        
        
        if(comprobarUsuario(nickname)){
            if (comprobarLogin(nickname, password)) {
                return usuarioLogeado;
            } else {
                throw new ResourceNotFoundException("Contraseña no válido");
            }
        }
        else {
            throw new ResourceNotFoundException("Usuario no encontrado");
        }
    }
    
    //Registra un nuevo usuario
    @PostMapping("/registro")
    public boolean registro(@RequestParam(value = "nickname")String nickname,
            @RequestParam(value = "password")String password){
        
        try{
            if(usuarioService.crearUsuario(nickname, password) == 0)
                throw new ResourceNotFoundException("El usuario no ha podido crearse correctamente");
            else
                return true;
        }catch(DataIntegrityViolationException ex){
            throw new ResourceNotFoundException("El nickname ya existe");
        }
    }
    
    //Comprueba que el usuario existe
    private boolean comprobarUsuario(String nickname) {
      
        boolean existe = false;
        
        if(usuarioService.comprobarNickname(nickname) != 0)
            existe = true;
        
        return existe;
    }
    
    //Comprueba que la contraseña es correcta
    private boolean comprobarLogin(String nickname, String password) {
      
        boolean existe = false;
        usuarioLogeado.setUser(usuarioService.comprobarLogin(nickname, password));
        
        if(usuarioLogeado.getUser() != null)
            existe = true;
        
        return existe;
    }
}
