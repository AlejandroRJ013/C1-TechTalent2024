import modelo.MemoryModel;
import vista.MemoryView;
import controlador.MemoryController;

public class Main {
    public static void main(String[] args) {
        int size = 4; // Tamaño del tablero 4x4
        MemoryModel model = new MemoryModel(size);
        MemoryView view = new MemoryView(size);
        MemoryController controller = new MemoryController(model, view);
    }
}