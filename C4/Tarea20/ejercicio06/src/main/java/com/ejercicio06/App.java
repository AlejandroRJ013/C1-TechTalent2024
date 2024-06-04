package com.ejercicio06;

import com.ejercicio06.vista.*;
import com.ejercicio06.controlador.*;
import com.ejercicio06.modelo.*;

public class App {
    public static void main( String[] args ) {
        Ventana ventana = new Ventana();
        Modelo modelo = new Modelo();
        new Controlador(ventana, modelo);
    }
}