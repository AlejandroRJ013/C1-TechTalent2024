import javax.swing.JOptionPane;

public class Ejercicio02 {
    public static void main(String[] args) {
        String can = JOptionPane.showInputDialog("Cual es la cantidad de numeros aleatorios que se generaran");
        int canti = Integer.parseInt(can);
        generador(canti);
    }

    public static void generador(int cantidad) {
        int numero = 0;
        StringBuilder juntas = new StringBuilder(numero);
        for (int i = 0; i < cantidad; i++) {
            String limi = JOptionPane.showInputDialog("El rango de numeros aleatorios ira desde el 1 hasta: ");
            int limite = Integer.parseInt(limi);
            numero = (int) Math.round(Math.random() * limite);
            if (numero == 0) {
                numero += 1;
            }
        juntas.append(numero+", "); 
        }
        JOptionPane.showMessageDialog(null, juntas); 
    }
}