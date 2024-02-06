import javax.swing.JOptionPane;

public class T5Ejercicio04 {
    public static void main(String[] args) {
        String radio=JOptionPane.showInputDialog("Introduzca el radio del circulo");
        final double PI=(3.14);
        double rad=Double.parseDouble(radio);
        JOptionPane.showMessageDialog(null, "El área del círculo con radio "+rad+" es de: "+(PI*(Math.pow(rad, 2)))+"\n "
        		+ PI+" * "+rad+"^2 = "+(PI*(Math.pow(rad, 2))));
    }
}
