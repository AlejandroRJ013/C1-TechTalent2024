import javax.swing.JOptionPane;

public class Ejercicio09 {
    public static void main(String[] args) {
        String tamano = JOptionPane.showInputDialog("Cantidad de numeros aleatorios generado:");
        while (tamano.equals("")) {
            tamano = JOptionPane.showInputDialog("Ingrese algun número por favor:");
        }
        int tamaño = Integer.parseInt(tamano);
        int numaleatorios[] = new int[tamaño];
        rellenar(numaleatorios, tamaño);
        StringBuilder numesp = new StringBuilder("");
        int lasuma = sumar(numaleatorios);
        mostrar(numaleatorios, numesp, lasuma, tamaño);
    }

    public static int sumar(int[] valor) {
        int suma = 0;
        for (int numero : valor) {
            suma += numero;
        }
        return suma;
    }

    public static void mostrar(int[] valor, StringBuilder numesp, int suma, int tam) {
        for (int numero : valor) {
            int i = 0;
            if (i < tam - 1) {
                numesp.append(numero + " + ");
                i++;
            } else {
                numesp.append(numero + " = ");
            }
        }
        JOptionPane.showMessageDialog(null, "La suma de tus numeros es: \n" + numesp + suma);
    }

    public static void rellenar(int valor[], int tam) {
        for (int i = 0; i < tam; i++) {
            String numtxt = JOptionPane.showInputDialog(
                    "Valor máximo para la generaración del numero " + (i + 1) + ":");
            int nume = Integer.parseInt(numtxt);
            while (nume > 10) {
                numtxt = JOptionPane.showInputDialog(
                        "El rango de generación dado en el ejercicio es de 0[1]-9[10].\n Elija un valor válido");
                nume = Integer.parseInt(numtxt);
            }
            int aleatorio = (int) (Math.random() * nume);

            if (valor.length >= tam) {
                aleatorio = (int) (Math.random() * nume);
                valor[i] = aleatorio;
            }
            while (repes(valor, aleatorio)) {
                aleatorio = (int) (Math.random() * nume);
            }
            valor[i] = aleatorio;
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
}