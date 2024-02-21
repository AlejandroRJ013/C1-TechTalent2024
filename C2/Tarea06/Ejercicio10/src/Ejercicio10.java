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

            while (!primo(mates) || repes(col, mates)) {
                mates = (int) (Math.random() * max);
            }
            if (primo(mates)) {
                col[i] = mates;
                losprimos.append(mates + " ");
                i++;
            }
        }
        JOptionPane.showMessageDialog(null, "Estos son los numeros primos generados: \n - - " + losprimos + " - - \n");
    }

    public static void elmayor(String primos, int tama) {
        String[] nums = primos.split(" ");
        int[] numeros = new int[tama];
        int elgrande = 0;
        for (int i = 0; i < tama; i++) {
            int intnum = Integer.parseInt(nums[i]);
            numeros[i] = intnum;
            if (elgrande < numeros[i]) {
                elgrande = numeros[i];
            }
        }
        JOptionPane.showMessageDialog(null, "Y entre ellos el mayor és: " + elgrande);
    }

    public static boolean repes(int[] valor, int aleatorio) {
        for (int preguntorepe : valor) {
            if (preguntorepe == aleatorio) {
                return true;
            }
        }
        return false;
    }
}
