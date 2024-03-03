import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CarritoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Carrito de la compra");
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        ImageIcon icon1 = new ImageIcon(
                "C:\\Users\\aleja\\Documents\\GitHub\\TechTalent2024\\C2\\Tarea07\\Iconos\\basket.png");
        Image scaledImg1 = icon1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImg1);

        ImageIcon icon2 = new ImageIcon(
                "C:\\Users\\aleja\\Documents\\GitHub\\TechTalent2024\\C2\\Tarea07\\Iconos\\basket-fill.png");
        Image scaledImg2 = icon2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImg2);

        JPanel panelBoton = new JPanel();
        panelBoton.setBounds(340, 0, 45, 45);
        panelBoton.setBackground(Color.LIGHT_GRAY);

        JPanel carritoVacio = new JPanel();
        carritoVacio.add(new JLabel(scaledIcon1));

        JPanel carritoLleno = new JPanel();
        carritoLleno.add(new JLabel(scaledIcon2));

        click(panelBoton, carritoVacio, carritoLleno);

        panelBoton.add(carritoVacio);
        panel.add(panelBoton);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void click(JPanel panelBoton, JPanel carritoVacio, JPanel carritoLleno) {
        carritoVacio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelBoton.removeAll();
                panelBoton.add(carritoLleno);
                panelBoton.revalidate();
                panelBoton.repaint();
            }
        });

        carritoLleno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelBoton.removeAll();
                panelBoton.add(carritoVacio);
                panelBoton.revalidate();
                panelBoton.repaint();
            }
        });
    }
}
