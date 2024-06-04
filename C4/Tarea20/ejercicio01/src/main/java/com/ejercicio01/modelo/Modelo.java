package com.ejercicio01.modelo;

public class Modelo {
    private static int tam;

    public Modelo() {
        tam = 20;
    }

    public Modelo(int taman) {
        tam = taman;
    }

    public int getTaman() {
        return tam;
    }

    public void setTaman(int taman) {
        tam = taman;
    }
}