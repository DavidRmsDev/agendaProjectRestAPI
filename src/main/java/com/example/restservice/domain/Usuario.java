package com.example.restservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer user;
    @Column
    private String nickname;
    @Column
    private String passsword;

    public Usuario() {
        this.user = null;
        this.nickname = null;
        this.passsword = null;
    }

    public Usuario(String nickname, String passsword) {
        this.user = null;
        this.nickname = nickname;
        this.passsword = passsword;
    }

    public Usuario(Usuario usuario) {
        this.user = usuario.getUser();
        this.nickname = usuario.getNickname();
        this.passsword = usuario.getPasssword();
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }
}
