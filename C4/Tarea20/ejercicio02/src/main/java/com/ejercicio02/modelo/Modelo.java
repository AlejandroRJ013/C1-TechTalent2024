package com.ejercicio02.modelo;

public class Modelo {
    private String botonPulsado;

    public Modelo() {
        botonPulsado = "Ninguno";
    }

    public Modelo(String boton) {
        botonPulsado = boton;
    }

    public void setBotonPulsado(String pulsado) {
        botonPulsado = pulsado;
    }

    public String getBotonPulsado() {
        return botonPulsado;
    }
}