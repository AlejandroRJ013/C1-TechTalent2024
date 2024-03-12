import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.*;

public class Prueba {
    public static void main(String[] args) {
        /*
         * Hacer la interfaz del ejercicio 3 pero poner un checkbox a cada producto,
         * añadir un boton a la barra de botones {lo que hara este boton es que cuando
         * se pulse recogera todos los checkbox seleccionados, preguntara la cantidad
         * que se va a comprar de un producto(luego otro, y el siguiente, etc.), la
         * cantidad comprada se multiplica por el precio del producto y se resta
         * la cantidad que se a comprado del stock que habia del producto}
         */

        AtomicBoolean vacio = new AtomicBoolean(false);
        AtomicBoolean repetido = new AtomicBoolean(false);
        AtomicBoolean listar = new AtomicBoolean(false);
        ArrayList<String> arrayProductos = new ArrayList<>();
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
        estatico.setLayout(new GridLayout(2, 0));

        JPanel panelSeleccionables = new JPanel();
        panelSeleccionables.setLayout(new BoxLayout(panelSeleccionables, BoxLayout.Y_AXIS));
        JComboBox<String> productosBox = seleccionable(productoStock);
        panelSeleccionables.add(productosBox);
        panelSeleccionables.add(Box.createVerticalStrut(5));

        JButton recopilarInformacion = new JButton("QUE HAY");
        recopilarInformacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionablesVacios(vacio, listar, arrayProductos, panelSeleccionables);
                seleccionablesRepetidos(repetido, listar, arrayProductos);
                mensajesMalos(vacio, repetido, listar);

            }
        });

        estatico.add(recopilarInformacion);

        JPanel casillero = new JPanel();
        JLabel texto = new JLabel("¿Quieres añadir más productos?");
        JCheckBox anadirProducto = new JCheckBox();
        accionCasilla(anadirProducto, productosBox, panelSeleccionables, frame, productoStock);
        casillero.add(texto);
        casillero.add(anadirProducto);
        estatico.add(casillero);

        principal.add(panelSeleccionables);
        principal.add(estatico);
        frame.add(principal);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void mensajesMalos(AtomicBoolean vacio, AtomicBoolean repetido, AtomicBoolean listar) {
        if (vacio.get() == true) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún elemento en el JComboBox",
                    "¡Selecciona algún producto!", JOptionPane.PLAIN_MESSAGE);
        } else if (repetido.get() == true) {
            JOptionPane.showMessageDialog(null,
                    "Hay algún producto repetido, revise antes de hacer la compra",
                    "¡Productos repetidos!", JOptionPane.PLAIN_MESSAGE);
        } else {
            listar.set(true);
        }
    }

    public static void seleccionablesVacios(AtomicBoolean vacio, AtomicBoolean listar, ArrayList<String> arrayProductos,
            JPanel panelSeleccionables) {
        vacio.set(false);
        arrayProductos.clear();

        for (Component component : panelSeleccionables.getComponents()) {
            if (component instanceof JComboBox) {
                JComboBox<?> comboBox = (JComboBox<?>) component;
                String producto = (String) comboBox.getSelectedItem();
                arrayProductos.add(producto);
                if (producto == null || producto.equals("- Seleccionar producto -")) {
                    vacio.set(true);
                    listar.set(false);
                }
            }
        }
    }

    public static void seleccionablesRepetidos(AtomicBoolean repetido, AtomicBoolean listar,
            ArrayList<String> arrayProductos) {
        repetido.set(false);
        for (int i = 0; i < arrayProductos.size(); i++) {
            for (int j = i + 1; j < arrayProductos.size(); j++) {
                if (arrayProductos.get(i).equals(arrayProductos.get(j))) {
                    repetido.set(true);
                    listar.set(false);
                    break;
                }
            }
            if (repetido.get() == true) {
                break;
            }
        }
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

                        JPanel 
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