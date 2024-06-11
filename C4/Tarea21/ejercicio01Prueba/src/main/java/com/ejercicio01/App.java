package com.ejercicio01;

import com.ejercicio01.controlador.*;
import com.ejercicio01.modelo.*;
import com.ejercicio01.vista.*;

public class App {
    public static void main( String[] args ) {
        Modelo modelo = new Modelo();
        Ventana vista = new Ventana();
        new Controlador(modelo, vista);
    }
}