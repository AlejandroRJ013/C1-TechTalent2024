package com.ejercicio01;

import com.ejercicio01.vista.*;
import com.ejercicio01.modelo.*;
import com.ejercicio01.controlador.*;

public class App {
    public static void main( String[] args ) {
        Ventana ven = new Ventana();
        Modelo model = new Modelo();
        new Controlador(ven, model);
        ven.setVisible(true);
    }
}