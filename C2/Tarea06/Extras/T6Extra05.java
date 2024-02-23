import javax.swing.JOptionPane;

public class T6Extra05 {
    public static void main(String[] args) {
        StringBuilder bonito = new StringBuilder("");
        String sebusca = "a";
        String palabramayus = JOptionPane
                .showInputDialog("Introduzca una palabra para buscar la " +
                        "segunda y tercera vez que aparece [ a ] :");
        String palabra = palabramayus.toLowerCase();
        char[] letras = palabra.toCharArray();
        buscarymostrar(bonito, sebusca, palabramayus, palabra, letras);
    }

    public static void buscarymostrar(StringBuilder bonito, String sebusca,
            String palabramayus, String palabra, char letras[]) {
        int cont = 0;
        int indice1 = 0;
        int indice2 = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (sebusca.equals(String.valueOf(letras[i]))) {
                cont++;
                if (cont == 2) {
                    indice1 = i;
                } else if (cont == 3) {
                    indice2 = i;
                }
            }
        }
        hacerlobonito(bonito, cont, indice1, indice2, palabra, letras);
        if (cont == 2) {
            JOptionPane.showMessageDialog(null,
                    "No hay tercera, la segunda [ a ] encontrada en la palabra/frase <" +
                            palabramayus + "> es la siguiente:\n - Índice: " + indice1 + "\nPosición:" + bonito);
        } else if (cont > 2) {
            JOptionPane.showMessageDialog(null,
                    "Las [ a ] encontradas en la palabra/frase <" + palabramayus
                            + "> son las siguientes:\nSegunda:\n - Índice: [" + indice1
                            + "]\n\nTercera:\n - Índice: [" + indice2 + "]\n\nPosición:\n" + bonito);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se encontraron un mínimo de dos [ a ] para poder hacer el programa");
        }
    }

    public static void hacerlobonito(StringBuilder bonito, int cont, int indice1, int indice2, String palabra,
            char letras[]) {
        if (cont == 2) {
            for (int i = 0; i < indice1; i++) {
                bonito.append(letras[i]);
            }
            bonito.append("." + letras[indice1] + ".");
            for (int i = indice1 + 1; i < palabra.length(); i++) {
                bonito.append(letras[i]);
            }
        } else if (cont > 2) {
            for (int i = 0; i < indice1; i++) {
                bonito.append(letras[i]);
            }
            bonito.append("." + letras[indice1] + ".");
            for (int i = indice1 + 1; i < indice2; i++) {
                bonito.append(letras[i]);
            }
            bonito.append("." + letras[indice2] + ".");
            for (int i = indice2 + 1; i < palabra.length(); i++) {
                bonito.append(letras[i]);
            }
        }
    }
}