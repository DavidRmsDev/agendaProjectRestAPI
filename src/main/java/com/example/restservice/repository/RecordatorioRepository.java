/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.repository;

import com.example.restservice.domain.Recordatorio;
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
public interface RecordatorioRepository extends JpaRepository<Recordatorio, Integer>{
    
    @Query(nativeQuery = true,value = "call seleccionaRecordatorio(:usu)")
    List<Recordatorio> seleccionaRecordatorio(@Param("usu") Integer Usu);
    
    @Query(nativeQuery = true,value = "call seleccionaUnRecordatorio(:idr)")
    Recordatorio seleccionaUnRecordatorio(@Param("idr") Integer idr);
    
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call insertaRecordatorio(:usu,:title,:fech,:hora,:descr)")
    int insertaRecordatorio(@Param("usu") Integer usu, @Param("title") String title,
            @Param("fech") String fech, @Param("hora") String hora, @Param("descr") String descr);
    
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call modificaRecordatorio(:id,:title,:fech,:hora,:descr)")
    int modificaRecordatorio(@Param("id") Integer id, @Param("title") String title,
            @Param("fech") String fech, @Param("hora") String hora, @Param("descr") String descr);
    
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "call borrarRecordatorio(:idr)")
    int borrarRecordatorio(@Param("idr") Integer idr);
}
