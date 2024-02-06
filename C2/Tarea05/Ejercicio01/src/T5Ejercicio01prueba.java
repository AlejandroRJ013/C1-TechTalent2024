import javax.swing.JOptionPane;

public class T5Ejercicio01prueba {

    public static void main(String[] args) {
        
        String valor11=JOptionPane.showInputDialog("Elige tu primer numero");
        String valor21=JOptionPane.showInputDialog("Elige tu segundo numero");

            int val1=Integer.parseInt(valor11), val2=Integer.parseInt(valor21);

            if (val1>val2) {
                JOptionPane.showMessageDialog(null, "El primer numero es mayor al segundo: "+val1+">"+val2);
            } else {
            	JOptionPane.showMessageDialog(null, "El segundo numero es mayor al primero: "+val2+">"+val1);
            }
        
    }
}