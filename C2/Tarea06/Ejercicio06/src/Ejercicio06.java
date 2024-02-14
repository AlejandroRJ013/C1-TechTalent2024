import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;

public class Ejercicio06 {
    public static void main(String[] args) {
        String elnumerito = JOptionPane.showInputDialog("Ingresa un número para saber la cantidad de dígitos que contiene");
        numero(elnumerito);
    }
    
    public static void numero(String nume) {
        if (nume.matches("[a-zA-Z]+")){
            String solonums = nume.replaceAll("[\\a-zA-Z]", "");
            System.out.println(solonums);
            int num = Integer.parseInt(nume);
            if (num <= 0) {
                JOptionPane.showMessageDialog(null, "Ingresa un número superior a 0");
            }
            JOptionPane.showMessageDialog(null, "El numero "+nume+" tiene "+(solonums.length())+" dígitos");
        } else {
            JOptionPane.showMessageDialog(null, "El numero "+nume+" tiene "+(nume.length())+" dígitos");
        }
        
    }
}