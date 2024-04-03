import java.util.*;

public class mainCine {
    public static void main(String[] args) {
        Espectador espectador1 = new Espectador("Jorge", 25, 100);
        Espectador espectador2 = new Espectador("María", 25, 120);
        Espectador espectador3 = new Espectador("Julia", 25, 80);
        Espectador espectador4 = new Espectador("Kevin", 25, 150);
        Espectador espectador5 = new Espectador("Laura", 25, 200);
        Espectador espectador6 = new Espectador("Pedro", 25, 90);
        Espectador espectador7 = new Espectador("David", 25, 110);
        Espectador espectador8 = new Espectador("Carla", 25, 70);
        Espectador espectador9 = new Espectador("Pablo", 25, 130);
        Espectador espectador10 = new Espectador("Sonia", 25, 180);
        Espectador espectador11 = new Espectador("Rubén", 25, 95);
        Espectador espectador12 = new Espectador("Paula", 25, 105);
        Espectador espectador13 = new Espectador("Oscar", 25, 140);
        Espectador espectador14 = new Espectador("Elena", 25, 160);
        Espectador espectador15 = new Espectador("Mario", 25, 75);
        Espectador espectador16 = new Espectador("Paula", 25, 220);
        Espectador espectador17 = new Espectador("Amber", 25, 85);
        Espectador espectador18 = new Espectador("Ramón", 25, 190);
        Espectador espectador19 = new Espectador("Eider", 25, 115);
        Espectador espectador20 = new Espectador("Diego", 25, 125);
        Espectador espectador21 = new Espectador("Carol", 25, 105);
        Espectador espectador22 = new Espectador("Ángel", 25, 140);
        Espectador espectador23 = new Espectador("Sofía", 25, 10);
        Espectador espectador24 = new Espectador("Mikel", 25, 75);
        Espectador espectador25 = new Espectador("Lucas", 10, 90);

        ArrayList<Espectador> espectadores = new ArrayList<>();
        espectadores.addAll(Arrays.asList(espectador1, espectador2, espectador3, espectador4, espectador5, espectador6, espectador7, espectador8, espectador9, espectador10, espectador11, espectador12, espectador13, espectador14, espectador15, espectador16, espectador17, espectador18, espectador19, espectador20, espectador21, espectador22, espectador23, espectador24, espectador25));

        Pelicula pelicula = new Pelicula("Alicia", "120:51", 15, "Almodobar");
        Sala sala = new Sala(8, 9, pelicula, 20.20);
        
        ArrayList<String> posicionAsientos = new ArrayList<>();
        StringBuilder visionFinalAsientos = new StringBuilder();
        StringBuilder asientoAsignado = new StringBuilder();
        HashMap<String, Espectador> espectador_asiento = new HashMap<>();
        for (Espectador espectador : espectadores) {
            if (sala.puedeEntrar(espectador).equals("si")) {
                asientoAsignado.append(sala.asignarAsiento(espectador, espectadores, espectador_asiento, posicionAsientos));
                if (asientoAsignado.toString().equals("La capacidad de la sala es menor a la cantidad de espectadores.\n Capacidad de la sala: " + (sala.getFilas()*sala.getColumnas()) + "\n Número de espectadores: " + espectadores.size())) {
                }
            } else if (sala.puedeEntrar(espectador).equals("dinero")) {
                System.out.println("El espectador " + espectador.getNombre() + " no tiene el dinero suficiente. [" + espectador.getDinero() + "€]");
            } else if (sala.puedeEntrar(espectador).equals("edad")) {
                System.out.println("El espectador " + espectador.getNombre() + " no tiene la edad mínima. " + espectador.getEdad() + " años");
            } else {
                System.out.println("El espectador " + espectador.getNombre() + " no cumple con algúnos de los requisitos");
            }
        }
        System.out.println(asientoAsignado.toString());

        crearVisionFinal(sala, visionFinalAsientos, espectador_asiento, posicionAsientos);
        imprimirLetraPorLetra(visionFinalAsientos.toString());

    }

    public static void crearVisionFinal(Sala sala, StringBuilder visionFinalAsientos, HashMap<String, Espectador> espectador_asiento, ArrayList<String> posicionAsientos) {
        int fila = sala.getFilas();
        int columna = sala.getColumnas();
        int filaMostrada = fila;
        int letraAscii = 65;
        for (int i = 0; i < fila; i++) {
            visionFinalAsientos.append("|");
            for (int j = 0; j < columna; j++) {
                char letraColumna = (char) letraAscii;
                String asientoActual = String.valueOf(filaMostrada) + letraColumna;
                boolean esta = false;
                for (String asientoOcupado : posicionAsientos) {
                    if (asientoActual.equals(asientoOcupado)) {
                        for (String asientoHash : espectador_asiento.keySet()) {
                            if (asientoHash.equals(asientoActual)) {
                                visionFinalAsientos.append("- - " + espectador_asiento.get(asientoHash).getNombre() + " [" + filaMostrada + letraColumna + "] - -|");
                                esta = true;
                            }
                        }
                    }
                }
                if (!esta) {
                    visionFinalAsientos.append("    Libre [" + filaMostrada + letraColumna + "]    |");
                }
                letraAscii++;
            }
            visionFinalAsientos.append("\n");
            letraAscii = 65;
            filaMostrada--;
        }
    }

    public static void imprimirLetraPorLetra(String asientos) {
        for (int i = 0; i < asientos.length(); i++) {
            char letra = asientos.charAt(i);
            System.out.print(letra);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                System.out.println("\n\nFin del programa");
            }
        }
    }
}