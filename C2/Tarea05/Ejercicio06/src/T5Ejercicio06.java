import javax.swing.JOptionPane;

public class T5Ejercicio06 {
    public static void main(String[] args) {
        Double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el precio del producto"));
        final double IVA = 0.21;

        JOptionPane.showMessageDialog(null, "El precio del producto con el IVA es de: "+(precio+(precio*IVA))+"€");
    }
}
