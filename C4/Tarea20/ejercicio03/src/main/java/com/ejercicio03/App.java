package com.ejercicio03;

import com.ejercicio03.vista.*;
import com.ejercicio03.modelo.*;
import com.ejercicio03.controlador.*;

public class App {
    public static void main( String[] args ) {
        Ventana vent = new Ventana();
        Modelo model = new Modelo();
        new Controlador(vent, model);
        vent.setVisible(true);
    }
}