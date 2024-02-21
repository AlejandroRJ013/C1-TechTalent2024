import javax.swing.JOptionPane;

public class Ejercicio11 {
    public static void main(String[] args) {
        String tamaño = JOptionPane.showInputDialog("¿Cual será el tamaño del array?");
        int tam = Integer.parseInt(tamaño);
        
        StringBuilder coleccion1 = new StringBuilder();
        StringBuilder coleccion2 = new StringBuilder();
        StringBuilder coleccion3 = new StringBuilder();
        int array[] = new int[tam];
        int aleatorio[] = new int[tam];
        int multiplicado[] = new int[tam];

        rellenararray1(array, tam, coleccion1);
        rellenararray2(array, aleatorio, tam, coleccion2);
        rellenararray3(array, aleatorio, multiplicado, tam, coleccion3);
        
        JOptionPane.showMessageDialog(null, "La primera colección contiene: \n - "+coleccion1+" \n La segunda colección contiene: \n - "+coleccion2+" \n Y las multiplicaciones dan: \n - "+coleccion3);
    }

    public static void rellenararray1(int[] array, int tam, StringBuilder coleccion1) {
        for(int i=0; i<tam; i++) {
            int alea = (int) Math.random()*50;
            array[1] = alea;
            coleccion1.append(alea+" ");
        }
    }

    public static void rellenararray2(int[] array, int[] aleatorio, int tam, StringBuilder coleccion2) {
        int posicionale = (int) Math.random()*tam;
        
        for (int i = 0; i < tam; i++) {
            if (repes(aleatorio, posicionale)) {
                posicionale = (int) Math.random()*tam;
            }
            aleatorio[i] = array[posicionale];
            coleccion2.append(aleatorio[i]+" ");
        }
    }

    public static boolean repes(int[] valor, int aleatorio) {
        for (int preguntorepe : valor) {
            if (preguntorepe == aleatorio) {
                return true;
            }
        }
        return false;
    }

    public static void rellenararray3(int[] array, int[] aleatorio, int[] multiplicado, int tam, StringBuilder coleccion3) {
        for (int i = 0; i < tam; i++) {
            multiplicado[i] = array[i]*aleatorio[i];
            coleccion3.append(multiplicado[i]+" ");
        }
    }
}