import java.util.HashMap;
import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class Ejercicio02 {
    public static void main(String[] args) {
        HashMap<String, Double> cesta = new HashMap<>();
        int cantArticulos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos articulos quiere comprar?"));
        StringBuilder texto = new StringBuilder("PRECIO DE LOS ARTICULOS\n\n");
        final double IVA = 0.21;
        DecimalFormat formato = new DecimalFormat("#.##");
        double suma = 0;


        for (int i = 0; i<cantArticulos; i++) {
            JPanel panel = new JPanel(new GridLayout(0, 2)); // GridLayout para organizar los campos de texto en dos columnas
            
                panel.add(new JLabel("Nombre del producto: "));
                JTextField producto = new JTextField(10);
                panel.add(producto);

                panel.add(new JLabel("Precio:"));
                JTextField precio = new JTextField(10);
                panel.add(precio);

                int result = JOptionPane.showConfirmDialog(null, panel, "Introduzca información del producto", JOptionPane.OK_CANCEL_OPTION); //OK = 0, CANCEL = 2, CLOSE = -1
                
            if (result == JOptionPane.OK_OPTION) {
                String nombreProducto = producto.getText();
                double precioProductoDecimales = Double.parseDouble(precio.getText());
                String precioProducto = formato.format(precioProductoDecimales);

                cesta.put(nombreProducto, precioProducto);
                double precioIVADecimales = (precioProductoDecimales+(precioProductoDecimales*IVA));
                String precioIVA = formato.format(precioProductoDecimales);

                texto.append("El articulo <"+ nombreProducto+"> con un precio bruto de "+precioProducto+" con el IVA sale "+precioIVA+"\n");

                // sumaDecimales += precioIVADecimales;
                // String suma = formato.format(sumaDecimales);
            } else {
                System.out.println("¡ ¡ OPERACIÓN CANCELADA ! !");
            }
        }
        double dinero = Double.parseDouble(JOptionPane.showInputDialog(null, texto.toString()+"\nEl IVA aplicado a todos los articulos de del 21%\nEn total has comprado ==> "+cantArticulos+" artículos\n\nCon un precio total de ==> "+suma+"€ ¿Con que va ha pagar?"));
        double vueltos = dinero-suma;
        JOptionPane.showMessageDialog(null, "Has pagado el precio total de "+suma+" con "+dinero+"\nTus vueltas son ==> "+vueltos);
    }
}