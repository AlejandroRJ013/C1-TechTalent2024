import javax.swing.JOptionPane;

public class Ejercicio09 {
    public static void main (String[] args) {
        String tamano = JOptionPane.showInputDialog("Cantidad de numeros aleatorios geerado:");
        int tamaño = Integer.parseInt(tamano);
        int numaleatorios[] = new int[tamaño];
        rellenar(numaleatorios, tamaño);

    }

    public static void rellenar(int numeros[], int tam) {
        for (int i=0; i<tam; i++) {
            String intervalo1 = JOptionPane.showInputDialog("Se generará un número mayor al número ingresado: ");
            String intervalo2 = JOptionPane.showInputDialog("Y uno menor al siguiente número ingresado: ");
            int inter1 = Integer.parseInt(intervalo1);
            int inter2 = Integer.parseInt(intervalo2);
            numeros[i] = inter1 + (Math.random() * (inter2 - inter1)); //operación matematica ayudada por el colega chagpt
        }
    }

    public static int sumanumeros(int numes[], int tama) {
        int sumar = 0;
        for (int e=0; e<tama; e++) {
            sumar += numes[e];
        }
        return sumar;
    }

    public static String nums(int randoms[]) {
        StringBuilder numesp = new StringBuilder(" - - ESTOS SON TUS NÚMEROS ALEATORIOS - - \n");
        for (int numers : randoms) {
            numesp.append(numers).append(" ");
        }
        return numesp;
    }
}
