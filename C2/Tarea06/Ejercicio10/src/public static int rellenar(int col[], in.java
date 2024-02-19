public static int rellenar(int col[], int tam) {
        StringBuilder numerosprim = new StringBuilder("");
        int i = 0;
        int mates = 0;
        preguntar: while (i < tam) {
            String destxt = JOptionPane.showInputDialog("Valor máximo para generar el número aleatorio: ");
            int max = Integer.parseInt(destxt);
            generarnumero: while (i < tam) {
                mates = (int) (Math.random() * max);
                if (!primo(mates)) {
                    continue generarnumero;
                } else {
                    System.out.print("Posición " + i + ": ");
                    i++;
                    col[i] = mates;
                    numerosprim.append(col[i] + " ");
                    System.out.print(mates + "\n");
                    continue preguntar;
                }
            }
            System.out.println(i);
        }
        return max;
    }

    StringBuilder numerosprim = new StringBuilder("");

public static int rellenar(int col[], int tam, StringBuilder numeros) {
    for (int i = 0; i < tam; i++) {
        String destxt = JOptionPane.showInputDialog("Valor máximo para generar el número aleatorio: ");
        int max = Integer.parseInt(destxt);
        int mates = (int) (Math.random() * max);
        if (primo(mates)) {
            col[i] = mates;
            numeros.append(mates+" ");
            i++
        }
    }
}

public static String generarprimos(int tam, int max) {
    StringBuilder numerosprim = new StringBuilder("");
    for (int i = 0; i < tam; ) {
        int mates = (int) (Math.random() * max);
        if (primo(mates)) {
            numerosprim.append(mates+" ");
        } else {}
    }
    return numerosprim.toString();
}


while (i < tam) {
    mates = (int) (Math.random() * max);
    if (primo(mates)) {
        numerosprim.append(mates+" ");
    } else {}
}