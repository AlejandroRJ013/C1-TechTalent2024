import javax.swing.JOptionPane;

public class T5Ejercicio12P2 {
    public static void main(String[] args) {
        String contra = "hola";
        String name = JOptionPane.showInputDialog("¿Como te llamas?");
        String validacion = JOptionPane.showInputDialog("Introduzca la: contraseña");
        int cont = 1;

        if (validacion == contra) {
            JOptionPane.showMessageDialog(null, "¡Bienvenido" + name.toUpperCase() + "!" + cont);
        } else {
        }
        if ((validacion != contra) && (cont <= 3)) {
            validacion = JOptionPane.showInputDialog("Contraseña erronea. Intento numero " + cont);
            cont++;
        } else if (cont == 4) {
            JOptionPane.showMessageDialog(null, "Limite de intentos alcanzado.");
        } else {
        }
    }
}

/*
 * 
 * 
 * while (validacion != contra) {
 * validacion =
 * JOptionPane.showInputDialog("Contraseña erronea. Intento numero " + cont);
 * if ((validacion != contra) && (cont <= 3)) {
 * cont++;
 * validacion =
 * JOptionPane.showInputDialog("Contraseña erronea. Intento numero " + cont);
 * } else if (validacion == contra) {
 * JOptionPane.showMessageDialog(null, "¡ENHORABUENA!");
 * } else {
 * JOptionPane.showMessageDialog(null, "Limite de intentos alcanzado.");
 * }
 * }
 * JOptionPane.showMessageDialog(null, "¡ENHORABUENA!");
 * }
 * }
 * 
 * 
 */