import javax.swing.JOptionPane;

public class Ejercicio06 {
    public static void main(String[] args) {
        String numero = JOptionPane.showInputDialog("Ingrese un numero para saber su numero de cifras");
        String sinletras = numero.replaceAll("[\\D]", "");
        while (haynumero(sinletras) == false) {
            numero = JOptionPane.showInputDialog(null, "Ingrese un número diferente a 0");
            sinletras = numero.replaceAll("[\\D]", "");
        }
        JOptionPane.showMessageDialog(null, "El numero <" + numero + "> contiene " + (sinletras.length()) + " dígitos");
    }

    public static boolean haynumero(String num) {
        int numero = Integer.parseInt(num);
        if (numero == 0) {
            return false;
        } else {
            return true;
        }
    }
}