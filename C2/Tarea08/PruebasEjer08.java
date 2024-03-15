import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PruebasEjer08 {
    public static void main(String[] args) {
        articulosApp articulos = new articulosApp();
        HashMap<String, Integer> productoStock = new HashMap<>();
        productoStock.put("Leche", 100);
        productoStock.put("Pan", 150);
        productoStock.put("Huevos", 200);
        productoStock.put("Arroz", 80);
        productoStock.put("Pasta", 120);
        productoStock.put("Atún en lata", 1);
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

        ArrayList<String> arrayProductos = new ArrayList<>();
        for (String producto : productoStock.keySet()) {
            arrayProductos.add(producto);
        }

        String producto = "";
        int cantidad = 0;
        double precioIVA = 0.0;
        boolean masArticulos = false;
        boolean articuloEsencial = false;

        JPanel infoArticulos = new JPanel(new GridLayout(0, 2));

        infoArticulos.add(new JLabel("Nombre del producto: "));
        JComboBox<String> seleccionable = crearSeleccionable(arrayProductos);
        infoArticulos.add(seleccionable);

        infoArticulos.add(new JLabel("Cantidad:"));
        JTextField cantidadTxt = new JTextField(10);
        infoArticulos.add(cantidadTxt);

        infoArticulos.add(new JLabel("¿Más artículos?"));
        JCheckBox masArticulosCheck = new JCheckBox();
        infoArticulos.add(masArticulosCheck);

        infoArticulos.add(new JLabel("¿Artículo esencial?"));
        JCheckBox articuloEsencialCheck = new JCheckBox();
        infoArticulos.add(articuloEsencialCheck);

        JOptionPane.showMessageDialog(null, infoArticulos, "Titulo", JOptionPane.PLAIN_MESSAGE);

        producto = policiaProducto(seleccionable, producto);

        cantidad = policiaCantidad(cantidadTxt, cantidad);

        int stockFinal = revisorCantidades(productoStock, cantidad, cantidad, producto);
        productoStock.put(producto, stockFinal);

        precioIVA = precioArticuloConIva(productoPrecio, precioIVA, articuloEsencial, producto);

        masArticulos = masArticulosCheck.isSelected() ? true : false;
        articuloEsencial = articuloEsencialCheck.isSelected() ? true : false;

        articulos.setTodos(producto, cantidad, precioIVA);
        System.out.println(articulos.toString());
    }

    public static String policiaProducto(JComboBox<String> seleccionable, String producto) {
        producto = (String) seleccionable.getSelectedItem();

        if (seleccionable == null || producto.equals("- Seleccionar producto -")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return "PRODUCTO NO VÁLIDO";
        } else {
            return producto;
        }
    }

    public static int policiaCantidad(JTextField cantidadTxt, int cantidad) {
        try {
            cantidad = Integer.parseInt(cantidadTxt.getText());
            return cantidad;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad debe ser un número entero.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public static int revisorCantidades(HashMap<String, Integer> productoStock, int stockFinal, int cantidad,
            String producto) {
        int stockProducto = productoStock.get(producto);

        if (cantidad > stockProducto) {
            JOptionPane.showMessageDialog(null, "El stock del producto es de " + stockProducto
                    + " y usted esta intentando comprar " + cantidad, "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            stockFinal = stockProducto - cantidad;
            return stockFinal;
        }
    }

    public static double precioArticuloConIva(HashMap<String, Double> productoPrecio, double precioIVA,
            boolean articuloEsencial, String producto) {
        double precio = 0.0;
        for (String productoLista : productoPrecio.keySet()) {
            if (productoLista.toLowerCase().equals(producto.toLowerCase())) {
                precio = productoPrecio.get(productoLista);
            }
        }

        if (articuloEsencial) {
            precioIVA = precio * (1.04);
            return precioIVA;
        } else {
            precioIVA = precio * (1.21);
            return precioIVA;
        }
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
