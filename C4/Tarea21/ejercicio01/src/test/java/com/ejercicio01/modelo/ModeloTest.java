package com.ejercicio01.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModeloTest {

    @Test
    void testSumar() {
        Modelo modelo = new Modelo();
        assertEquals(5, modelo.sumar(2, 3));
    }

    @Test
    void testRestar() {
        Modelo modelo = new Modelo();
        assertEquals(1, modelo.restar(3, 2));
    }

    @Test
    void testMultiplicar() {
        Modelo modelo = new Modelo();
        assertEquals(6, modelo.multiplicar(2, 3));
    }

    @Test
    void testDividir() {
        Modelo modelo = new Modelo();
        assertEquals(2, modelo.dividir(6, 3));
    }

    @Test
    void testDividirPorCero() {
        Modelo modelo = new Modelo();
        assertThrows(ArithmeticException.class, () -> modelo.dividir(1, 0));
    }

    @Test
    void testFraccion() {
        Modelo modelo = new Modelo();
        modelo.leerYOperar("4");
        modelo.fraccion(modelo.getOperacion());
        assertEquals("0.25", modelo.getOperacion());
    }

    @Test
    void testElevar() {
        Modelo modelo = new Modelo();
        modelo.leerYOperar("2");
        modelo.elevar(modelo.getOperacion());
        assertEquals("4", modelo.getOperacion());
    }

    @Test
    void testRaiz() {
        Modelo modelo = new Modelo();
        modelo.leerYOperar("9");
        modelo.raiz(modelo.getOperacion());
        assertEquals("3", modelo.getOperacion());
    }

    @Test
    void testPorcentaje() {
        Modelo modelo = new Modelo();
        modelo.leerYOperar("100+20%");
        modelo.porcentaje(modelo.getOperacion().toString());
        assertEquals("120", modelo.getOperacion());
    }

    @Test
    void testCambiarSentido() {
        Modelo modelo = new Modelo();
        modelo.leerYOperar("5");
        modelo.cambiarSentido(modelo.getOperacion());
        assertEquals("-5", modelo.getOperacion());
    }

    @Test
    void testLeerYOperar() {
        Modelo modelo = new Modelo();
        modelo.leerYOperar("2+3");
        assertEquals("5", modelo.getOperacion());
    }

    @Test
    void testLimpiarOperacionYHistorial() {
        Modelo modelo = new Modelo();
        modelo.leerYOperar("2+3");
        modelo.limpiarOperacionYHistorial();
        assertEquals("0", modelo.getOperacion());
    }
}