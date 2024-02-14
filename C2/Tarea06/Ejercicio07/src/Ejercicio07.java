import javax.swing.JOptionPane;

public class Ejercicio07 {
    public static void main(String[] args) {
        String euro = JOptionPane.showInputDialog("¿Cual es la cantidad de euros que quiere convertir?");
        double euros = Double.parseDouble(euro);
        String moneda = JOptionPane
                .showInputDialog("¿A que moneda quiere convertirlo?\n - Dolares\n - Libras\n - Yenes");
        moneda = moneda.toLowerCase();
        conversor(euros, moneda);
    }

    public static void conversor(double euros, String moneda) {
        double dolares = 1.07;
        double yenes = 161.48;
        double libras = 0.85;

        switch (moneda) {
            case "dolares":
                JOptionPane.showMessageDialog(null,
                        "La cantidad de " + euros + "€ en dolares es: " + euros / dolares + "$");
                break;

            case "yenes":
                JOptionPane.showMessageDialog(null,
                        "La cantidad de " + euros + "€ en yenes es: " + euros / yenes + "¥");
                break;

            case "libras":
                JOptionPane.showMessageDialog(null,
                        "La cantidad de " + euros + "€ en libras es: " + euros / libras + "£");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ingrese valores validos");
                break;
        }
    }
}