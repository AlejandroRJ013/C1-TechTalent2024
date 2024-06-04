package com.ejercicio04;

import com.ejercicio04.vista.*;
import com.ejercicio04.modelo.*;
import com.ejercicio04.controlador.*;

public class App {
    public static void main( String[] args ) {
        Ventana vent = new Ventana();
        Modelo model = new Modelo();
        new Controlador(vent, model);
    }
}