import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// Modelo
class ModeloImagen {
    private BufferedImage imagen;

    public ModeloImagen(String ruta) throws IOException {
        imagen = ImageIO.read(new File(ruta));
    }

    public BufferedImage getImagen() {
        return imagen;
    }
}

// Vista
class VistaImagen extends JFrame {
    private JLabel etiquetaImagen;

    public VistaImagen() {
        setTitle("Visor de Imagen");
        etiquetaImagen = new JLabel();
        add(etiquetaImagen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void mostrarImagen(BufferedImage imagen) {
        etiquetaImagen.setIcon(new ImageIcon(imagen));
    }
}

// Controlador
class ControladorImagen {
    private ModeloImagen modelo;
    private VistaImagen vista;

    public ControladorImagen(ModeloImagen modelo, VistaImagen vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarAplicacion() {
        vista.mostrarImagen(modelo.getImagen());
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) throws IOException {
        String rutaImagen = "ejercicio01/src/main/java/com/ejercicio01/img/botonCreate.png";
        ModeloImagen modelo = new ModeloImagen(rutaImagen);
        VistaImagen vista = new VistaImagen();
        ControladorImagen controlador = new ControladorImagen(modelo, vista);
        controlador.iniciarAplicacion();
    }
}