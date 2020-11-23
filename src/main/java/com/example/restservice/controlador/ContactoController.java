/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.controlador;

import com.example.restservice.domain.Contacto;
import com.example.restservice.exception.ResourceNotFoundException;
import com.example.restservice.service.ContactoService;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
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
public class ContactoController {
    
    private ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }
    
    //Lista todos los contactos
    @GetMapping("/contactos")
    public List<Contacto> listarContactos(@RequestParam(value = "id") Integer idUser) {
        return contactoService.listaContactos(idUser);
    }
    
    //TODO Crear metodo que devuelva Contacto dado un ID
    @GetMapping("/seleccionaUnContacto")
    public Contacto seleccionaUnContacto(@RequestParam(value = "idr") Integer idr){
        return contactoService.seleccionaUnContacto(idr);
    }
    
    //Inserta contacto
    @PostMapping("/insertarContacto")
    public boolean insertaContacto(@RequestParam(value = "idUser") Integer idUser,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "ape") String ape,
            @RequestParam(value = "tel") int tel,
            @RequestParam(value = "dire") String dire,
            @RequestParam(value = "emilio") String emilio){
        
        try{
            if(contactoService.insertaContacto(idUser,name,ape,tel,dire,emilio) == 0)
                throw new ResourceNotFoundException("No se ha podido crear al contacto");
            else
                return true;
        } catch (DataIntegrityViolationException ex) {
                throw new ResourceNotFoundException("El telefono del contacto no puede estar duplicado");
        }
    }
    
    //Modifica contacto
    @PutMapping("/modificarContacto")
    public boolean modificarContacto(@RequestParam(value = "id") Integer id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "ape") String ape,
            @RequestParam(value = "tel") int tel,
            @RequestParam(value = "dire") String dire,
            @RequestParam(value = "emilio") String emilio) {
        try {
            if(contactoService.modificarContacto(id, name, ape, tel, dire, emilio) == 0)
                throw new ResourceNotFoundException("No se ha podido modificar al contacto");
            else
                return true;
        } catch (DataIntegrityViolationException ex) {
            throw new ResourceNotFoundException("El telefono del contacto no puede estar duplicado");
        }
    }

    //Elimina contacto
    @DeleteMapping("/borrarContacto")
    public boolean borrarContacto(@RequestParam(value = "idr") Integer idr){
        if(contactoService.borrarContacto(idr) == 0)
            throw new ResourceNotFoundException("No se ha podido eliminar al contacto");
        else
            return true;
    }
}
