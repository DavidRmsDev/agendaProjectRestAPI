/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.repository;

import com.example.restservice.domain.Notas;
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
public interface NotasRepository extends JpaRepository<Notas, Integer>{
    
    @Query(nativeQuery = true,value = "call seleccionaNota(:usu)")
    List<Notas> seleccionaNota(@Param("usu") Integer Usu);
    
    @Query(nativeQuery = true,value = "call seleccionaUnaNota(:idr)")
    Notas seleccionaUnaNota(@Param("idr") Integer idr);
    
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call insertaNota(:usu,:title,:note,:fech)")
    int insertaNota(@Param("usu") Integer usu, @Param("title") String title,
            @Param("note") String note, @Param("fech") String fech);
    
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call modificaNota(:id,:title,:note,:fech)")
    int modificaNota(@Param("id") Integer id, @Param("title") String title,
            @Param("note") String note, @Param("fech") String fech);
    
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call borrarNota(:idr)")
    int borrarNota(@Param("idr") Integer idr);
}
