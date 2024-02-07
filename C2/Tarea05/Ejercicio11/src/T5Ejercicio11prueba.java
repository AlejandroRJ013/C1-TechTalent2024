import javax.swing.JOptionPane;

public class T5Ejercicio11prueba {
    public static void main(String[] args) {
        String respuesta = JOptionPane.showInputDialog("¿Que dia es hoy?");
        respuesta = respuesta.toLowerCase();

        switch (respuesta) {
            case "lunes":
                JOptionPane.showMessageDialog(null, "Este día te toca trabajar listillo - ¡DIA LABORAL!");
                break;
            case "martes":
                JOptionPane.showMessageDialog(null, "Este día te toca trabajar listillo - ¡DIA LABORAL!");
                break;
            case "miercoles":
                JOptionPane.showMessageDialog(null, "Este día te toca trabajar listillo - ¡DIA LABORAL!");
                break;
            case "jueves":
                JOptionPane.showMessageDialog(null, "Este día te toca trabajar listillo - ¡DIA LABORAL!");
                break;
            case "viernes":
                JOptionPane.showMessageDialog(null, "Este día te toca trabajar listillo - ¡DIA LABORAL!");
                break;
            case "sabado":
                JOptionPane.showMessageDialog(null, "Hoy a disfrutar como un señor - ¡DIA FESTIVO!");
                break;
            case "domingo":
                JOptionPane.showMessageDialog(null, "Hoy a disfrutar como un señor - ¡DIA FESTIVO!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "-- Escribe un dia de la semana --");
        }
    }
}