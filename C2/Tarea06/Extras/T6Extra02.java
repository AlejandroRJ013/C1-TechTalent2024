import javax.swing.JOptionPane;

public class T6Extra02 {
    public static void main(String[] args) {
        String str1 = JOptionPane.showInputDialog("Introduzca la primera palabra");
        String str2 = JOptionPane.showInputDialog("Introduzca la segunda palabra");
        String minus1 = str1.toLowerCase();
        String minus2 = str2.toLowerCase();
        char[] caracteres1 = minus1.toCharArray();
        char[] caracteres2 = minus2.toCharArray();
        String car1 = String.valueOf(caracteres1[caracteres1.length-2])+String.valueOf(caracteres1[caracteres1.length-1]);
        String car2 = String.valueOf(caracteres2[caracteres2.length-2])+String.valueOf(caracteres2[caracteres2.length-1]);

        boolean soniguales = false;
        if (car1.equals(car2)) {
            soniguales = true;
        }

        if (soniguales) {
            JOptionPane.showMessageDialog(null,
                    "Exacto, estas palabras terminan en " + car1 + "\n - " + str1 + "\n - " + str2);
        } else {
            JOptionPane.showMessageDialog(null, "Que pena, estas palabras no terminan igual:\n - " + str1
                    + " ==> " + car1 + "\n - " + str2 + " ==> " + car2);
        }
    }
}