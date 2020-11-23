/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.repository;

import com.example.restservice.domain.Contacto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author franc
 */
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
    
    @Query(nativeQuery = true,value = "call seleccionaContacto(:usu)")
    List<Contacto> listaContactos(@Param("usu") Integer idUser);
    
    @Query(nativeQuery = true,value = "call seleccionaUnContacto(:idr)")
    Contacto seleccionaUnContacto(@Param("idr") Integer idr);
            
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call insertaContacto(:usu,:name,:ape,:tel,:dire,:emilio)")
    int insertaContacto(@Param("usu") Integer idUser, @Param("name") String name, @Param("ape") String ape,
            @Param("tel") int tel, @Param("dire") String dire, @Param("emilio") String emilio);
    
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call modificaContacto(:id,:name,:ape,:tel,:dire,:emilio)")
    int modificarContacto(@Param("id") Integer id, @Param("name") String name, @Param("ape") String ape,
            @Param("tel") int tel, @Param("dire") String dire, @Param("emilio") String emilio);
    
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call borrarContacto(:idr)")
    int borrarContacto(@Param("idr") Integer idr);
    
}
