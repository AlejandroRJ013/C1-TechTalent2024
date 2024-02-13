import javax.swing.JOptionPane;

public class EjerExtra5 {
    public static void main(String[] args) {
        String frase = JOptionPane.showInputDialog(null, "Ingresa un palindromo:");
        String pali = frase.toLowerCase();
        String pala = pali.replaceAll("\\s+", "");
        char[] car = pala.toCharArray();
        int longitud = pala.length();
        int limite = (longitud / 2);
        int ult = (longitud - 1);
        int prin = 0;
        boolean noespoli = false;

        if (longitud % 2 == 0) {
            for (prin = 0; ((prin < limite) && (ult >= limite)); prin++, ult--) {
                if (car[prin] != car[ult]) {
                    noespoli = true;
                } else {
                }
            }
            if (noespoli == true) {
                JOptionPane.showMessageDialog(null, "La frase <" + frase + "> no es un palíndromo.");
            } else {
                JOptionPane.showMessageDialog(null, "La frase <" + frase + "> es un palíndromo.");
            }
        } else {
            for (prin = 0; ((prin < limite) && (ult > limite)); prin++, ult--) {
                if (car[prin] != car[ult]) {
                    noespoli = true;
                } else {
                }
            }
            if (noespoli == true) {
                JOptionPane.showMessageDialog(null, "La frase <" + frase + "> no es un palíndromo.");
            } else {
                JOptionPane.showMessageDialog(null, "La frase <" + frase + "> es un palíndromo.");
            }
        }
    }
}