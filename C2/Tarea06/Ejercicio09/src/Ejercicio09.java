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
        StringBuilder sumacion = new StringBuilder("");
        sumar(numaleatorios, sumacion, imprimir(numaleatorios, numesp), tamaño);
    }

    public static int sumar(int[] valor, StringBuilder sumacion, StringBuilder numesp, int tam) {
        int suma = 0;
        int i = 0;
        for (int numero : valor) {
            suma += numero;
        }
        for (int numero : valor) {
            if (i < tam - 1) {
                sumacion.append(numero + " + ");
                i++;
            } else {
                sumacion.append(numero + " = ");
            }
        }
        JOptionPane.showMessageDialog(null, "La suma de tus numeros es: \n" + sumacion + suma+"\n\nY tu colección: \n"+numesp);
        return suma;
    }

    public static StringBuilder imprimir(int[] valor, StringBuilder numesp) {
        int i = 0;
        for (int junto : valor) {
            numesp.append("Indice ["+i+"]: "+junto).append(" \n");
            i++;
        }
        return numesp;
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
            if(tam<9) {
                while (repes(valor, aleatorio)) {
                    aleatorio = (int) (Math.random() * nume);
                }
                valor[i] = aleatorio;
            } else {
                aleatorio = (int) (Math.random() * nume);
                valor[i] = aleatorio;
            }
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