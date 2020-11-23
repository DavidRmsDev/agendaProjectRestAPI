/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.exception;


/**
 * Excepción propia
 * @author franc
 */
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }   
    
}
