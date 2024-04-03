import java.util.*;

public class Videojuego implements Entregable {
    //  ATRIBUTOS
    private String titulo;
    private final String TITULO_PRED = "";
    private int horas_estimadas;
    private final int HORAS_PRED = 10;
    private boolean entregado;
    private final boolean ENTREGA_PRED = false;
    private String genero;
    private final String GENERO_PRED = "";
    private String compania;
    private final String COMPANIA_PRED = "";

    //  CONSTRUCTORES
    public Videojuego() {
        this.titulo = TITULO_PRED;
        this.horas_estimadas = HORAS_PRED;
        this.entregado = ENTREGA_PRED;
        this.genero = GENERO_PRED;
        this.compania = COMPANIA_PRED;
    }

    public Videojuego(String titulo,  int horas_estimadas) {
        this.titulo = titulo;
        this.horas_estimadas = horas_estimadas;
        this.entregado = ENTREGA_PRED;
        this.genero = GENERO_PRED;
        this.compania = COMPANIA_PRED;
    }

    public Videojuego(String titulo,  int horas_estimadas, String genero, String compania) {
        this.titulo = titulo;
        this.horas_estimadas = horas_estimadas;
        this.entregado = ENTREGA_PRED;
        this.genero = genero;
        this.compania = compania;
    }

    //  METODOS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHoras() {
        return horas_estimadas;
    }

    public void setHoras(int horas) {
        this.horas_estimadas = horas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    @Override
    public String toString() {
        return "  -   Juego\n\t{" +
                "titulo= '" + titulo + '\'' +
                ", horas estimadas= '" + 
                horas_estimadas + " horas"+'\'' +
                ", entregado= '" + entregado + '\'' +
                ", genero= '" + genero + '\'' +
                ", compañia= '" + compania + '\'' +
                '}';
    }

    public String masHorasToString() {
        return " El juego con mayor cantidad de " +
        "horas es:\n\t'" + titulo + "' con un promedio " +
        " de horas de --> '" + horas_estimadas + "'";
    }

    @Override
    public void entregado() {
        this.entregado = true;
    }

    @Override
    public void devolver() {
        this.entregado = false;
    }

    @Override
    public boolean estaEntregado() {
        return entregado;
    }

    @Override
    public Videojuego comparativa(ArrayList<Object> Juegos_Series) {
        Videojuego juego = new Videojuego();
        int horasMaximas = 0;
        for (Object o : Juegos_Series) {
            if (o instanceof Videojuego) {
                Videojuego jogoBonito = (Videojuego) o;
                if (jogoBonito.getHoras() > horasMaximas) {
                    horasMaximas = jogoBonito.getHoras();
                    juego = jogoBonito;
                }
            }
        }
        return juego;
    }

    public static void main(String[] args) {
        Videojuego juego1 = new Videojuego();
        Videojuego juego2 = new Videojuego("Red Dead Redemption 2", 60);
        Videojuego juego3 = new Videojuego("Hollow Knight", 28, "Metroidvania", "Team Cherry");

        System.out.println(juego1.toString());
        System.out.println(juego2.toString());
        System.out.println(juego3.toString());
    }
}