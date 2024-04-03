import java.util.*;

public class Sala {
    //  ATRIBUTOS
    private int filasAsientos;
    private int columnasAsientos;
    private boolean[][] asientosAsignados;
    private Pelicula peliculaReproducida;
    private double precioEntrada;

    //  CONSTRUCTORES
    public Sala() {
        this.filasAsientos = 0;
        this.columnasAsientos = 0;
        asientosAsignados = new boolean[0][0];
        this.peliculaReproducida = new Pelicula();
        this.precioEntrada = 0.0;
    }

    public Sala(int filas, int columnas, Pelicula pelicula, double precio) {
        this.filasAsientos = filas;
        this.columnasAsientos = columnas;
        asientosAsignados = new boolean[filas][columnas];
        this.peliculaReproducida = pelicula;
        this.precioEntrada = precio;
    }

    //  METODOS
    public int getFilas() {
        return filasAsientos;
    }

    public void setFilas(int filas) {
        this.filasAsientos = filas;
    }

    public int getColumnas() {
        return columnasAsientos;
    }

    public void setColumnas(int columnas) {
        this.columnasAsientos = columnas;
    }

    public Pelicula getPelicula() {
        return peliculaReproducida;
    }

    public void setPelicula(Pelicula pelicula) {
        this.peliculaReproducida = pelicula;
    }

    public double getPrecio() {
        return precioEntrada;
    }

    public void setPrecio(double precio) {
        this.precioEntrada = precio;
    }

    public String asignarAsiento(Espectador espectador, ArrayList<Espectador> espectadores, HashMap<String, Espectador> espectador_asiento, ArrayList<String> posicionAsientos) {
        Random numAleatorio = new Random();
        String texto = "";
        boolean repetir = true;
        while (repetir) {
            int numFila = numAleatorio.nextInt(filasAsientos);
            int numColumna = numAleatorio.nextInt(columnasAsientos);
            if (espectadores.size()>(filasAsientos*columnasAsientos)) {
                texto = "La capacidad de la sala es menor a la cantidad de espectadores.\n Capacidad de la sala: " + (filasAsientos*columnasAsientos) + "\n Número de espectadores: " + espectadores.size();
                repetir = false;
            } else if (!asientosAsignados[numFila][numColumna]) {
                int letraASCII = 64 + (numColumna + 1);
                posicionAsientos.add(String.valueOf(numFila + 1) + String.valueOf((char) letraASCII));
                texto = "\"" + espectador.getNombre()+"\" irá en el asiento "+(numFila + 1)+String.valueOf((char) letraASCII) + "\n";
                espectador_asiento.put(String.valueOf(numFila + 1) + String.valueOf((char) letraASCII), espectador);
                asientosAsignados[numFila][numColumna] = true;
                repetir = false;
            }
        }
        return texto;
    }

    public String puedeEntrar(Espectador espectador) {
        if (espectador.getEdad() < peliculaReproducida.getEdad_Minima()) {
            return "edad";
        } else if (espectador.getDinero() < precioEntrada) {
            return "dinero";
        } else {
            return "si";
        }
    }
}
