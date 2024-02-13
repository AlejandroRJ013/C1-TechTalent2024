import javax.swing.JOptionPane;

public class EjerExtra3 {
    public static void main(String[] args) {
        String numero = JOptionPane.showInputDialog(null, "Introduzca el número:");
        int num = Integer.parseInt(numero);
        int resultado = num;

        for (int suma = (num - 1); suma > 0; suma--) {
            resultado += suma;
            System.out.println(num + "+" + suma + " = " + resultado);
        }

        JOptionPane.showMessageDialog(null, "La suma de los números precedentes al ingresado es: " + resultado);
    }
}