import javax.swing.JOptionPane;

public class Ejercicio06 {
    public static void main(String[] args) {
        String numero = JOptionPane.showInputDialog("Ingrese un numero para saber su numero de cifras");
        String sinletras = numero.replaceAll("[\\D]", "");
        if (conteocifras(sinletras) == false) {
            JOptionPane.showMessageDialog(null, "Ingrese un número superior a 0");
        } else {
            JOptionPane.showMessageDialog(null,
                    "El numero " + sinletras + " contiene " + (sinletras.length()) + " dígitos");
        }
    }

    public static boolean conteocifras(String num) {
        int numero = Integer.parseInt(num);
        if (numero <= 0) {
            return false;
        } else {
            return true;
        }
    }
}