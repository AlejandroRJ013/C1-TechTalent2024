import javax.swing.JOptionPane;

public class T5Ejercicio12 {
    public static void main(String[] args) {
        String respuesta;
        String nombre = JOptionPane.showInputDialog("¿Como te llamas?");
        String contraseña = "contraseña";
        String name = nombre.toUpperCase();
        int cont = 1;
        respuesta = JOptionPane.showInputDialog("Instroduzca: contraseña");

        while ((!respuesta.equals(contraseña)) && (cont <= 3)) {
            respuesta = JOptionPane.showInputDialog("Contraseña erronea. Intento numero " + cont);
            if (respuesta.equals(contraseña)) {
                JOptionPane.showMessageDialog(null, "¡Bienvenido " + name + "!");
                cont = 10;
            } else {
                cont++;
            }
        }
        if (cont == 4) {
            JOptionPane.showMessageDialog(null, "¡" + name + "! Limite de intentos alcanzado.");
        } else if (cont != 10) {
            JOptionPane.showMessageDialog(null, "¡Bienvenido " + name + "!");
        } else {
        }
    }
}