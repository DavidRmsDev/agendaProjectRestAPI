/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.exception;

import java.util.Date;

/**
 *
 * @author franc
 */
public class ErrorDetails {
    
    private Date timeStamp;
    private String mensaje;
    private String detalles;

    public ErrorDetails(Date timeStamp, String mensaje, String detalles) {
        this.timeStamp = timeStamp;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }
    
    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
