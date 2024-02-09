import javax.swing.JOptionPane;

public class EjerExtra4 {
    public static void main(String[] args) {
        String numero = JOptionPane.showInputDialog(null, "Introduzca el número:");
        int num = Integer.parseInt(numero);
        int primos = 0;
        int solucion = 0;
        int recursivo = (num-1);

        for (recursivo = (num-1); ((recursivo > 1) && (solucion != 0)); recursivo--) {
            solucion = Math.floorDiv(num, recursivo);
        }
        if (solucion != 0) {
            primos = num;
            JOptionPane.showMessageDialog(null, "El numero introducicio: "+num+" es un numero primo"+primos+"\n"+solucion);
        } else if (solucion == 0) {
            JOptionPane.showMessageDialog(null, "El numero introducicio: "+num+" no es un numero primo");
        } else {
            JOptionPane.showMessageDialog(null, "El numero introducicio: "+num+" no es un numero primo");
        }
    }
}