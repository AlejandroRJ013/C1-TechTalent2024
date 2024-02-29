import javax.swing.JOptionPane;

public class Ejercicio12 {
    public static void main(String[] args) {
        StringBuilder tusNumeros = new StringBuilder("");
        String tamaño = JOptionPane.showInputDialog("Ingrese la cantidad de numeros que se generará");
        int tam = Integer.parseInt(tamaño);
        int col[] = new int[tam];

        rellenar(tam, col, tusNumeros);

        String sospecharDe = JOptionPane.showInputDialog("Indique el número que se buscará");
        int sospechoso = Integer.parseInt(sospecharDe);

        while (!numeroCorrecto(sospechoso)) {
            sospecharDe = JOptionPane.showInputDialog("Indique un número entre [0-9]");
            sospechoso = Integer.parseInt(sospecharDe);
        }

        int sos[] = new int[tam];
        StringBuilder bonitos = new StringBuilder("");

        detective(sospechoso, col, sos);

        boolean noHayPapeles = false;
        for (int numero : sos) {
            if (numero != 0) {
                noHayPapeles = true;
                break;
            }
        }
        
        if (noHayPapeles) {

            mostrar(sos, bonitos, sospechoso);

        } else {
            JOptionPane.showMessageDialog(null,
                    "No hay números que terminen en " + sospechoso + "\nTus números generados:\n" + tusNumeros);
        }
    }

    public static void rellenar(int tam, int[] col, StringBuilder tusNumeros) {
        for (int i = 0; i < tam; i++) {
            int aleatorio = (int) ((Math.random() * 300) + 1);
            col[i] = aleatorio;
            tusNumeros.append(aleatorio + " ");
        }
    }

    public static void mostrar(int[] sos, StringBuilder bonitos, int sospechoso) {
        for (int i = 0; i < sos.length; i++) {
            if (sos[i] != 0) {
                if (i < (sos.length - 1)) {
                    bonitos.append(sos[i] + ", ");
                } else {
                    bonitos.append(sos[i] + " ");
                }
            }
        }
        JOptionPane.showMessageDialog(null,
                "Los numeros encontrados ternimados en " + sospechoso +
                        " son: \n - - " + bonitos + " - - ");
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

    public static boolean numeroCorrecto(int sospechoso) {
        if (sospechoso < 0) {
            return false;
        } else if (sospechoso >= 10) {
            return false;
        }
        return true;
    }
}
