package com.ejerciciogeo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GeometriaTest {

    private Geometria geometria;

    @BeforeEach
    public void setUp() {
        geometria = new Geometria();
    }

    @Test
    public void testAreaCuadrado() {
        int lado = 4;
        int expected = 16;
        int actual = geometria.areacuadrado(lado);
        assertEquals(expected, actual, "El área del cuadrado es incorrecta");
    }

    @Test
    public void testAreaCirculo() {
        int radio = 3;
        double expected = 3.1416 * radio * radio;
        double actual = geometria.areaCirculo(radio);
        assertEquals(expected, actual, "El área del círculo es incorrecta");
    }

    @Test
    public void testAreaTriangulo() {
        int base = 4;
        int altura = 5;
        int expected = (base * altura) / 2;
        int actual = geometria.areatriangulo(base, altura);
        assertEquals(expected, actual, "El área del triángulo es incorrecta");
    }

    @Test
    public void testAreaRectangulo() {
        int base = 4;
        int altura = 6;
        int expected = base * altura;
        int actual = geometria.arearectangulo(base, altura);
        assertEquals(expected, actual, "El área del rectángulo es incorrecta");
    }

    @Test
    public void testAreaPentagono() {
        int perimetro = 5;
        int apotema = 3;
        int expected = (perimetro * apotema) / 2;
        int actual = geometria.areapentagono(perimetro, apotema);
        assertEquals(expected, actual, "El área del pentágono es incorrecta");
    }

    @Test
    public void testAreaRombo() {
        int diagonalMayor = 8;
        int diagonalMenor = 6;
        int expected = (diagonalMayor * diagonalMenor) / 2;
        int actual = geometria.arearombo(diagonalMayor, diagonalMenor);
        assertEquals(expected, actual, "El área del rombo es incorrecta");
    }

    @Test
    public void testAreaRomboide() {
        int base = 5;
        int altura = 7;
        int expected = base * altura;
        int actual = geometria.arearomboide(base, altura);
        assertEquals(expected, actual, "El área del romboide es incorrecta");
    }

    @Test
    public void testAreaTrapecio() {
        int baseMayor = 8;
        int baseMenor = 6;
        int altura = 4;
        int expected = ((baseMayor + baseMenor) / 2) * altura;
        int actual = geometria.areatrapecio(baseMayor, baseMenor, altura);
        assertEquals(expected, actual, "El área del trapecio es incorrecta");
    }
}