import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class metodoEdad {
    public static void main(String[] args) {
        
        HashMap<Integer, Integer> idNombre = new HashMap<>();
        idNombre.put(1, 2);
        idNombre.put(2, 6);
        idNombre.put(3, 10);
        idNombre.put(4, 45);
        idNombre.put(5, 64);
        idNombre.put(6, 12);
        idNombre.put(7, 18);
        idNombre.put(8, 15);
        
        ArrayList<Integer> ordenAlfa = new ArrayList<>();
        for (Integer edad : idNombre.values()) {
            ordenAlfa.add(edad);
        }

        Collections.sort(ordenAlfa);

        System.out.println("Edades ordenados alfabéticamente:");
        for (Integer nombre : ordenAlfa) {
            System.out.println(nombre);
        }
    }
}