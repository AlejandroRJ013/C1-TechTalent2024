import javax.swing.JOptionPane;

public class T5Ejercicio01prueba {

    public static void main(String[] args) {

        String valor11 = JOptionPane.showInputDialog("Elige tu primer numero");
        String valor21 = JOptionPane.showInputDialog("Elige tu segundo numero");

        int val1 = Integer.parseInt(valor11), val2 = Integer.parseInt(valor21);

        if (val11 > val21) {
            System.out.println("La variable val1: " + val1 + " es mayor que val2: " + val2);
        } else if (val1 == val2) {
            System.out.println("las dos números tienen el mismo valor");
        } else {
            System.out.println("La variable val2: " + val2 + " es mayor que val1: " + val1);
        }

    }
}