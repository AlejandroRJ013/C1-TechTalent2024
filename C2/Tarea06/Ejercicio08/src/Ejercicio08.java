import javax.swing.JOptionPane;

public class Ejercicio08 {
    public static void main(String[] args) {
        int coleccion[] = new int[10];
        StringBuilder todosnum = new StringBuilder(" - - COLECCIÓN DE NÚMEROS - - \n");
        rellenar(coleccion);
        JOptionPane.showMessageDialog(null, imprimir(coleccion, todosnum).toString());
    }

    public static void rellenar(int valor[]) {
        for (int i=0; i<10; i++) {
            String num = JOptionPane.showInputDialog("Cual será el valor asiganado en la posición "+(i+1)+":");
            valor[i] = Integer.parseInt(num);
        }
    }

    public static StringBuilder imprimir(int colec[], StringBuilder todosnum) {
        int i = 0;
        for (int junto : colec) {
            todosnum.append("Indice ["+i+"]: "+junto).append(" \n");
            i++;
        }
        return todosnum;
    }
}