import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Ejercicio03 {
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

        ventana(productoStock, productoPrecio, productosTXT);
    }

    public static void ventana(HashMap<String, Integer> productoStock, HashMap<String, Double> productoPrecio,
            StringBuilder productosTXT) {
        JFrame frame = new JFrame("Almacen LIDL");
        frame.setSize(1000, 1000);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints posicion = new GridBagConstraints();
        posicion.fill = GridBagConstraints.BOTH; // Rellenar vertical y horizontalmente
        posicion.weightx = 1; // Permitir que los componentes se expandan horizontalmente
        posicion.weighty = 1; // Permitir que los componentes se expandan verticalmente

        JPanel tituloLIDL = new JPanel();
        JPanel botones = new JPanel();
        JPanel productos = new JPanel();

        panelTitulo(tituloLIDL);
        panelBotones(frame, botones, productos, productoStock, productoPrecio, productosTXT);
        panelProductos(productoStock, productoPrecio, productos, productosTXT);

        posicion.gridy = 0;
        panelPrincipal.add(tituloLIDL, posicion);

        posicion.gridy = 1;
        panelPrincipal.add(botones, posicion);

        posicion.gridy = 2;
        panelPrincipal.add(productos, posicion);

        frame.add(panelPrincipal, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void panelTitulo(JPanel tituloLIDL) {
        tituloLIDL.setBackground(Color.BLUE);
        JLabel titulArticulos = new JLabel("ARTICULOS LIDL");
        titulArticulos.setFont(new Font("Arial", Font.BOLD, 35));
        titulArticulos.setForeground(Color.YELLOW);
        titulArticulos.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulArticulos.setBorder(new EmptyBorder(5, 10, 5, 10));
        tituloLIDL.add(titulArticulos);
    }

    public static void panelProductos(HashMap<String, Integer> productoStock, HashMap<String, Double> productoPrecio,
            JPanel productos, StringBuilder productosTXT) {
        productos.setBackground(Color.LIGHT_GRAY);
        productos.setLayout(new BoxLayout(productos, BoxLayout.Y_AXIS));
        productos.setBorder(new EmptyBorder(5, 10, 7, 10));
        DecimalFormat decimales = new DecimalFormat("0.00");
        int i = 1;
        for (String producto : productoStock.keySet()) {
            double precio = productoPrecio.get(producto);
            String precioFormateado = decimales.format(precio);
            int stock = productoStock.get(producto);
            JLabel labelProductos = new JLabel(
                    "Artículo " + i + " >  " + producto + ": " + precioFormateado + "€ / " + stock
                            + " unidades en stock");
            labelProductos.setForeground(Color.BLACK);
            productosTXT.append(
                    "Articulo: '" + producto + "'\n\t" + precioFormateado + "€(EUROS)\n\t" + stock
                            + " unidades en stock\n");
            productos.add(labelProductos);
            productos.add(Box.createVerticalStrut(5)); // Agregar relleno vertical entre los componentes
            i++;
        }
    }

    public static void panelBotones(JFrame frame, JPanel botones, JPanel productos,
            HashMap<String, Integer> productoStock,
            HashMap<String, Double> productoPrecio, StringBuilder productosTXT) {
        botones.setLayout(new GridLayout(1, 3));
        botones.setBackground(Color.GRAY);

        JButton cesta = new JButton(escalarImagen("Iconos\\cart-plus.png"));
        modificarBoton(cesta);
        JButton lista = new JButton(escalarImagen("Iconos\\list-task.png"));
        modificarBoton(lista);
        JButton lupa = new JButton(escalarImagen("Iconos\\search.png"));
        modificarBoton(lupa);

        accionesCesta(frame, cesta, productos, productosTXT, productoStock, productoPrecio);
        accionesLista(lista, productosTXT);
        accionesLupa(lupa, productoPrecio);

        botones.add(cesta);
        botones.add(lista);
        botones.add(lupa);
    }

    public static void modificarBoton(JButton boton) {
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public static ImageIcon escalarImagen(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        ImageIcon imagenEscalada = new ImageIcon(imagen.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
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

    public static void accionesCesta(JFrame frame, JButton cesta, JPanel productos, StringBuilder productosTXT,
            HashMap<String, Integer> productoStock,
            HashMap<String, Double> productoPrecio) {
        cesta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = JOptionPane.showInputDialog(null, "Ingrese el nombre del nuevo producto:",
                        "Producto", JOptionPane.PLAIN_MESSAGE);
                if (productName != null && !productName.isEmpty()) {
                    double precio = Double
                            .parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio del artículo:",
                                    "Precio", JOptionPane.PLAIN_MESSAGE));
                    int stock = Integer
                            .parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad en stock:", "Stock",
                                    JOptionPane.PLAIN_MESSAGE));
                    productoStock.put(productName, stock);
                    productoPrecio.put(productName, precio);

                    actualizarProductos(frame, productoStock, productoPrecio, productos, productosTXT);
                }
            }
        });
    }

    public static void accionesLupa(JButton lupa, HashMap<String, Double> productoPrecio) {
        lupa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DecimalFormat decimales = new DecimalFormat("0.00");
                String productoBuscado = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto a buscar:",
                        null, JOptionPane.PLAIN_MESSAGE);
                if (productoBuscado != null && !productoBuscado.isEmpty()) {
                    StringBuilder productosCoicidentes = new StringBuilder();
                    for (String producto : productoPrecio.keySet()) {
                        if (producto.toLowerCase().contains(productoBuscado.toLowerCase())) {
                            double precio = productoPrecio.get(producto);
                            String precioFormateado = decimales.format(precio);
                            productosCoicidentes
                                    .append("\t" + producto + " > " + precioFormateado + "€/u.\n");
                        }
                    }
                    if (productosCoicidentes.length() > 0) {
                        JOptionPane.showMessageDialog(null, "Productos encontrados:\n" + productosCoicidentes);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "No se encontraron productos que coincidan con: '" + productoBuscado + "'");
                    }
                }
            }
        });
    }

    public static void actualizarProductos(JFrame frame, HashMap<String, Integer> productoStock,
            HashMap<String, Double> productoPrecio, JPanel productos, StringBuilder productosTXT) {

        frame.setVisible(false);
        frame.setSize(1000, 1000);
        productos.removeAll();
        DecimalFormat decimales = new DecimalFormat("0.00");
        int i = 1;
        for (String producto : productoStock.keySet()) {
            if (i <= 20) {
                double precio = productoPrecio.get(producto);
                String precioFormateado = decimales.format(precio);
                int stock = productoStock.get(producto);
                JLabel labelProductos = new JLabel(
                        "Artículo " + i + " >  " + producto + ": " + precioFormateado + "€ / " + stock
                                + " unidades en stock");
                labelProductos.setForeground(Color.BLACK);
                productosTXT.append(
                        "Articulo: '" + producto + "'\n\t" + precioFormateado + "€(EUROS)\n\t" + stock
                                + " unidades en stock\n");
                productos.add(labelProductos);
                productos.add(Box.createVerticalStrut(5));
                i++;
            } else {
                JOptionPane.showMessageDialog(null, "Has llegado al máximo de artículos posible");
            }
        }
        productos.revalidate();
        productos.repaint();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}