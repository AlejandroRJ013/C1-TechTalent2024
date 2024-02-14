import javax.swing.JOptionPane;

public class Ejercicio05 {
    public static void main(String[] args) {
        String decima = JOptionPane.showInputDialog("Ingresa un numero para conocerlo en base binaria");
        int decimal = Integer.parseInt(decima);
        System.out.println("El numero "+decimal+" en base binaria es:");
        int binario[] = rellenarbin(decimal);
        escribirbin(binario);
    }

    public static int[] rellenarbin(int numero) {
        int restos[] = new int[numero];
        for (int i = 0; i < restos.length; i++) {
            restos[i] = numero % 2;
            numero /= 2;
        }
        return restos;
    }

    public static int[] escribirbin(int list[]) {
        for (int i = (list.length - 1); i >= 0; i--) {
            System.out.print(list[i]+" ");
        }
        return list;
    }
}