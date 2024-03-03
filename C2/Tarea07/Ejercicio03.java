import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejercicio03 {
    public static void main(String[] args) {
        HashMap<String, HashMap<Double, Integer>> infoArticulos = new HashMap<>();
        HashMap<Double, Integer> stockPrecio = new HashMap<>();
        stockPrecio.put(1.25, 50);
        infoArticulos.put("Manzanas", stockPrecio);
        stockPrecio.put(2.50, 85);
        infoArticulos.put("Peras", stockPrecio);
        stockPrecio.put(1.75, 64);
        infoArticulos.put("Limones", stockPrecio);
        stockPrecio.put(5.25, 46);
        infoArticulos.put("Cojines", stockPrecio);
        stockPrecio.put(10.25, 250);
        infoArticulos.put("Sabana", stockPrecio);
        stockPrecio.put(55.99, 35);
        infoArticulos.put("Termomix", stockPrecio);
        stockPrecio.put(14.86, 75);
        infoArticulos.put("Monitor", stockPrecio);
        stockPrecio.put(7.20, 120);
        infoArticulos.put("Teclado", stockPrecio);
        stockPrecio.put(5.65, 120);
        infoArticulos.put("Ratón", stockPrecio);
        stockPrecio.put(75.50, 20);
        infoArticulos.put("Arból para gatos", stockPrecio);

        JFrame frame = new JFrame("Almacen LIDL");
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

    }
}
