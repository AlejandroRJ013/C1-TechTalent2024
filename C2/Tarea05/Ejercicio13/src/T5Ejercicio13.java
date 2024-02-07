import javax.swing.JOptionPane;

public class T5Ejercicio13 {
    public static void main(String[] args) {
        String calculo = JOptionPane.showInputDialog("Ingrese la operación separada por espacios: <3 ^ 2> ");
        String[] espacios = calculo.split(" ");
        String nume1 = espacios[0];
        String sim = espacios[1];
        String nume2 = espacios[2];
        int num1 = Integer.parseInt(nume1);
        int num2 = Integer.parseInt(nume2);
        if (sim.equals("+")) {
            int sum = Math.addExact(num1, num2);
            JOptionPane.showMessageDialog(null, "La suma de tus valores es: \n"
                    + num1 + " + " + num2 + " = " + sum);
        } else if (sim.equals("-")) {
            int res = Math.subtractExact(num1, num2);
            JOptionPane.showMessageDialog(null, "La resta de tus valores es: \n"
                    + num1 + " - " + num2 + " = " + res);
        } else if (sim.equals("*")) {
            int mul = Math.multiplyExact(num1, num2);
            JOptionPane.showMessageDialog(null, "La multiplicación de tus valores es: \n"
                    + num1 + " * " + num2 + " = " + mul);
        } else if (sim.equals("/")) {
            int div = Math.floorDiv(num1, num2);
            JOptionPane.showMessageDialog(null, "La división de tus valores es: \n"
                    + num1 + " / " + num2 + " = " + (num1 / num2) + " \n " + div);
        } else if (sim.equals("^")) {
            double exp = Math.pow(num1, num2);
            int sincoma = (int) exp;
            double comax = (exp - sincoma);
            if (comax == 0.0) {
                JOptionPane.showMessageDialog(null, "El primer valor elevado al segundo es: \n"
                        + num1 + " ^ " + num2 + " = " + sincoma);
            } else {
                JOptionPane.showMessageDialog(null, "El primer valor elevado al segundo es: \n"
                        + num1 + " ^ " + num2 + " = " + exp);
            }
        } else if (sim.equals("%")) {
            JOptionPane.showMessageDialog(null, "El modulo de tus valores es: \n"
                    + num1 + " % " + num2 + " = " + (num1 % num2));
        } else {
            JOptionPane.showMessageDialog(null, "¿Has puesto bien los espacios? Ejemplo: 4 * 5");
        }
    }
}