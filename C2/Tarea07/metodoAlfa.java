import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class metodoAlfa {
    public static void main(String[] args) {
        StringBuilder grup = new StringBuilder();
        StringBuilder grupo1 = new StringBuilder("\nGrupo 1:\n");
        StringBuilder grupo2 = new StringBuilder("\nGrupo 2:\n");
        StringBuilder grupo3 = new StringBuilder("\nGrupo 3:\n");
        StringBuilder grupo4 = new StringBuilder("\nGrupo 4:\n");
        StringBuilder grupo5 = new StringBuilder("\nGrupo 5:\n");
        HashMap<Integer, String> idNombre = new HashMap<>();
        idNombre.put(1, "Jose");
        idNombre.put(2, "Isabel");
        idNombre.put(3, "Joel");
        idNombre.put(4, "Sebas");
        idNombre.put(5, "Abdellah");
        idNombre.put(6, "Antonio");
        idNombre.put(7, "Diego");
        idNombre.put(8,"Manel");
        idNombre.put(9, "Jessica");
        idNombre.put(10, "Santos");
        idNombre.put(11, "Alex");
        idNombre.put(12, "Ana María");
        idNombre.put(13, "Aurora");
        idNombre.put(14, "Laia");
        idNombre.put(15, "Alejandro");
        
        ArrayList<String> ordenAlfa = new ArrayList<>();
        for (String nombre : idNombre.values()) {
            ordenAlfa.add(nombre);
        }

        Collections.sort(ordenAlfa);

        int numeroGrupo = 1;
        int integrantesGrupo = 0;
        for (int indice = 0; indice<15; indice++) {
            if (numeroGrupo <=5) {
                if (integrantesGrupo <= 3) {
                    String nombre = ordenAlfa.get(indice);
                    grup.append(nombre+"\n");
                    integrantesGrupo++;
                }
                if (integrantesGrupo == 3 && numeroGrupo == 1) {
                    grupo1.append(grup.toString());
                } else if (integrantesGrupo == 3 && numeroGrupo == 2) {
                    grupo2.append(grup.toString());
                } else if (integrantesGrupo == 3 && numeroGrupo == 3) {
                    grupo3.append(grup.toString());
                } else if (integrantesGrupo == 3 && numeroGrupo == 4) {
                    grupo4.append(grup.toString());
                } else if (integrantesGrupo == 3 && numeroGrupo == 5) {
                    grupo5.append(grup.toString());
                }
                if (integrantesGrupo == 3) {
                    integrantesGrupo = 0;
                    numeroGrupo++;
                    grup.setLength(0);
                }
            }
        }
        grup.append(grupo1.toString()).append(grupo2.toString()).append(grupo3.toString()).append(grupo4.toString()).append(grupo5.toString());

        
        System.out.println(grup.toString());
        // System.out.println(grupo1.toString());
        // System.out.println(grupo2.toString());
        // System.out.println(grupo3.toString());
        // System.out.println(grupo4.toString());
        // System.out.println(grupo5.toString());
        // System.out.println("Nombres ordenados alfabéticamente:");
        // for (String nombre : ordenAlfa) {
        //     System.out.println(nombre);
        // }
    }
}
