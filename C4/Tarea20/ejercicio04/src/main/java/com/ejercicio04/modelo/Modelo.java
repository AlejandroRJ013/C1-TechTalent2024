package com.ejercicio04.modelo;

public class Modelo {
    private StringBuilder area = new StringBuilder();

    public Modelo() {
    }

    public StringBuilder getTexto() {
        return area;
    }

    public void appendInfo(String texto) {
        area.append(texto + "\n");
    }
}