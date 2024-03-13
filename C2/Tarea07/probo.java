import java.util.*;
import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class probo {
    public static void main(String[] args) {
        DecimalFormat dosDecimales = new DecimalFormat("#.##");
        StringBuilder texto = new StringBuilder("PRECIO DE LOS ARTICULOS\n");
        double totalCompra = 0;
        double totalProducto = 0;

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

        HashMap<String, Integer> cesta = new HashMap<>();


        for (String producto : productoStock.keySet()) {
            arrayProductos.add(producto);
        }
        
        compra(arrayProductos, productoPrecio, cesta, dosDecimales, texto, totalCompra, totalProducto);
    }

    public static void compra(ArrayList<String> arrayProductos, HashMap<String, Double> productoPrecio, HashMap<String, Integer> cesta, DecimalFormat dosDecimales, StringBuilder texto, double totalCompra, double totalProducto) {
        boolean continuar = true;
        String eliminar = "";
        while (continuar) {

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

            eliminar = (String) seleccionable.getSelectedItem();
            if (!masArticulos.isSelected()) {
                continuar = false;
            } else if (eliminar.equals("- Seleccionar producto -") || cantidad.getText().isEmpty() || cantidad.getText().equals("0")) {
                JOptionPane.showMessageDialog(null, "Ingrese un producto o un precio superior a 0", "Ingrese valores", JOptionPane.WARNING_MESSAGE);
            } else {
                arrayProductos.remove(eliminar);
            }

            int cantidadProducto = Integer.parseInt(cantidad.getText());
            cesta.put(eliminar, cantidadProducto);

            double precioProducto = 0;
            double precioIVA = 0;
            for (String nomProducto : cesta.keySet()) {
                for (String productoLista : productoPrecio.keySet()){
                    if (productoLista.equals(nomProducto)) {
                        precioProducto = productoPrecio.get(productoLista);
                    }
                }
            }
            if (articuloEsencial.isSelected()) {
            precioIVA = precioProducto * 1.04;
            totalProducto = precioIVA * cantidadProducto;

            String precioIVAFormateado = dosDecimales.format(precioIVA);
            String totalFormateado = dosDecimales.format(totalProducto);
            texto.append("Producto: '" + eliminar + "'\n    Precio/unidad: <" + precioProducto
                    + "> / <"+cantidadProducto+">\n    IVA aplicado [4%] => PrecioIVA/unidad ["+precioIVAFormateado+"]\n    Precio total: <" + totalFormateado + ">\n\n");
            } else {
            precioIVA = precioProducto * 1.21;
            totalProducto = precioIVA * cantidadProducto;

            String precioIVAFormateado = dosDecimales.format(precioIVA);
            String totalFormateado = dosDecimales.format(totalProducto);
            texto.append("Producto: '" + eliminar + "'\n    Precio/unidad: <" + precioProducto
                    + "> / <"+cantidadProducto+">\n    IVA aplicado [21%] => PrecioIVA/unidad ["+precioIVAFormateado+"]\n    Precio total: <" + totalFormateado + ">\n\n");
            }
            totalCompra += totalProducto;
        }
        ticket(dosDecimales, texto, totalCompra);
    }

    public static void ticket(DecimalFormat dosDecimales, StringBuilder texto, double totalCompra) {
        String laMulta = dosDecimales.format(totalCompra);
        double losBilletes = Double
                .parseDouble(JOptionPane.showInputDialog(null, texto.toString() + "\nTotal a pagar: " + laMulta));
        double cambio = losBilletes - totalCompra;
        String laCalderilla = dosDecimales.format(cambio);
        JOptionPane.showMessageDialog(null,
                "Has pagado el precio de " + laMulta + " con " + losBilletes + "\nTus vueltas son ==> " + laCalderilla);
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
