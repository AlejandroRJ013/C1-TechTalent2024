import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class intento {
    public static void main(String[] args) {
        StringBuilder productosTXT = new StringBuilder("");

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
        productoPrecio.put("Leche", 1.5);
        productoPrecio.put("Pan", 1.0);
        productoPrecio.put("Huevos", 2.0);
        productoPrecio.put("Arroz", 1.2);
        productoPrecio.put("Pasta", 1.3);
        productoPrecio.put("Atún en lata", 1.8);
        productoPrecio.put("Aceite de oliva", 3.0);
        productoPrecio.put("Queso", 2.5);
        productoPrecio.put("Yogur", 0.8);
        productoPrecio.put("Frutas y verduras", 30.0);

        ventana(productoStock, productoPrecio, productosTXT);
    }

    public static void ventana(HashMap<String, Integer> productoStock, HashMap<String, Double> productoPrecio,
            StringBuilder productosTXT) {
        JFrame frame = new JFrame("Almacen LIDL");
        frame.setSize(1000, 1000);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints posicion = new GridBagConstraints();

        posicion.gridx = 0;
        posicion.gridy = 0;
        posicion.fill = GridBagConstraints.BOTH;
        JPanel tituloLIDL = new JPanel();
        panelTitulo(tituloLIDL);
        frame.add(tituloLIDL, posicion);

        posicion.gridx = 0;
        posicion.gridy = 1;
        posicion.fill = GridBagConstraints.BOTH;
        JPanel botones = new JPanel();
        panelBotones(botones, productoStock, productoPrecio, productosTXT);
        frame.add(botones, posicion);

        posicion.gridx = 0;
        posicion.gridy = 2;
        posicion.fill = GridBagConstraints.BOTH;
        JPanel productos = new JPanel();
        panelProductos(productoStock, productoPrecio, productos, productosTXT);
        frame.add(productos, posicion);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void panelTitulo(JPanel tituloLIDL) {
        tituloLIDL.setBackground(Color.BLUE);
        JLabel titulArticulos = new JLabel("ARTICULOS LIDL");
        titulArticulos.setFont(new Font("Arial", Font.BOLD, 22));
        titulArticulos.setForeground(Color.YELLOW);
        titulArticulos.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulArticulos.setBorder(new EmptyBorder(5, 10, 5, 10));
        tituloLIDL.add(titulArticulos);
    }

    public static void panelBotones(JPanel botones, HashMap<String, Integer> productoStock,
            HashMap<String, Double> productoPrecio, StringBuilder productosTXT) {
        botones.setLayout(new GridLayout(1, 3));
        botones.setBackground(Color.GRAY);

        JButton cesta = new JButton(escalarImagen("Iconos\\basket.png"));
        modificarBoton(cesta);
        JButton lista = new JButton(escalarImagen("Iconos\\list-task.png"));
        modificarBoton(lista);
        JButton lupa = new JButton(escalarImagen("Iconos\\search.png"));
        modificarBoton(lupa);

        accionesCesta(cesta, productoStock, productoPrecio);
        accionesLista(lista, productosTXT);

        botones.add(cesta);
        botones.add(lista);
        botones.add(lupa);
    }

    public static void panelProductos(HashMap<String, Integer> productoStock, HashMap<String, Double> productoPrecio,
            JPanel productos, StringBuilder productosTXT) {
        productos.setBackground(Color.LIGHT_GRAY);
        productos.setLayout(new BoxLayout(productos, BoxLayout.Y_AXIS));
        productos.setBorder(new EmptyBorder(5, 10, 5, 10));
        int i = 1;
        for (String producto : productoStock.keySet()) {
            double precio = productoPrecio.get(producto);
            int stock = productoStock.get(producto);
            JLabel labelProductos = new JLabel(
                    "Artículo " + i + " >  " + producto + ": " + precio + "€ / " + stock + " unidades en stock");
            labelProductos.setForeground(Color.BLACK);
            productosTXT.append(
                    "Articulo: '" + producto + "'\n\t" + precio + "€(EUROS)\n\t" + stock + " unidades en stock\n");
            productos.add(labelProductos);
            productos.add(Box.createVerticalStrut(5)); // Agregar relleno vertical entre los componentes
            i++;
        }
    }

    public static void modificarBoton(JButton boton) {
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public static ImageIcon escalarImagen(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        ImageIcon imagenEscalada = new ImageIcon(imagen.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        return imagenEscalada;
    }

    public static void accionesLista(JButton lista, StringBuilder productosTXT) {
        lista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(productosTXT.toString());
            }
        });
    }

    public static void accionesCesta(JButton cesta, HashMap<String, Integer> productoStock,
            HashMap<String, Double> productoPrecio) {
        cesta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo producto:",
                        "Producto",
                        JOptionPane.PLAIN_MESSAGE);
                if (productName != null && !productName.isEmpty()) {
                    double precio = Double.parseDouble(
                            JOptionPane.showInputDialog(null, "Ingrese el precio del artículo:", "Precio",
                                    JOptionPane.PLAIN_MESSAGE));
                    int stock = Integer
                            .parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad en stock:", "Stock",
                                    JOptionPane.PLAIN_MESSAGE));
                    productoStock.put(productName, stock);
                    productoPrecio.put(productName, precio);
                }
            }
        });
    }
}
