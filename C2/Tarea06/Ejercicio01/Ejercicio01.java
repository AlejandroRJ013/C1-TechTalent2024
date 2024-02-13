import javax.swing.JOptionPane;

public class Ejercicio01 {

    public static void main(String[] args) {
        String figuraM = JOptionPane.showInputDialog("¿De que figura quieres calcural su área?");
        String figura = figuraM.toLowerCase();

        if (figura.equals("cuadrado")) {
            String lado1 = JOptionPane.showInputDialog("Inserte el tamaño del primer lado");
            String lado2 = JOptionPane.showInputDialog("Inserte el tamaño del segundo lado");
            JOptionPane.showMessageDialog(null, "El área del caudrado es : " + Cuadrado(lado1, lado2));
        } else if (figura.equals("triangulo")) {
            String base = JOptionPane.showInputDialog("Inserte el tamaño de la base del triangulo");
            String altura = JOptionPane.showInputDialog("Inserte la altura del triangulo");
            JOptionPane.showMessageDialog(null, "El área del caudrado es : " + Triangulo(base, altura));
        } else if (figura.equals("circulo")) {
            String radio = JOptionPane.showInputDialog("Inserte el tamaño del radio");
            JOptionPane.showMessageDialog(null, "El área del caudrado es : " + Circulo(radio));
        } else {
            JOptionPane.showMessageDialog(null,
                    "¿Has escrito bien el nombre de la figura? \n Las opciones son: \n - Cuadrado \n - Triangulo \n - Circulo");
        }
    }

    public static int Cuadrado(String lad1, String lad2) {
        int lado1 = Integer.parseInt(lad1);
        int lado2 = Integer.parseInt(lad2);
        int AreaH = lado1 * lado2;
        return AreaH;
    }

    public static int Triangulo(String bas, String altur) {
        int base = Integer.parseInt(bas);
        int altura = Integer.parseInt(altur);
        int AreaT = (base * altura) / 2;
        return AreaT;
    }

    public static double Circulo(String radi) {
        final double pi = 3.14;
        int radio = Integer.parseInt(radi);
        double AreaC = (Math.pow(radio, 2) * pi);
        return AreaC;
    }
}