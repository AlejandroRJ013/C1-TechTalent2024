package com.ejercicio07;

import com.ejercicio07.ventana.*;
import com.ejercicio07.modelo.*;
import com.ejercicio07.controlador.*;

public class App {
    public static void main( String[] args ) {
        Modelo model = new Modelo();
        Ventana vent = new Ventana();
        new Controlador(vent, model);
    }
}
