import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ProductManagerGUI extends JFrame {

    private HashMap<String, Integer> products;

    public ProductManagerGUI() {
        super("Product Manager");

        // Initialize products
        products = new HashMap<>();
        products.put("Leche", 100);
        products.put("Pan", 150);
        products.put("Huevos", 200);
        products.put("Arroz", 80);
        products.put("Pasta", 120);
        products.put("Atún en lata", 90);
        products.put("Aceite de oliva", 110);
        products.put("Queso", 70);
        products.put("Yogur", 120);
        products.put("Frutas y verduras", 200);

        // Set up the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(new BorderLayout());

        // Create and add components
        JPanel productListPanel = createProductListPanel();
        add(productListPanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createProductListPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Lista de Productos");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel);

        // Add each product to the panel
        for (String productName : products.keySet()) {
            JLabel productLabel = new JLabel(productName + ": " + products.get(productName));
            panel.add(productLabel);
        }

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton addButton = new JButton("Añadir Producto");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = JOptionPane.showInputDialog("Ingrese el nombre del nuevo producto:");
                if (productName != null && !productName.isEmpty()) {
                    int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad en stock:"));
                    products.put(productName, stock);
                    refreshProductList();
                }
            }
        });

        JButton searchButton = new JButton("Buscar Producto");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchProduct = JOptionPane.showInputDialog("Ingrese el nombre del producto a buscar:");
                if (searchProduct != null && !searchProduct.isEmpty()) {
                    Integer stock = products.get(searchProduct);
                    if (stock != null) {
                        JOptionPane.showMessageDialog(null, "El stock de " + searchProduct + " es " + stock);
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado: " + searchProduct);
                    }
                }
            }
        });

        panel.add(addButton);
        panel.add(searchButton);

        return panel;
    }

    private void refreshProductList() {
        getContentPane().removeAll(); // Remove all components from the frame
        JPanel productListPanel = createProductListPanel();
        add(productListPanel, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        revalidate(); // Revalidate the frame to reflect changes
        repaint(); // Repaint the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductManagerGUI().setVisible(true);
            }
        });
    }
}
