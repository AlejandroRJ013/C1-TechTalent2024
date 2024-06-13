package com.ejercicio02.controlador;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import com.ejercicio02.modelo.Modelo;
import com.ejercicio02.vista.Ventana;

public class ControladorTest {

    private Modelo modelo;
    private Ventana vista;
    private Controlador controlador;

    @BeforeEach
    public void setUp() {
        modelo = new Modelo();
        vista = new Ventana();
        controlador = new Controlador(modelo, vista);
    }

    @Test
    public void testBotonPi() {
        JButton boton = new JButton("π");
        ActionEvent event = new ActionEvent(boton, ActionEvent.ACTION_PERFORMED, "");
        controlador.new AccionBoton().actionPerformed(event);
        assertEquals(String.valueOf(Math.PI), modelo.getOperacion());
    }

    @Test
    public void testBotonE() {
        JButton boton = new JButton("e");
        ActionEvent event = new ActionEvent(boton, ActionEvent.ACTION_PERFORMED, "");
        controlador.new AccionBoton().actionPerformed(event);
        assertEquals(String.valueOf(Math.E), modelo.getOperacion());
    }

    @Test
    public void testBotonCE() {
        modelo.setEntrada("123");
        JButton boton = new JButton("CE");
        ActionEvent event = new ActionEvent(boton, ActionEvent.ACTION_PERFORMED, "");
        controlador.new AccionBoton().actionPerformed(event);
        assertEquals("0", modelo.getOperacion());
    }
}