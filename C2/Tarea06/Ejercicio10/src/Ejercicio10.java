import javax.swing.JOptionPane;

public class Ejercicio10 {
    public static void main(String[] args) {
        String numtxt = JOptionPane.showInputDialog("Ingrese la cantidad de numeros primos que quiere generar: ");
        int tamaño = Integer.parseInt(numtxt);
        int numeros[] = new int[tamaño];
        StringBuilder numerosprim = new StringBuilder("");
        rellenar(numeros, tamaño, numerosprim);
        String losprimos = numerosprim.toString();
        elmayor(losprimos, tamaño);
    }

    public static boolean primo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int divisor = (num - 1); divisor >= 2; divisor--) {
            if (num % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static void rellenar(int col[], int tam, StringBuilder losprimos) {
        int i = 0;
        while (i < tam) {
            String destxt = JOptionPane.showInputDialog("Valor máximo para el intervalo de numeros aleatorio: ");
            int max = Integer.parseInt(destxt);
            int mates = (int) (Math.random() * max);
            String mat = String.valueOf(mates), loprimo = losprimos.toString();
            while (!primo(mates) && !mat.equals(loprimo)) {
                mates = (int) (Math.random() * max);
                mat = String.valueOf(mates);
            } // da primos repetidos
            if (primo(mates)) {
                col[i] = mates;
                losprimos.append(mates + " ");
                i++;
            }
        }
        JOptionPane.showMessageDialog(null, "Estos son los numeros primos generados: \n - - " + losprimos + " - - ");
    }

    public static void elmayor(String primos, int tama) {
        String[] nums = primos.split(" ");
        int[] numero = new int[tama];
        int grande = 0;
        for (int i = 0; i < tama; i++) {
            numero[i] = Integer.parseInt(nums[1]);
        }
        for (int i = 0; i < tama; i++) {
            if (grande < numero[i]) {
                grande = numero[i];
            }
        }
        JOptionPane.showMessageDialog(null, "Y entre ellos el número primo más grande és: " + grande);
    }
}
