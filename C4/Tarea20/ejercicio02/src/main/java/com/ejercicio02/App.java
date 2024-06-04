package com.ejercicio02;

import com.ejercicio02.vista.*;
import com.ejercicio02.modelo.*;
import com.ejercicio02.controlador.*;

public class App {
    public static void main( String[] args ) {
        Ventana vent = new Ventana();
        Modelo model = new Modelo();
        new Controlador(vent, model);
        vent.setVisible(true);
    }
}