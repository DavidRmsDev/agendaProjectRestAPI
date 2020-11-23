/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.service;

import com.example.restservice.domain.Recordatorio;
import com.example.restservice.repository.RecordatorioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
public class RecordatorioService {
    
    private final RecordatorioRepository recordatorioRespository;

    public RecordatorioService(RecordatorioRepository recordatorioRespository) {
        this.recordatorioRespository = recordatorioRespository;
    }
    
    public List<Recordatorio> seleccionaRecordatorio(Integer usu){
        return recordatorioRespository.seleccionaRecordatorio(usu);
    }
    
    public Recordatorio seleccionaUnRecordatorio(Integer idr){
        return recordatorioRespository.seleccionaUnRecordatorio(idr);
    }
    
    public int insertaRecordatorio(Integer usu,String title,String fech,String hora,String descr){
        return recordatorioRespository.insertaRecordatorio(usu,title,fech,hora,descr);
    }
    
    public int modificaRecordatorio(Integer id,String title,String fech,String hora,String descr){
        return recordatorioRespository.modificaRecordatorio(id,title,fech,hora,descr);
    }
    
    public int borrarRecordatorio(Integer idr){
        return recordatorioRespository.borrarRecordatorio(idr);
    }
    
}
