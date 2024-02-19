import javax.swing.JOptionPane;

public class Ejercicio11 {
    public static void main(String[] args) {
        String tamaño = JOptionPane.showInputDialog("¿Cual será el tamaño de los arrays?");
        int tam = Integer.parseInt(tamaño);
        
        StringBuilder coleccion1 = new StringBuilder();
        StringBuilder coleccion2 = new StringBuilder();
        StringBuilder coleccion3 = new StringBuilder();
        int array[] = new int[tam];
        int aleatorio[] = new int[tam];
        int numsgen[] = new int[tam];
        int multiplicado[] = new int[tam];
        int posicionale = (int) Math.random()*tam;

        rellenararray1(array, tam, coleccion1);
        rellenararray2(array, aleatorio, posicionale, tam, numsgen);
        rellenararray3(array, aleatorio, multiplicado, tam);

        mostrar(coleccion1, coleccion2, coleccion3, array, aleatorio, multiplicado);
    }

    public static void rellenararray1(int[] array, int tam, StringBuilder coleccion1) {
        for(int i=0; i<tam; i++) {
            int alea = (int) Math.random()*100;
            alea = array[i];
            coleccion1.append(alea+" ");
        }
    }

    public static void rellenararray2(int[] array, int[] aleatorio, int posicionale, int tam, int[] numsgen) {
        for (int i = 0; i < tam; i++) {
            for (int esta : numsgen) {
                while (posicionale == esta) {
                    posicionale = (int) Math.random()*tam;
                }
            }
            numsgen[i] = posicionale;
            aleatorio[i] = array[posicionale];
        }
    }

    public static void rellenararray3(int[] array, int[] aleatorio, int[] multiplicado, int tam) {
        for (int i = 0; i < tam; i++) {
            multiplicado[i] = array[i]*aleatorio[i];
        }
    }
    
    public static void mostrar(StringBuilder coleccion1, StringBuilder coleccion2, StringBuilder coleccion3, int[] array, int[] aleatorio, int[] multiplicado) {
        for (int num : array) {
            coleccion1.append(num+" ");
        }
        String arraystr = coleccion1.toString();
        for (int numale : aleatorio) {
            coleccion2.append(numale+" ");
        }
        String aleatoriostr = coleccion1.toString();
        for (int mul : multiplicado) {
            coleccion3.append(mul+" ");
        }
        String multiplicadostr = coleccion1.toString();

        JOptionPane.showMessageDialog(null, "La primera colección contiene: \n - "+arraystr+" \n La segunda colección contiene: \n - "+aleatoriostr+" \n Y las multiplicaciones dan: \n - "+multiplicadostr);
    }
}
