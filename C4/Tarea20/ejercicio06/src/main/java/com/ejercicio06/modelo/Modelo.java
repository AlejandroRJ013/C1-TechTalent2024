package com.ejercicio06.modelo;

public class Modelo {
    private double mAltura;
    private double peso;
    private double imc;

    public Modelo() {
    }

    public Modelo(int cmAlt, double pes) {
        mAltura = cmAlt / 100.0;
        peso = pes;
        double elCuadrado = Math.pow(mAltura, 2);
        imc = peso / elCuadrado;
    }

    public double getMetrosAltura() {
        return mAltura;
    }

    public void setMetrosAltura(double metros) {
        mAltura = metros;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double pes) {
        peso = pes;
    }

    public double getIMC() {
        return imc;
    }

    public void setIMC(double im) {
        imc = im;
    }
}