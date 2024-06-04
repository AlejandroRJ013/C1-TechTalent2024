package com.ejercicio07.modelo;

public class Modelo {
    private double dineroEntrada;
    private double dineroSalida;
    private boolean euros;

    public Modelo() {
        dineroEntrada = 0;
        dineroSalida = 0;
        euros = true;
    }

    public Modelo(double dineroEn, boolean estadoActual) {
        dineroEntrada = dineroEn;
        euros = estadoActual;
        if (euros) {
            dineroSalida = dineroEn * 166.386;
        } else {
            dineroSalida = dineroEn * 0.006;
        }
    }

    public void setBooleanEuros(boolean estadoConversor) {
        euros = estadoConversor;
    }

    public double getDineroEntrada() {
        return dineroEntrada;
    }

    public double getDineroSalida() {
        return dineroSalida;
    }
}