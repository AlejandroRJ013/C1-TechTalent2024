import javax.swing.JOptionPane;

public class T5Ejercicio11prueba {
    public static void main(String[] args) {
        String respuesta = JOptionPane.showInputDialog("¿Que dia es hoy?");
        respuesta = respuesta.toLowerCase();

        switch (respuesta) {
            case "lunes":
                JOptionPane.showMessageDialog(null, "Este día te toca trabajar listillo - dia laboral");
                break;
            case "martes":
                JOptionPane.showMessageDialog(null, "Este día te toca trabajar listillo - dia laboral");
                break;
            case "miercoles":
                JOptionPane.showMessageDialog(null, "Este día te toca trabajar listillo - dia laboral");
                break;
            case "jueves":
                JOptionPane.showMessageDialog(null, "Este día te toca trabajar listillo - dia laboral");
                break;
            case "viernes":
                JOptionPane.showMessageDialog(null, "Este día te toca trabajar listillo - dia laboral");
                break;
            case "sabado":
                JOptionPane.showMessageDialog(null, "Hoy a disfrutar como un señor - dia festivo");
                break;
            case "domingo":
                JOptionPane.showMessageDialog(null, "Hoy a disfrutar como un señor - dia festivo");
                break;
            default:
                JOptionPane.showMessageDialog(null, "-- Escribe un dia de la semana --");
        }
    } 
}