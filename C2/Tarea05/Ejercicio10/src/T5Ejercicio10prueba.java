import java.beans.IntrospectionException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class T5Ejercicio10prueba {
    public static void main(String[] args) {
        String articulos = JOptionPane.showInputDialog("Introduce el número de articulos: ");
        double sumventas = 0.0;
        int art = Integer.parseInt(articulos);
        JPanel panel = new JPanel();

            for (int i = 1; i <= art; i++) {
            JTextField pre = new JTextField(10);
            panel.add(new JLabel("Articulo " + i + ":"));
            panel.add(pre);
            
            int pan = JOptionPane.showConfirmDialog(null, panel,
            "Introduce el precio del artículo :",
            JOptionPane.OK_CANCEL_OPTION);
                if (pan == JOptionPane.OK_OPTION) {
                String preci = pre.getText().replace(",", ".");
                double precio = Double.parseDouble(preci);
                sumventas += precio;
                }
            }
            JOptionPane.showMessageDialog(null, sumventas);
    }
}

/*
        int i = 1;
        if (i <= art) {
            JTextField pre = new JTextField(10);
            panel.add(new JLabel("Articulo " + i + ":"));
            panel.add(pre);
            i++;
        } else if (i > art) {
            int pan = JOptionPane.showConfirmDialog(null, panel, "Introduce el precio del artículo :",
                    JOptionPane.OK_CANCEL_OPTION);
            if (pan == JOptionPane.OK_OPTION) {
                String preci = pre.getText().replace(",", ".");
                double precio = Double.parseDouble(preci);
                sumventas += precio;
            } else {
            }
             */