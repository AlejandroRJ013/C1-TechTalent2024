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
        int multiplicado[] = new int[tam];
    }

    public static void rellenaarray1(int[] array, int tam, StringBuilder coleccion1) {
        for(int i=0; i<tam; i++) {
            int alea = Math.random()*100;
            alea = array[i];
            coleccion1.append(alea+" ");
        }
    }

    public static void rellenaarray2(int tam) {
        int posicion = (int) Math.random()*tam;
        
    }
}
