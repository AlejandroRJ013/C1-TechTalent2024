import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ejercicio03 {
    public static void main(String[] args) {
        HashMap<String, Integer> productoStock = new HashMap<>();
        productoStock.put("Leche", 100);
        productoStock.put("Pan", 150);
        productoStock.put("Huevos", 200);
        productoStock.put("Arroz", 80);
        productoStock.put("Pasta", 120);
        productoStock.put("Atún en lata", 90);
        productoStock.put("Aceite de oliva", 110);
        productoStock.put("Queso", 70);
        productoStock.put("Yogur", 120);
        productoStock.put("Frutas y verduras", 200);

        HashMap<String, Double> productoPrecio = new HashMap<>();
        productoPrecio.put("Leche", 1.5);
        productoPrecio.put("Pan", 1.0);
        productoPrecio.put("Huevos", 2.0);
        productoPrecio.put("Arroz", 1.2);
        productoPrecio.put("Pasta", 1.3);
        productoPrecio.put("Atún en lata", 1.8);
        productoPrecio.put("Aceite de oliva", 3.0);
        productoPrecio.put("Queso", 2.5);
        productoPrecio.put("Yogur", 0.8);
        productoPrecio.put("Frutas y verduras", 30.0);

        ventana(productoStock, productoPrecio);
    }

    public static void titulo(JPanel panelTitulo) {
        panelTitulo.setBorder(new EmptyBorder(2, 20, 2, 20));
        panelTitulo.setBackground(Color.BLUE);
        JLabel titulo = new JLabel("ARTICULOS LIDL");
        titulo.setForeground(Color.YELLOW);
        titulo.setHorizontalTextPosition(SwingConstants.CENTER);
        panelTitulo.add(titulo);
    }

    public static void productos(HashMap<String, Integer> productoStock, HashMap<String, Double> productoPrecio,
            JPanel panelProductos) {
        panelProductos.setBackground(Color.LIGHT_GRAY);
        panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
        panelProductos.setBorder(new EmptyBorder(5, 10, 5, 10));
        labelProductos(productoStock, productoPrecio, panelProductos);
    }

    public static void labelProductos(HashMap<String, Integer> productoStock, HashMap<String, Double> productoPrecio,
            JPanel panelProductos) {
        int i = 1;
        for (String producto : productoStock.keySet()) {
            double precio = productoPrecio.get(producto);
            int stock = productoStock.get(producto);
            JLabel labelProductos = new JLabel(
                    "Artículo " + i + " >  " + producto + ": " + precio + "€ / " + stock + " unidades en stock");
            labelProductos.setHorizontalAlignment(SwingConstants.LEFT);
            labelProductos.setVerticalAlignment(SwingConstants.TOP);
            System.out.println(
                    "El producto <" + producto + "> de " + precio + "€ tiene un Stock de " + stock + " unidades");
            panelProductos.add(labelProductos);
            panelProductos.add(Box.createVerticalStrut(5)); // Agregar relleno vertical entre los componentes
            i++;
        }
    }

    public static void ventana(HashMap<String, Integer> productoStock, HashMap<String, Double> productoPrecio) {
        JFrame frame = new JFrame("Almacen LIDL");
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        ImageIcon icon1 = new ImageIcon("Iconos\\basket.png");
        Image scaledImg1 = icon1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImg1);

        ImageIcon icon2 = new ImageIcon("Iconos\\basket-fill.png");
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

        JPanel panelaco = new JPanel();
        panelaco.setLayout(new BoxLayout(panelaco, BoxLayout.Y_AXIS));

        JPanel panelTitulo = new JPanel();
        titulo(panelTitulo);

        JPanel panelProductos = new JPanel();
        productos(productoStock, productoPrecio, panelProductos);

        panelaco.add(panelTitulo);
        panelaco.add(panelProductos);

        cambiarCarrito(carritoVacio, carritoLleno);

        panel.add(panelBoton, BorderLayout.WEST);
        panel.add(panelaco, BorderLayout.EAST);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        // //

        // JFrame frame = new JFrame("Almacen LIDL");
        // frame.setSize(1000, 1000);
        // frame.setLayout(new BorderLayout());
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel panelaco = new JPanel();
        // panelaco.setLayout(new BoxLayout(panelaco, BoxLayout.Y_AXIS));

        // JPanel panelTitulo = new JPanel();
        // titulo(panelTitulo);

        // JPanel panelProductos = new JPanel();
        // productos(productoStock, productoPrecio, panelProductos);

        // JPanel panelAcciones = new JPanel();
        // // acciones(panelAcciones);

        // panelaco.add(panelTitulo);
        // panelaco.add(panelProductos);

        // frame.add(panelAcciones, BorderLayout.WEST);
        // frame.add(panelaco, BorderLayout.EAST);

        // frame.pack();
        // frame.setLocationRelativeTo(null);
        // frame.setVisible(true);
    }

    public static void cambiarCarrito(JButton carritoVacio, JButton carritoLleno) {
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

    // public static void acciones(JPanel panelAcciones) {
    // panelAcciones.setLayout(new GridLayout(2, 1));
    // panelAcciones.setBackground(Color.GRAY);

    // JCheckBox anadirArticulos = new JCheckBox("¿Quieres añadir un artículo?");
    // anadirArticulos.addActionListener(new ActionListener() {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // if (anadirArticulos.isSelected()) {
    // JLabel va = new JLabel("FUNCIONA");
    // panelAcciones.add(va);
    // panelAcciones.revalidate(); // Actualizar el panel para reflejar los cambios
    // } else {
    // Component[] components = panelAcciones.getComponents();
    // for (Component component : components) {
    // if (component instanceof JLabel) {
    // panelAcciones.remove(component);
    // }
    // }
    // panelAcciones.revalidate(); // Actualizar el panel para reflejar los cambios
    // }
    // }
    // });

    // panelAcciones.add(anadirArticulos);
    // }
}
