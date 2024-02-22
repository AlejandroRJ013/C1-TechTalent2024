import javax.swing.JOptionPane;

public class T6Extra04 {
    public static void main(String[] args) {
        StringBuilder conguntodeletras = new StringBuilder("");
        String introducirpalabra = JOptionPane.showInputDialog(" - - Escriba una palabra - - ");
        String palabra = introducirpalabra.toLowerCase();
        String strindice = JOptionPane
                .showInputDialog(" - - Escriba el indice donde buscar - - \n - - El rango de indices es: [ 0 - "
                        + (palabra.length() - 1) + " ] - - ");
        int indice = Integer.parseInt(strindice);
        char[] letraspalabra = palabra.toCharArray();
        conguntodeletras.append(letraspalabra[indice - 1]).append(letraspalabra[indice])
                .append(letraspalabra[indice + 1]);
        if (iguales(indice, letraspalabra)) {
            JOptionPane.showMessageDialog(null, " - - Las letras que rodean la tuya son iguales - - \nTu letra: "
                    + letraspalabra[indice] + "\nLetras que la rodean: " + conguntodeletras);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Que lastima ;(\nLas letras que rodean la tuya no son iguales: " + conguntodeletras);
        }
    }

    public static boolean iguales(int indice, char letraspalabra[]) {
        String anterior = String.valueOf(letraspalabra[indice - 1]);
        String posterior = String.valueOf(letraspalabra[indice + 1]);
        if (anterior.equals(posterior)) {
            return true;
        } else {
            return false;
        }
    }
}