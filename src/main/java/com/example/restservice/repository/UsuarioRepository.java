/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.repository;

import com.example.restservice.domain.Usuario;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author franc
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @Query(nativeQuery = true,value = "call comprobarNombreUsuario(:nick)")
    int comprobarNickname(@Param("nick") String nick);
    
    @Query(nativeQuery = true,value = "call seleccionaUsuario(:nick,:pass)")
    Integer comprobarLogin(@Param("nick") String nickname, @Param("pass") String password);
    
    
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "call insertaUsuario(:nick,:pass)")
    int crearUsuario(@Param("nick") String nickname, @Param("pass") String password);
}
