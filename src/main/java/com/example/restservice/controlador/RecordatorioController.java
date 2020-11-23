/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.controlador;

import com.example.restservice.domain.Notas;
import com.example.restservice.domain.Recordatorio;
import com.example.restservice.exception.ResourceNotFoundException;
import com.example.restservice.service.RecordatorioService;
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
public class RecordatorioController {
    
    private RecordatorioService recordatorioService;

    public RecordatorioController(RecordatorioService recordatorioService) {
        this.recordatorioService = recordatorioService;
    }
    
    //Muestra todas los recordatorios de un usuario
    @GetMapping("/seleccionaRecordatorio")
    public List<Recordatorio> seleccionaRecordatorio(@RequestParam(value = "usu") Integer usu){
        return recordatorioService.seleccionaRecordatorio(usu);
    }
    
    //Devuelve una nota
    @GetMapping("/seleccionaUnRecordatorio")
    public Recordatorio seleccionaUnRecordatorio(@RequestParam(value = "idr") Integer idr){
        return recordatorioService.seleccionaUnRecordatorio(idr);
    }
    
    //Inserta recordatorio
    @PostMapping("/insertarRecordatorio")
    public Boolean insertaRecordatorio(@RequestParam(value = "usu") Integer usu,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "fech") String fech,
            @RequestParam(value = "hora") String hora,
            @RequestParam(value = "descr") String descr){
        if(recordatorioService.insertaRecordatorio(usu,title,fech,hora,descr) == 0)
            throw new ResourceNotFoundException("No se ha podido crear el recordatorio");
        else
            return true;
    }
    
    //Modifica recordatorio
    @PutMapping("/modificarRecordatorio")
    public Boolean modificarRecordatorio(@RequestParam(value = "id") Integer id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "fech") String fech,
            @RequestParam(value = "hora") String hora,
            @RequestParam(value = "descr") String descr) {

        if(recordatorioService.modificaRecordatorio(id,title,fech,hora,descr) == 0)
            throw new ResourceNotFoundException("No se ha podido modificar el recordatorio");
        else
            return true;
    }

    //Elimina recordatorio
    @DeleteMapping("/borrarRecordatorio")
    public Boolean borrarRecordatorio(@RequestParam(value = "idr") Integer idr){
        if(recordatorioService.borrarRecordatorio(idr) == 0)
            throw new ResourceNotFoundException("No se ha podido eliminar el recordatorio");
        else
            return true;
    }
}
