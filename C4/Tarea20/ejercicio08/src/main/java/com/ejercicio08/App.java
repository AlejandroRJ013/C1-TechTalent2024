package com.ejercicio08;

import com.ejercicio08.ventana.*;
import com.ejercicio08.modelo.*;
import com.ejercicio08.controlador.*;

public class App {
    public static void main( String[] args ) {
        Modelo model = new Modelo();
        Ventana vent = new Ventana();
        new Controlador(vent, model);
    }
}