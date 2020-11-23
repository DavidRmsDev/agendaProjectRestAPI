/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.service;

import com.example.restservice.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restservice.domain.Contacto;
import java.util.List;

/**
 *
 * @author franc
 */
@Service
public class ContactoService {
    
    @Autowired
    private final ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }
    
    public List<Contacto> listaContactos(Integer idUser){
        return contactoRepository.listaContactos(idUser);
    }
    
    public Contacto seleccionaUnContacto(Integer idr){
        return contactoRepository.seleccionaUnContacto(idr);
    }
    
    public int insertaContacto(Integer idUser,String name,String ape,int tel,String dire,String emilio){
        return contactoRepository.insertaContacto(idUser,name,ape,tel,dire,emilio);
    }
    
    public int modificarContacto(Integer id,String name,String ape,int tel,String dire,String emilio){
        return contactoRepository.modificarContacto(id,name,ape,tel,dire,emilio);
    }
    
    public int borrarContacto(Integer idr){
        return contactoRepository.borrarContacto(idr);
    }
}
