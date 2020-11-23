/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Maneja las excepciones que lanzamos desde la Rest API.
 * @author franc
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    
    // Maneja nuestras propias exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
        
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    // Maneja las exceptions globales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request){
        
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
}
