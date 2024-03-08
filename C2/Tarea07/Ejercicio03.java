import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.beans.PropertyDescriptor;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ejercicio03 {
    public static void main(String[] args) {
        StringBuilder productos = new StringBuilder("");
        
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

    public static void mostrar(HashMap<String, Integer> productoStock, HashMap<String, Double> productoPrecio, JPanel panel) {
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(5, 10, 5, 10));
        GridBagConstraints posiciones = new GridBagConstraints();

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("ARTICULOS LIDL");
        titulo.setHorizontalTextPosition(SwingConstants.CENTER);
        panelTitulo.add(titulo);
        panelTitulo.add(Box.createVerticalStrut(15)); // Agregar relleno vertical antes de los componentes
        
        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        int i = 1;
        for (String producto : productoStock.keySet()) {
            double precio = productoPrecio.get(producto);
            int stock = productoStock.get(producto);
            JLabel labelProductos = new JLabel("Artículo "+i+" >  "+producto+": "+precio+"€ / "+stock+" unidades en stock");
            labelProductos.setHorizontalAlignment(SwingConstants.CENTER);
            labelProductos.setVerticalAlignment(SwingConstants.CENTER);
            System.out.println("El producto <"+producto+"> de "+precio+"€ tiene un Stock de "+stock+" unidades");
            panelProductos.add(labelProductos);
            panelProductos.add(Box.createVerticalStrut(5)); // Agregar relleno vertical entre los componentes
            i++;
        }
        
        posiciones.gridx = 0;
        posiciones.gridy = 0;
        panel.add(panelTitulo, posiciones);
        posiciones.gridx = 0;
        posiciones.gridy = 1;
        panel.add(panelProductos, posiciones);
    }

    public static void ventana(HashMap<String, Integer> productoStock, HashMap<String, Double> productoPrecio) {
        JFrame frame = new JFrame("Almacen LIDL");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        mostrar(productoStock, productoPrecio, panel);

        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
