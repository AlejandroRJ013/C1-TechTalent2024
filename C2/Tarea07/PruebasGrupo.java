import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PruebasGrupo {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Alumnos curso TechTalent2024");
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel titul = new JPanel();
        titul.setLayout(new FlowLayout());

        JLabel titulo = new JLabel(" - - CON QUE VALOR SE ORDENARÁN LOS ALUMNOS - - ");
        titulo.setVerticalAlignment(SwingConstants.TOP);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        titul.add(titulo);

        JPanel marcador = new JPanel();
        marcador.setLayout(new FlowLayout());

        JLabel identificacion = new JLabel("ID: ");
        JCheckBox id = new JCheckBox();
        JLabel nombreAlumno = new JLabel("Nombre: ");
        JCheckBox nombre = new JCheckBox();
        JLabel edadAlumno = new JLabel("Edad: ");
        JCheckBox edad = new JCheckBox();

        marcador.add(identificacion);
        marcador.add(id);
        marcador.add(nombreAlumno);
        marcador.add(nombre);
        marcador.add(edadAlumno);
        marcador.add(edad);

        frame.add(titul);
        frame.add(marcador);

        JPanel contenidoDinamico = new JPanel();
        contenidoDinamico.setLayout(new FlowLayout());

        JPanel contenido = new JPanel();
        contenido.setLayout(new FlowLayout());

        contenido.add(new JLabel("funciona?"));

        id.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (id.isSelected()) {
                    contenidoDinamico.removeAll(); // Limpiar contenido previo
                    contenidoDinamico.add(contenido);
                } else {
                    contenidoDinamico.removeAll();
                }
                contenidoDinamico.revalidate(); // Actualizar el layout del frame
                contenidoDinamico.repaint(); // Actualizar el layout del frame
            }

        });
        frame.add(contenidoDinamico);

        frame.setVisible(true);
    }
}