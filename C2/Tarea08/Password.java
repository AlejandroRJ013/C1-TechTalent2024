import java.util.Random;

import javax.swing.JOptionPane;

public class Password {
    // ATRIBUTOS
    int longitud;
    final int LONG_PRED = 8;
    String pass;
    final String[] abecedario = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
            "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    // CONSTRUCTORES
    public Password() {
        this.longitud = LONG_PRED;

        Random numAleatorio = new Random();
        StringBuilder pass = new StringBuilder();
        for (int i = 1; i <= longitud; i++) {
            int indiceLetra = numAleatorio.nextInt(abecedario.length);
            int min_mayus = numAleatorio.nextInt(2);
            if (min_mayus == 1) {
                System.out.println(indiceLetra + " --> " + abecedario[indiceLetra].toUpperCase()); // Mostrar
                pass.append(abecedario[indiceLetra].toUpperCase());
            } else {
                System.out.println(indiceLetra + " --> " + abecedario[indiceLetra]); // Mostrar
                pass.append(abecedario[indiceLetra]);
            }

        }
        System.out.println(pass.toString() + " / OPCIÓN PREDETERMINADA"); // Mostrar
        this.pass = pass.toString();
    }

    public Password(int longitud) {
        this.longitud = longitud;

        Random numAleatorio = new Random();
        StringBuilder pass = new StringBuilder();
        for (int i = 1; i <= longitud; i++) {
            int indiceLetra = numAleatorio.nextInt(abecedario.length);
            int min_mayus = numAleatorio.nextInt(2);
            if (min_mayus == 1) {
                System.out.println(indiceLetra + " --> " + abecedario[indiceLetra].toUpperCase()); // Mostrar
                pass.append(abecedario[indiceLetra].toUpperCase());
            } else {
                System.out.println(indiceLetra + " --> " + abecedario[indiceLetra]); // Mostrar
                pass.append(abecedario[indiceLetra]);
            }

        }
        System.out.println(pass.toString()); // Mostrar
        this.pass = pass.toString();
    }

    // METODOS
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getPass() {
        return pass;
    }

    public static void main(String[] args) {
        boolean mal = false;
        boolean pred = false;
        String contra = "";
        do {
            String input = JOptionPane.showInputDialog("Ingrese la longitud de la contraseña que se generará");
            if (input.isEmpty()) {
                Password password = new Password();
                contra = password.getPass();
                pred = true;
                mal = false;
            } else {
                try {
                    int longitud = Integer.parseInt(input);
                    Password password = new Password(longitud);
                    contra = password.getPass();
                    pred = false;
                    mal = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "INGRESE UN VALOR ENTERO", "Error 404",
                            JOptionPane.ERROR_MESSAGE);
                    mal = true;
                }
            }
        } while (mal);
        if (pred) {
            JOptionPane.showMessageDialog(null, "Tu contraseña será:\n" + contra + "\n\nOPCIÓN PREDETERMINADA.",
                    "Password", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Tu contraseña será:\n" + contra + "\n\nGENERADA ALEATORIAMENTE.",
                    "Password", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
