package com.ejercicio01.controlador;

import com.ejercicio01.modelo.Modelo;
import com.ejercicio01.vista.Ventana;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.*;
import java.awt.event.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControladorTest {

    @Mock
    private Modelo modelo;

    @Mock
    private Ventana vista;

    @InjectMocks
    private Controlador controlador;

    @Test
    void testBotonIgual() {
        // Configura el comportamiento del modelo mock
        when(modelo.getOperacion()).thenReturn("3");

        // Simula el clic en el botón "="
        JButton botonIgual = new JButton("=");
        ActionEvent evento = new ActionEvent(botonIgual, ActionEvent.ACTION_PERFORMED, null);
        controlador.new AccionBoton().actionPerformed(evento);

        // Verifica las interacciones con el mock
        verify(modelo).leerYOperar(anyString());
        verify(vista).actualizarPantalla("3");
        verify(modelo).limpiarOperacion();
    }

    @Test
    void testBotonCE() {
        // Configura el comportamiento del modelo mock
        when(modelo.getOperacion()).thenReturn("0");

        // Simula el clic en el botón "CE"
        JButton botonCE = new JButton("CE");
        ActionEvent evento = new ActionEvent(botonCE, ActionEvent.ACTION_PERFORMED, null);
        controlador.new AccionBoton().actionPerformed(evento);

        // Verifica las interacciones con el mock
        verify(modelo).limpiarOperacion();
        verify(vista).actualizarPantalla("0"); // Asumiendo que "0" es el valor esperado después de limpiar
    }

}
