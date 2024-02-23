import javax.swing.JOptionPane;

public class sorteo {
    public static void main(String[] args) {
        String cantpart = JOptionPane.showInputDialog("Introduce cuantos participantes habrán");
        int cant = Integer.parseInt(cantpart);
        String[] participantes = new String[cant];
        for (int canti = 0; canti < cant; canti++) {
            String nombre = JOptionPane.showInputDialog("Introduce un usuario que participe en el sorteo");
            nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
            participantes[canti] = nombre;
        }

        StringBuilder mensaje = new StringBuilder("  -  -  PARTICIPANTES  -  -  \n");
        for (String jugador : participantes) {
            mensaje.append(" - ").append(jugador).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());

        int ganador = (int) Math.round(Math.random()*(cant-1));
        JOptionPane.showMessageDialog(null, "El ganador es..."+participantes[ganador]+"\n ¡FELICIDADES! No has ganado nada.");
    }
}