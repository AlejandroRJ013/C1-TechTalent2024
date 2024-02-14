import javax.swing.JOptionPane;

public class Ejercicio01 {

    public static void main(String[] args) {
        String figuraM = JOptionPane.showInputDialog("¿De que figura quieres calcural su área?");
        String figura = figuraM.toLowerCase();
        forma(figura);       
    }

    public static void forma(String figur) {
        if (figur.equals("cuadrado")) {
            String costado = JOptionPane.showInputDialog("Inserte el tamaño de un lado de tu cuadrado");
            JOptionPane.showMessageDialog(null, "El área del caudrado es : " + Cuadrado(costado));
        } else if (figur.equals("triangulo")) {
            String base = JOptionPane.showInputDialog("Inserte el tamaño de la base del triangulo");
            String altura = JOptionPane.showInputDialog("Inserte la altura del triangulo");
            JOptionPane.showMessageDialog(null, "El área del caudrado es : " + Triangulo(base, altura));
        } else if (figur.equals("circulo")) {
            String radio = JOptionPane.showInputDialog("Inserte el tamaño del radio");
            JOptionPane.showMessageDialog(null, "El área del caudrado es : " + Circulo(radio));
        } else {
            JOptionPane.showMessageDialog(null,
                    "¿Has escrito bien el nombre de la figura? \n Las opciones son: \n - Cuadrado \n - Triangulo \n - Circulo");
        }
    }

    public static int Cuadrado(String lado) {
        int lado1 = Integer.parseInt(lado);
        int AreaH = lado1 * lado1;
        return AreaH;
    }

    public static double Triangulo(String bas, String altur) {
        int base = Integer.parseInt(bas);
        int altura = Integer.parseInt(altur);
        double AreaT = (base * altura) / 2;
        return AreaT;
    }

    public static double Circulo(String radi) {
        final double pi = 3.14;
        int radio = Integer.parseInt(radi);
        double AreaC = (Math.pow(radio, 2) * pi);
        return AreaC;
    }
}