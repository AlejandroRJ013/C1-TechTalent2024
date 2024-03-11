import java.util.HashMap;
import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Ejercicio02 {
    public static void main(String[] args) {
        HashMap<String, Double> cesta = new HashMap<>();
        DecimalFormat dosDecimales = new DecimalFormat("#.##");
        StringBuilder texto = new StringBuilder("PRECIO DE LOS ARTICULOS\n");
        final double IVA = 0.21;
        final double IVAmin = 0.04;
        double precioIVA = 0;
        double totalCompra = 0;
        JTextField producto;
        JTextField precio;

        boolean continuar = true;
        while (continuar) {
            JPanel infoArticulos = new JPanel(new GridLayout(0, 2));

            infoArticulos.add(new JLabel("Nombre del producto: "));
            producto = new JTextField(10);
            infoArticulos.add(producto);

            infoArticulos.add(new JLabel("Precio:"));
            precio = new JTextField(10);
            infoArticulos.add(precio);

            infoArticulos.add(new JLabel("¿Más artículos?"));
            JCheckBox masArticulos = new JCheckBox();
            infoArticulos.add(masArticulos);

            infoArticulos.add(new JLabel("¿Artículo esencial?"));
            JCheckBox articuloEsencial = new JCheckBox();
            infoArticulos.add(articuloEsencial);

            JOptionPane.showMessageDialog(null, infoArticulos);

            String nombreProducto = producto.getText();
            double precioProducto = Double.parseDouble(precio.getText());
            cesta.put(nombreProducto, precioProducto);

            if (articuloEsencial.isSelected()) {
                precioIVA = precioProducto + (precioProducto * IVAmin);
                String precioIVAFormateado = dosDecimales.format(precioIVA);
                texto.append("Producto: <" + nombreProducto + ">\n    Precio: <" + precioProducto
                        + ">\n    IVA aplicado [4%]\n    Precio con el IVA: <" + precioIVAFormateado + ">\n\n");
            } else {
                precioIVA = precioProducto + (precioProducto * IVA);
                String precioIVAFormateado = dosDecimales.format(precioIVA);
                texto.append("Producto: <" + nombreProducto + ">\n    Precio: <" + precioProducto
                        + ">>\n    IVA aplicado [21%]\n    Precio con el IVA: <" + precioIVAFormateado + ">\n\n");
            }

            totalCompra += precioIVA;

            if (!masArticulos.isSelected()) {
                continuar = false;
            }
        }

        String laMulta = dosDecimales.format(totalCompra);
        double losBilletes = Double
                .parseDouble(JOptionPane.showInputDialog(null, texto.toString() + "\nTotal a pagar: " + laMulta));
        double cambio = losBilletes - totalCompra;
        String laCalderilla = dosDecimales.format(cambio);
        JOptionPane.showMessageDialog(null,
                "Has pagado el precio de " + laMulta + " con " + losBilletes + "\nTus vueltas son ==> " + laCalderilla);
    }
}