import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PruebasEjer08 {
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

        ArrayList<String> arrayProductos = new ArrayList<>();
        for (String producto : productoStock.keySet()) {
            arrayProductos.add(producto);
        }
        
        JPanel infoArticulos = new JPanel(new GridLayout(0, 2));

            infoArticulos.add(new JLabel("Nombre del producto: "));
            JComboBox<String> seleccionable = crearSeleccionable(arrayProductos);
            infoArticulos.add(seleccionable);

            infoArticulos.add(new JLabel("Cantidad:"));
            JTextField cantidad = new JTextField(10);
            infoArticulos.add(cantidad);

            infoArticulos.add(new JLabel("¿Más artículos?"));
            JCheckBox masArticulos = new JCheckBox();
            infoArticulos.add(masArticulos);

            infoArticulos.add(new JLabel("¿Artículo esencial?"));
            JCheckBox articuloEsencial = new JCheckBox();
            infoArticulos.add(articuloEsencial);

            JOptionPane.showMessageDialog(null, infoArticulos, "Titulo", JOptionPane.PLAIN_MESSAGE);

            String producto = (String) seleccionable.getSelectedItem();

            int cantidadProducto = Integer.parseInt(cantidad.getText());
            
            boolean continuar;
            if (masArticulos.isSelected()) {
                continuar = true;
            } else {
                continuar = false;
            }
            
            boolean esencial;
            if (articuloEsencial.isSelected()) {
                esencial = true;
            } else {
                esencial = false;
            }

            articulosApp articulos = new articulosApp(producto, cantidadProducto);
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
