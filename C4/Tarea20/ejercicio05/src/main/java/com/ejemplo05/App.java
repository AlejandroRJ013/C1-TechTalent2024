package com.ejemplo05;

import com.ejemplo05.controlador.Controlador;
import com.ejemplo05.vista.Ventana;
import com.ejemplo05.modelo.Modelo;

public class App {
    public static void main( String[] args ) {
        Ventana ventana = new Ventana();
        Modelo modelo = new Modelo();
        new Controlador(ventana, modelo);
    }
}