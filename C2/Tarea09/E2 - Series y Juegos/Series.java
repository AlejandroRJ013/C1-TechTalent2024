import java.util.*;

public class Series implements Entregable {
    // ATRIBUTOS
    private String titulo;
    private final String TITULO_PRED = "";
    private int temporadas;
    private final int TEMP_PRED = 3;
    private boolean entregado;
    private final boolean ENTREGA_PRED = false;
    private String genero;
    private final String GENERO_PRED = "";
    private String autor;
    private final String AUTOR_PRED = "";

    // CONSTRUCTORES
    public Series() {
        this.titulo = TITULO_PRED;
        this.temporadas = TEMP_PRED;
        this.entregado = ENTREGA_PRED;
        this.genero = GENERO_PRED;
        this.autor = AUTOR_PRED;
    }

    public Series(String titulo, String autor) {
        this.titulo = titulo;
        this.temporadas = TEMP_PRED;
        this.entregado = ENTREGA_PRED;
        this.genero = GENERO_PRED;
        this.autor = autor;
    }

    public Series(String titulo, int temporadas, String genero, String autor) {
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.entregado = ENTREGA_PRED;
        this.genero = genero;
        this.autor = autor;
    }

    // METODOS
    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporada(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "  -   Serie\n\t{" +
                "titulo='" + titulo + '\'' +
                ", temporadas=" + temporadas + '\'' +
                ", entregado=" + entregado + '\'' +
                ", genero=" + genero + '\'' +
                ", autor=" + autor + '\'' +
                '}';
    }

    public String masTemporadasToString() {
        return " La serie con mayor cantidad de " +
        "temporadas es:\n\t'" + titulo + "' con '" + 
        temporadas + "' temporadas.";
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
    public Series comparativa(ArrayList<Object> Juegos_Series) {
        Series serie = new Series();
        int temporadas = 0;
        for (Object o : Juegos_Series) {
            if (o instanceof Series) {
                Series serialKiller = (Series) o;
                if (serialKiller.getTemporadas() > temporadas) {
                    temporadas = serialKiller.getTemporadas();
                    serie = serialKiller;
                }
            }
        }
        return serie;
    }

    public static void main(String[] args) {
        Series serie1 = new Series();
        Series serie2 = new Series("Black Mirror", "Charlie Brooker");
        Series serie3 = new Series("Hunter x Hunter", 6, "anime", "Yoshihiro Togashi");

        System.out.println(serie1.toString() + "\n" + serie2.toString() + "\n" + serie3.toString());
    }
}