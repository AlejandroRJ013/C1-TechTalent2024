import java.util.HashMap;

import javax.swing.*;

public class Ejercicio04 {
    public static void main(String[] args) {
        /*
         * Hacer la interfaz del ejercicio 3 pero poner un checkbox a cada producto,
         * añadir un boton a la barra de botones {lo que hara este boton es que cuando
         * se pulse recogera todos los checkbox seleccionados, preguntara la cantidad
         * que se va a comprar de un producto(luego otro, y el siguiente, etc.), la
         * cantidad comprada se multiplica por el precio del producto y se resta
         * la cantidad que se a comprado del stock que habia del producto}
         */

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
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        String[] productos = new String[productoStock.size()];
        int i = 0;
        for (String producto : productoStock.keySet()) {
            productos[i] = producto;
            i++;
        }
        JComboBox<String> prueba = new JComboBox<>(productos);
        prueba.setSize(100, 30);
        
        panel.add(prueba);
        frame.add(panel);
        frame.setVisible(true);
    }
}
