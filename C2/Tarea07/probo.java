import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class probo {
    public static void main(String[] args) {
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

        HashMap<String, Double> productoPrecio = new HashMap<>();
        productoPrecio.put("Leche", 1.50);
        productoPrecio.put("Pan", 0.60);
        productoPrecio.put("Huevos", 2.0);
        productoPrecio.put("Arroz", 1.2);
        productoPrecio.put("Pasta", 5.25);
        productoPrecio.put("Atún en lata", 3.30);
        productoPrecio.put("Aceite de oliva", 12.0);
        productoPrecio.put("Queso", 2.5);
        productoPrecio.put("Yogur", 2.25);
        productoPrecio.put("Frutas y verduras", 15.0);

        for (String producto : productoStock.keySet()) {
            arrayProductos.add(producto);
        }

        JPanel panel = new JPanel();
        JComboBox<String> seleccionable = crearSeleccionable(arrayProductos);
        panel.add(seleccionable);
        JOptionPane.showMessageDialog(null, panel, "Titulo", JOptionPane.PLAIN_MESSAGE);

        panel.removeAll();
        arrayProductos.remove(seleccionable.getSelectedItem());
        JComboBox<String> seleccionable2 = crearSeleccionable(arrayProductos);
        panel.add(seleccionable2);
        JOptionPane.showMessageDialog(null, panel, "Titulo", JOptionPane.PLAIN_MESSAGE);

    }

    public static JComboBox<String> crearSeleccionable(ArrayList<String> arrayProductos) {
        String[] productos = new String[(arrayProductos.size() + 1)];
        productos[0] = "- Seleccionar producto -";
        int i = 1;
        for (String producto : arrayProductos) {
            productos[i] = producto;
            i++;
        }
        JComboBox<String> seleccionable = new JComboBox<>(productos);

        return seleccionable;
    }
}
