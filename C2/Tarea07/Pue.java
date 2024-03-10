import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Pue {
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
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelAcciones = new JPanel();
        panelAcciones.setLayout(new GridLayout(3, 1));
        panelAcciones.setBackground(Color.GRAY);

        buscarProductoBoton(panelAcciones);
        listarProductoBoton(panelAcciones, productosTXT);
        agregarProductoBoton(panelAcciones);

        JPanel dinamico = new JPanel();
        panelDinamico(productoStock, productoPrecio, dinamico, productosTXT);

        frame.add(panelAcciones, BorderLayout.WEST);
        frame.add(dinamico, BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void agregarProductoBoton(JPanel panelAcciones) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(null);

        labelTexto(panel, "¿Agregar articulos?");

        JPanel botonesCarro = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton carritoVacio = new JButton(escalarImagen("Iconos\\basket.png"));

        crearBoton(panel, carritoVacio);

        accionesCarro(carritoVacio);

        panel.add(botonesCarro);

        panelAcciones.add(panel);
    }

    public static void buscarProductoBoton(JPanel panelAcciones) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(null);

        JTextField busqueda = new JTextField();
        busqueda.setPreferredSize(new Dimension(70, 20));
        panel.add(busqueda);

        JPanel botonLupa = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton lupa = new JButton(escalarImagen("Iconos\\search.png"));
        crearBoton(botonLupa, lupa);

        panel.add(botonLupa);

        accionesLupa(lupa, panel);

        panelAcciones.add(panel);
    }

    public static void listarProductoBoton(JPanel panelAcciones, StringBuilder productosTXT) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(null);

        labelTexto(panel, "Listar todos los artículos");

        JPanel botonLista = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton lista = new JButton(escalarImagen("Iconos\\list-task.png"));
        crearBoton(botonLista, lista);

        accionesLista(lista, productosTXT);

        panel.add(botonLista);

        panelAcciones.add(panel);
    }

    public static ImageIcon escalarImagen(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        ImageIcon imagenEscalada = new ImageIcon(imagen.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        return imagenEscalada;
    }

    public static void labelTexto(JPanel panelAcciones, String texto) {
        JLabel agregar = new JLabel(texto);
        agregar.setForeground(Color.BLACK);
        agregar.setAlignmentX(Component.CENTER_ALIGNMENT);
        agregar.setBorder(new EmptyBorder(5, 10, 5, 10));
        panelAcciones.add(agregar);
    }

    public static void crearBoton(JPanel panelBoton, JButton boton) {
        panelBoton.setBackground(null);

        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelBoton.add(boton);
    }

    public static void accionesCarro(JButton carritoVacio, HashMap<String, Integer> productoStock) {
        carritoVacio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = JOptionPane.showInputDialog("Ingrese el nombre del nuevo producto:");
                if (productName != null && !productName.isEmpty()) {
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del artículo:"));
                    int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad en stock:"));
                    productoStock.put(productName, stock);
                    refrescarPanelDinamico();
                }
            }
        });
    }

    public static void accionesLupa(JButton lupa, JPanel panel) {
        lupa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void accionesLista(JButton lista, StringBuilder productosTXT) {
        lista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(productosTXT.toString());
            }
        });
    }

    public static void panelDinamico(HashMap<String, Integer> productoStock, HashMap<String, Double> productoPrecio,
            JPanel dinamico, StringBuilder productosTXT) {
        dinamico.setLayout(new GridBagLayout()); // Cambio del Layout a GridBagLayout
        dinamico.setBackground(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;

        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(Color.BLUE);
        JLabel titulArticulos = new JLabel("ARTICULOS LIDL");
        titulArticulos.setFont(new Font("Arial", Font.BOLD, 22));
        titulArticulos.setForeground(Color.YELLOW);
        titulArticulos.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulArticulos.setBorder(new EmptyBorder(5, 10, 5, 10));
        panelSuperior.add(titulArticulos);
        dinamico.add(panelSuperior, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;

        JPanel panelInferior = new JPanel();
        labelProductos(productoStock, productoPrecio, panelInferior, productosTXT);

        dinamico.add(panelInferior, gbc);
    }

    public static void labelProductos(HashMap<String, Integer> productoStock, HashMap<String, Double> productoPrecio,
            JPanel panelInferior, StringBuilder productosTXT) {
        panelInferior.setBackground(Color.LIGHT_GRAY);
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
        panelInferior.setBorder(new EmptyBorder(5, 10, 5, 10));
        int i = 1;
        for (String producto : productoStock.keySet()) {
            double precio = productoPrecio.get(producto);
            int stock = productoStock.get(producto);
            JLabel labelProductos = new JLabel(
                    "Artículo " + i + " >  " + producto + ": " + precio + "€ / " + stock + " unidades en stock");
            labelProductos.setForeground(Color.BLACK);
            productosTXT.append(
                    "Articulo: '" + producto + "'\n\t" + precio + "€(EUROS)\n\t" + stock + " unidades en stock\n");
            panelInferior.add(labelProductos);
            panelInferior.add(Box.createVerticalStrut(5)); // Agregar relleno vertical entre los componentes
            i++;
        }
    }

    public static void refrescarPanelDinamico(JPanel dinamico) {
        dinamico.removeAll();
        labelProductos(null, null, dinamico, null);
    }
}