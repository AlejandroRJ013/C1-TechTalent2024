import javax.swing.JOptionPane;

public class Ejercicio09 {
    public static void main (String[] args) {
        String tamano = JOptionPane.showInputDialog("Cantidad de numeros aleatorios generado:");
        while (tamano.equals("")) {
            tamano = JOptionPane.showInputDialog("Ingrese algun número por favor:");
        }
        int tamaño = Integer.parseInt(tamano);
        int numaleatorios[] = new int[tamaño];
        rellenar(numaleatorios, tamaño);
        StringBuilder numesp = new StringBuilder("");
        tusnums(numaleatorios, numesp, tamaño);

    }

    public static void rellenar(int numeros[], int tam) {
        int i= 0;
        while (i<tam) {
            int mats = (int) (Math.random() * 10);
            if (mats == 0) {
                mats = (int) (Math.random() * 10);
            } else {
                numeros[i] = mats;
                i++;
            }
        }       
    }

    public static void tusnums(int numeros[], StringBuilder numers, int tam) {
        String todosnums = "";
        for (int i = 0; i < tam; i++) {
            int tusnume = numeros[i];
            numers.append(tusnume).append(" ");
            
            todosnums = numers.toString();
            String aleatorios[] = todosnums.split(" ");
            numers.append("Tu número aleatorio ").append(i+1).append(" es : "+aleatorios[i]+"\n");
            JOptionPane.showMessageDialog(null, numers);
        }
    }
}
