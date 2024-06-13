package com.ejercicio01.vista;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VentanaTest {

    @Test
    void testCrearVentana() {
        Ventana ventana = new Ventana();
        assertNotNull(ventana);
        assertTrue(ventana.isVisible());
        assertEquals("Calculadora Estándar", ventana.getTitle());
    }

    @Test
    void testActualizarPantalla() {
        Ventana ventana = new Ventana();
        ventana.actualizarPantalla("123");
        assertEquals("123", ventana.obtenerTextoPantalla());
    }

    @Test
    void testLimpiarPantalla() {
        Ventana ventana = new Ventana();
        ventana.actualizarPantalla("123");
        ventana.limpiarPantalla();
        assertEquals("0", ventana.obtenerTextoPantalla());
    }
}