package com.ejercicio02;

import com.ejercicio02.controlador.*;
import com.ejercicio02.modelo.*;
import com.ejercicio02.vista.*;

public class App {
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        Modelo modelo = new Modelo();
        new Controlador(modelo, ventana);
    }
}