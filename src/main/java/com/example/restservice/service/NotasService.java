/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.service;

import com.example.restservice.domain.Notas;
import com.example.restservice.repository.NotasRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
public class NotasService {
    
    private final NotasRepository notasRepository;

    public NotasService(NotasRepository notasRepository) {
        this.notasRepository = notasRepository;
    }
    
    public List<Notas> seleccionaNota(Integer usu){
        return notasRepository.seleccionaNota(usu);
    }
    
    public Notas seleccionaUnaNota(Integer idr){
        return notasRepository.seleccionaUnaNota(idr);
    }
    
    public int insertaNota(Integer usu,String title,String note,String fech){
        return notasRepository.insertaNota(usu,title,note,fech);
    }
    
    public int modificaNota(Integer id,String title,String note,String fech){
        return notasRepository.modificaNota(id,title,note,fech);
    }
    
    public int borrarNota(Integer idr){
        return notasRepository.borrarNota(idr);
    }
}
