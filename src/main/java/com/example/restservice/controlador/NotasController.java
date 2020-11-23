/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.controlador;

import com.example.restservice.domain.Notas;
import com.example.restservice.exception.ResourceNotFoundException;
import com.example.restservice.service.NotasService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author franc
 */
@RestController
public class NotasController {
    
    private NotasService notasService;
    
    public NotasController(NotasService notasService){
        this.notasService = notasService;
    }
    
    //Muestra todas las notas de un usuario
    @GetMapping("/seleccionaNota")
    public List<Notas> seleccionaNota(@RequestParam(value = "usu") Integer usu){
        return notasService.seleccionaNota(usu);
    }
    
    //Devuelve una nota
    @GetMapping("/seleccionaUnaNota")
    public Notas seleccionaUnaNota(@RequestParam(value = "idr") Integer idr){
        return notasService.seleccionaUnaNota(idr);
    }
    
    //Inserta nota
    @PostMapping("/insertarNota")
    public boolean insertaNota(@RequestParam(value = "usu") Integer usu,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "note") String note,
            @RequestParam(value = "fech") String fech){
        if(notasService.insertaNota(usu,title,note,fech) == 0)
            throw new ResourceNotFoundException("No se ha podido crear la nota");
        else
            return true;
    }
    
    //Modifica nota
    @PutMapping("/modificarNota")
    public boolean modificarContacto(@RequestParam(value = "id") Integer id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "note") String note,
            @RequestParam(value = "fech") String fech) {

        if(notasService.modificaNota(id,title,note,fech) == 0)
            throw new ResourceNotFoundException("No se ha podido modificar la nota");
        else
            return true;
    }

    //Elimina nota
    @DeleteMapping("/borrarNota")
    public boolean borrarContacto(@RequestParam(value = "idr") Integer idr){
        if(notasService.borrarNota(idr) == 0)
            throw new ResourceNotFoundException("No se ha podido eliminar la nota");
        else
            return true; 
    }
}
