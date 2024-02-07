import javax.swing.JOptionPane;
import java.util.Scanner;

public class T5Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String respuesta;
        String contraseña = "contraseña";
        int cont = 1;
        String lector = sc.nextLine();
        sc.close();
        respuesta = JOptionPane.showInputDialog("Instroduzca: contraseña" + lector);
        System.out.println(lector);
        System.out.println(respuesta);
        System.out.println(contraseña);
        System.out.println(cont);
    }
}
/*
 * while (cont <=3){
 * respuesta =
 * JOptionPane.showInputDialog("Contraseña erronea. Intento numero "+cont);
 * if (respuesta == contraseña) {
 * JOptionPane.showMessageDialog(null, "¡ENHORABUENA!");
 * cont = 4;
 * } else {
 * cont++;
 * }
 * }
 * }
 * }
 */

// respuesta = JOptionPane.showInputDialog("Instroduzca contraseña:");
// if (respuesta != contraseña ) {
// respuesta = JOptionPane.showInputDialog("Instroduzca contraseña:");
// } else {}
// JOptionPane.showMessageDialog(null, "¡ENHORABUENA!");
// if (respuesta != contraseña) {
// respuesta = JOptionPane.showInputDialog("Prueba otra vez");
// } else if (respuesta == contraseña) {
// JOptionPane.showMessageDialog(null, "¡ENHORABUENA!");
// }
// contadores
// do {
// respuesta = JOptionPane.showInputDialog("Instroduzca contraseña:");
// } while (respuesta == contraseña);
// JOptionPane.showMessageDialog(null, "¡ENHORABUENA!");
//
//
// Scanner sc = new Scanner(respuesta);
// if (respuesta == contraseña) {
// JOptionPane.showMessageDialog(null, "¡ENHORABUENA!");
// } else {
// for ()
// }
//
//
// if (respuesta == contraseña) {
// JOptionPane.showMessageDialog(null, "¡ENHORABUENA!");
// } else {
// respuesta = JOptionPane.showInputDialog("Instroduzca contraseña:");
// if (respuesta == contraseña) {
// JOptionPane.showMessageDialog(null, "¡ENHORABUENA!");
// } else {
// respuesta = JOptionPane.showInputDialog("Instroduzca contraseña:");
// if (respuesta == contraseña) {
// JOptionPane.showMessageDialog(null, "¡ENHORABUENA!");
// } else {
// respuesta = JOptionPane.showInputDialog("Instroduzca contraseña:");
// if (respuesta == contraseña) {
// JOptionPane.showMessageDialog(null, "¡ENHORABUENA!");
// } else {
// JOptionPane.showMessageDialog(null, "Escribe bien macho");
// }
// }
// }
// }
