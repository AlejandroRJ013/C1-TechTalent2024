package proyecto.memory.controlador;

import proyecto.memory.ventana.Ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controlador implements ActionListener {
    private Ventana ventana;
    private JToggleButton interruptor1;
    private JToggleButton interruptor2;

    public Controlador(Ventana ventanaEntrada) {
        this.ventana = ventanaEntrada;
        this.ventana.addAccionBoton(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton interruptor = (JToggleButton) e.getSource();
        if (interruptor1 == null) {
            interruptor1 = interruptor;
            interruptor1.setBackground(
                    ventana.getColoresBoton()[interruptor1.hashCode() % ventana.getColoresBoton().length]);
            interruptor1.setSelected(true);
        } else {
            interruptor2 = interruptor;
            interruptor2.setBackground(
                    ventana.getColoresBoton()[interruptor2.hashCode() % ventana.getColoresBoton().length]);
            interruptor2.setSelected(true);
            ventana.updateScreen();
            if (interruptor1.getBackground() != interruptor2.getBackground()) {
                interruptor1.setSelected(false);
                interruptor2.setSelected(false);
                interruptor1.setBackground(Color.LIGHT_GRAY);
                interruptor2.setBackground(Color.LIGHT_GRAY);
            }
        }
    }
}