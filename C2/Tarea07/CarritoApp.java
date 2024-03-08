import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CarritoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Carrito de la compra");
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        ImageIcon icon1 = new ImageIcon("C:\\Users\\Alejandro RJ\\eclipse-workspace\\TechTalent2024\\C2\\Tarea07\\Iconos\\basket.png"); //Portátil
        // ImageIcon icon1 = new ImageIcon(
        //         "C:\\Users\\aleja\\Documents\\GitHub\\TechTalent2024\\C2\\Tarea07\\Iconos\\basket.png"); // Casa
        Image scaledImg1 = icon1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImg1);

        ImageIcon icon2 = new ImageIcon("C:\\Users\\Alejandro RJ\\eclipse-workspace\\TechTalent2024\\C2\\Tarea07\\Iconos\\basket-fill.png");
        // Portátil
        // ImageIcon icon2 = new ImageIcon(
        //         "C:\\Users\\aleja\\Documents\\GitHub\\TechTalent2024\\C2\\Tarea07\\Iconos\\basket-fill.png"); // Casa
        Image scaledImg2 = icon2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImg2);

        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.Y_AXIS));
        // panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setBackground(Color.LIGHT_GRAY);

        JLabel agregar_eliminar = new JLabel("Agregar / Eliminar productos");
        panelBoton.add(agregar_eliminar);

        JButton carritoVacio = new JButton(scaledIcon1);
        carritoVacio.setContentAreaFilled(false);
        carritoVacio.setBorderPainted(false);

        JButton carritoLleno = new JButton(scaledIcon2);
        carritoLleno.setContentAreaFilled(false);
        carritoLleno.setBorderPainted(false);
        carritoLleno.setVisible(false);

        panelBoton.add(carritoVacio);
        panelBoton.add(carritoLleno);

        click(carritoVacio, carritoLleno);

        panel.add(panelBoton, BorderLayout.EAST);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void click(JButton carritoVacio, JButton carritoLleno) {
        carritoVacio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carritoVacio.setVisible(false);
                carritoLleno.setVisible(true);
            }
        });

        carritoLleno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carritoVacio.setVisible(true);
                carritoLleno.setVisible(false);
            }
        });
    }
}