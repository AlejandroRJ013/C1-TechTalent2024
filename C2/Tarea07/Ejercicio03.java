import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejercicio03 {
    public static void main(String[] args) {
        HashMap<String, HashMap<Double, Integer>> infoArticulos = new HashMap<>();
        HashMap<Double, Integer> precioStock = new HashMap<>();
        precioStock.put(1.25, 50);
        infoArticulos.put("Manzanas", precioStock);
        precioStock.put(2.50, 85);
        infoArticulos.put("Peras", precioStock);
        precioStock.put(1.75, 64);
        infoArticulos.put("Limones", precioStock);
        precioStock.put(5.25, 46);
        infoArticulos.put("Cojines", precioStock);
        precioStock.put(10.25, 250);
        infoArticulos.put("Sabana", precioStock);
        precioStock.put(55.99, 35);
        infoArticulos.put("Termomix", precioStock);
        precioStock.put(14.86, 75);
        infoArticulos.put("Monitor", precioStock);
        precioStock.put(7.20, 120);
        infoArticulos.put("Teclado", precioStock);
        precioStock.put(5.65, 120);
        infoArticulos.put("Ratón", precioStock);
        precioStock.put(75.50, 20);
        infoArticulos.put("Arból para gatos", precioStock);

        JFrame frame = new JFrame("Almacen LIDL");
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

    }
}
