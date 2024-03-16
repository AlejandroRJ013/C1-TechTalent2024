public class Serie {
    // ATRIBUTOS
    String titulo;
    final String TITULO_PRED = "";
    int temporadas;
    final int TEMP_PRED = 3;
    boolean entregado;
    final boolean ENTREGA_PRED = false;
    String genero;
    final String GENERO_PRED = "";
    String autor;
    final String AUTOR_PRED = "";

    // CONSTRUCTORES
    public Serie() {
        this.titulo = TITULO_PRED;
        this.temporadas = TEMP_PRED;
        this.entregado = ENTREGA_PRED;
        this.genero = GENERO_PRED;
        this.autor = AUTOR_PRED;
    }

    public Serie(String titulo, String autor) {
        this.titulo = titulo;
        this.temporadas = TEMP_PRED;
        this.entregado = ENTREGA_PRED;
        this.genero = GENERO_PRED;
        this.autor = autor;
    }

    public Serie(String titulo, int temporadas, String genero, String autor) {
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.entregado = ENTREGA_PRED;
        this.genero = genero;
        this.autor = autor;
    }

    // METODOS
    @Override
    public String toString() {
        return "Electrodomestico\t{" +
                "titulo='" + titulo + '\'' +
                ", temporadas=" + temporadas + '\'' +
                ", entregado=" + entregado + '\'' +
                ", genero=" + genero + '\'' +
                ", autor=" + autor + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Serie serie1 = new Serie();
        Serie serie2 = new Serie("Black Mirror", "Charlie Brooker");
        Serie serie3 = new Serie("Hunter x Hunter", 6, "anime", "Yoshihiro Togashi");

        System.out.println(serie1.toString() + "\n" + serie2.toString() + "\n" + serie3.toString());
    }
}
