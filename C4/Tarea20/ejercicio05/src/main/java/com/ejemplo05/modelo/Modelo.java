package com.ejemplo05.modelo;

public class Modelo {
    private StringBuilder accionesRaton = new StringBuilder();

    public Modelo() {
    }

    public StringBuilder getTexto() {
        return accionesRaton;
    }

    public void setTexto(String texto) {
        accionesRaton = new StringBuilder(texto);
    }

    public void appendInfo(String texto) {
        accionesRaton.append(texto + "\n");
    }
}