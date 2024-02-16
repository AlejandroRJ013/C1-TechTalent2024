import javax.swing.JOptionPane;

public class Ejercicio092 {
    public static void main (String[] args) {
        String tamano = JOptionPane.showInputDialog("Cantidad de numeros aleatorios generado:");
        while (tamano.equals("")) {
            tamano = JOptionPane.showInputDialog("Ingrese algun número por favor:");
        }
        int tamaño = Integer.parseInt(tamano);
        int numaleatorios[] = new int[tamaño];
        rellenar(numaleatorios, tamaño);
    }

    public static void rellenar(int valor[], int tam) {
        StringBuilder repes = new StringBuilder();
        for (int i=0; i<tam; i++) {
            String numtxt = JOptionPane.showInputDialog("Valor máximo que se podrá generar de maera aleatoria para la posición "+(i+1)+":");
            int nume = Integer.parseInt(numtxt);
            while (nume>10) {
                numtxt = JOptionPane.showInputDialog("El rango de generación dado en el ejercicio es de 0[1]-9[10].\n Elija un valor válido");
                nume = Integer.parseInt(numtxt);
            }
            int aleatorio = (int) (Math.random()*nume);
            repes.append(aleatorio);
            valor[i] = aleatorio;
            System.out.println(valor[i]);
            System.out.println(aleatorio);            
        }
    }
}
