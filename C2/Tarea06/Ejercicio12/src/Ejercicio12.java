import javax.swing.JOptionPane;

public class Ejercicio12 {
    public static void main(String[] args) {
        String tamaño = JOptionPane.showInputDialog("Ingrese la cantidad de numeros que se generará");
        int tam = Integer.parseInt(tamaño);
        int col[] = new int[tam];
        StringBuilder tusnumeros = new StringBuilder("");

        rellenar(tam, col, tusnumeros);

        String sospecharde = JOptionPane.showInputDialog("Indique el número que se buscará");
        int sospechoso = Integer.parseInt(sospecharde);
        int sos[] = new int[tam];
        StringBuilder sospechosos = new StringBuilder("");
        StringBuilder bonitos = new StringBuilder("");

        detective(sospechoso, col, sos);

        boolean nohaypapeles = false;
        for (int numero : sos) {
            if (numero != 0) {
                nohaypapeles = true;
                break;
            }
        }
        if (nohaypapeles) {

            mostrar(sos, sospechosos, bonitos, sospechoso);

        } else {
            JOptionPane.showMessageDialog(null,
                    "No hay números que terminen en " + sospechoso + "\n Tus números generados:\n" + tusnumeros);
        }
    }

    public static void rellenar(int tam, int[] col, StringBuilder tusnumeros) {
        for (int i = 0; i < tam; i++) {
            int aleatorio = (int) ((Math.random() * 300) + 1);
            col[i] = aleatorio;
            tusnumeros.append(aleatorio + " ");
        }
    }

    public static void mostrar(int[] sos, StringBuilder sospechosos, StringBuilder bonitos, int sospechoso) {
        for (int numero : sos) {
            if (numero != 0) {
                sospechosos.append(numero + " ");
            }
        }
        // Separarlo con comas hasta el último.

        String strsos = sospechosos.toString();
        String ponercomas[] = strsos.split(" ");
        for (int i = 0; i < ponercomas.length; i++) {
            if (i < (ponercomas.length - 1)) {
                bonitos.append(ponercomas[i] + ", ");
            } else {
                bonitos.append(ponercomas[i] + " ");
            }
        }
        JOptionPane.showMessageDialog(null,
                "Los numeros encontrados ternimados en " + sospechoso + " son: \n - - " + bonitos + " - - ");
    }

    public static void detective(int sospechoso, int[] col, int[] sos) {
        int numero = 0;
        int i = 0;
        for (int detecta : col) {
            numero = detecta % 10;
            if (numero == sospechoso) {
                sos[i] = detecta;
                i++;
            }
        }
    }
}
