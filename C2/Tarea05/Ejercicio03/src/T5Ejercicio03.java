import javax.swing.JOptionPane;

public class T5Ejercicio03 {
    public static void main(String[] args) {
        
        String name=JOptionPane.showInputDialog("Introduzca su nombre:");
        JOptionPane.showMessageDialog(null, "Bienvenido "+name.toUpperCase()+", esperamos verle por aqui");
    }
}
