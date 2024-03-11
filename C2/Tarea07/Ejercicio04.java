import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

public class Ejercicio04 {
    public static void main(String[] args) {
        /*
         * Hacer la interfaz del ejercicio 3 pero poner un checkbox a cada producto,
         * añadir un boton a la barra de botones {lo que hara este boton es que cuando
         * se pulse recogera todos los checkbox seleccionados, preguntara la cantidad
         * que se va a comprar de un producto(luego otro, y el siguiente, etc.), la
         * cantidad comprada se multiplica por el precio del producto y se resta
         * la cantidad que se a comprado del stock que habia del producto}
         */

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

        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel principal = new JPanel();
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));

        JPanel estatico = new JPanel();
        estatico.setLayout(new GridLayout(2, 1));
        JComboBox<String> productosBox = seleccionable(productoStock);
        estatico.add(productosBox);

        JPanel panelSeleccionables = new JPanel();
        panelSeleccionables.setLayout(new BoxLayout(panelSeleccionables, BoxLayout.Y_AXIS));

        JButton recopilarInformacion = new JButton("QUE HAY");
        recopilarInformacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Component component : panelSeleccionables.getComponents()) {
                    if (component instanceof JComboBox) {
                        JComboBox<String> comboBox = (JComboBox<String>) component;
                        Object seleccion = comboBox.getSelectedItem();
                        if (seleccion != null && !seleccion.equals("- Seleccionar producto -")) {
                            String productoSeleccionado = seleccion.toString();
                            System.out.println("Producto seleccionado: " + productoSeleccionado);
                            // Aquí puedes guardar la información en algún lugar, como una lista o un mapa
                        }
                    }
                }
            }
        });
        estatico.add(recopilarInformacion);

        JLabel texto = new JLabel("¿Quieres añadir más productos?");
        JCheckBox anadirProducto = new JCheckBox();
        accionCasilla(anadirProducto, productosBox, panelSeleccionables, frame, productoStock);
        estatico.add(texto);
        estatico.add(anadirProducto);

        principal.add(panelSeleccionables);
        principal.add(estatico);
        frame.add(principal);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static JComboBox<String> seleccionable(HashMap<String, Integer> productoStock) {
        String[] productos = new String[(productoStock.size() + 1)];
        productos[0] = "- Seleccionar producto -";
        int i = 1;
        for (String producto : productoStock.keySet()) {
            productos[i] = producto;
            i++;
        }
        JComboBox<String> productosBox = new JComboBox<>(productos);
        productosBox.setSize(100, 30);

        return productosBox;
    }

    public static void accionCasilla(JCheckBox anadirProducto, JComboBox<String> productosBox,
            JPanel panelSeleccionables, JFrame frame,
            HashMap<String, Integer> productoStock) {
        anadirProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (anadirProducto.isSelected()) {
                    if (productosBox != null && productosBox.getSelectedItem() != "- Seleccionar producto -") {
                        String productoSeleccionado = String.valueOf(productosBox.getSelectedItem());
                        System.out.println("Producto seleccionado: " + productoSeleccionado);

                        anadirProducto.setSelected(false);
                        frame.setSize(1000, 1000);

                        JComboBox<String> productosBox = seleccionable(productoStock);
                        panelSeleccionables.add(productosBox);
                        panelSeleccionables.add(Box.createVerticalStrut(5));
                        panelSeleccionables.repaint();
                        panelSeleccionables.revalidate();

                        frame.pack();
                        frame.setLocationRelativeTo(null);
                    } else {
                        System.out.println("Ningún producto seleccionado.");
                        anadirProducto.setSelected(false);
                    }
                }
            }
        });
    }
}
