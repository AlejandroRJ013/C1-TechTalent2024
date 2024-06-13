package com.ejercicio02.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModeloTest {

    private Modelo modelo;

    @BeforeEach
    public void setUp() {
        modelo = new Modelo();
    }

    @Test
    public void testSuma() {
        modelo.setEntrada("5");
        modelo.setEntrada(" + ");
        modelo.setEntrada("3");
        modelo.leerYOperar(modelo.getOperacion());
        assertEquals("8", modelo.getOperacion());
    }

    @Test
    public void testResta() {
        modelo.setEntrada("10");
        modelo.setEntrada(" - ");
        modelo.setEntrada("7");
        modelo.leerYOperar(modelo.getOperacion());
        assertEquals("3", modelo.getOperacion());
    }

    @Test
    public void testMultiplicacion() {
        modelo.setEntrada("4");
        modelo.setEntrada(" x ");
        modelo.setEntrada("6");
        modelo.leerYOperar(modelo.getOperacion());
        assertEquals("24", modelo.getOperacion());
    }

    @Test
    public void testDivision() {
        modelo.setEntrada("20");
        modelo.setEntrada(" / ");
        modelo.setEntrada("5");
        modelo.leerYOperar(modelo.getOperacion());
        assertEquals("4", modelo.getOperacion());
    }

    @Test
    public void testRaizCuadrada() {
        modelo.setEntrada("25");
        modelo.raiz(modelo.getOperacion());
        assertEquals("5", modelo.getOperacion());
    }

    @Test
    public void testCambioSigno() {
        modelo.setEntrada("10");
        modelo.cambiarSentido(modelo.getOperacion());
        assertEquals("-10", modelo.getOperacion());
    }

    @Test
    public void testFactorial() {
        modelo.setEntrada("5");
        modelo.factorial(modelo.getOperacion());
        assertEquals("120", modelo.getOperacion());
    }

    @Test
    public void testValorAbsoluto() {
        modelo.setEntrada("-7");
        modelo.valorAbsoluto(modelo.getOperacion());
        assertEquals("7", modelo.getOperacion());
    }

    @Test
    public void testLogaritmo() {
        modelo.setEntrada("100");
        modelo.log(modelo.getOperacion());
        assertEquals("2", modelo.getOperacion());
    }

    @Test
    public void testLogaritmoNeperiano() {
        modelo.setEntrada("10");
        modelo.logaritmoNeperiano(modelo.getOperacion());
        assertEquals("2.302585092994046", modelo.getOperacion());
    }

    @Test
    public void testElevar() {
        modelo.setEntrada("3");
        modelo.elevar(modelo.getOperacion());
        assertEquals("9", modelo.getOperacion());
    }

    @Test
    public void testPotenciaDeDiez() {
        modelo.setEntrada("2");
        modelo.potenciaDeDiez(modelo.getOperacion());
        assertEquals("100", modelo.getOperacion());
    }

    @Test
    public void testLeerYOperarConExp() {
        modelo.setEntrada("2");
        modelo.setEntrada(" exp ");
        modelo.setEntrada("3");
        modelo.leerYOperar(modelo.getOperacion());
        assertEquals("2000", modelo.getOperacion());
    }

    @Test
    public void testLeerYOperarConMod() {
        modelo.setEntrada("10");
        modelo.setEntrada(" mod ");
        modelo.setEntrada("3");
        modelo.leerYOperar(modelo.getOperacion());
        assertEquals("1", modelo.getOperacion());
    }

    @Test
    public void testBorrarUno() {
        modelo.setEntrada("123");
        modelo.borrarUno();
        assertEquals("12", modelo.getOperacion());
    }

    @Test
    public void testEntero() {
        assertTrue(modelo.entero(5));
        assertFalse(modelo.entero(5.5));
    }

    @Test
    public void testSetEntrada() {
        modelo.setEntrada("5");
        assertEquals("5", modelo.getOperacion());
    }

    @Test
    public void testGetE() {
        assertEquals(Math.E, modelo.getE());
    }

    @Test
    public void testGetPI() {
        assertEquals(Math.PI, modelo.getPI());
    }
}