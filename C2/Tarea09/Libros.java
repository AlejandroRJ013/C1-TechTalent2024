import java.lang.annotation.Retention;
import java.text.DecimalFormat;
import java.time.InstantSource;

import javax.swing.JOptionPane;

public class Libros {
    //  ATRIBUTOS
    private Long ISBN;
    private final DecimalFormat formatoISBN10 = new DecimalFormat("0-000-00000-0");
    private final DecimalFormat formatoISBN13 = new DecimalFormat("000-0-000-00000-0");
    private String titulo;
    private String autor;
    private int paginas;

    //   CONSTRUCTORES
    public Libros() {
        this.ISBN = 0L;
        this.titulo = "";
        this.autor = "";
        this.paginas = 0;
    }

    public Libros(Long ISBN, String titulo, String autor, int paginas, boolean error) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    //  METODOS
    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setPaginas(int pagina) {
        this.paginas = pagina;
    }

    public int getPaginas() {
        return paginas;
    }

    @Override
    public String toString() {
        return "El libro <" + titulo + "> con ISBN : '" + ISBN + "' creado por " + autor + " tiene "+paginas;
    }

    public static void main(String[] args) {
        Libros libro1 = new Libros(9788408284550L, "Alas de sangre", "Rebecca Yarros", 896, false);
        Libros libro2 = new Libros(9788496735712L, "Wonder", "R.J. PALACIO", 424, false);

        System.out.println(libro1.toString());
        System.out.println(libro2.toString());

        if (libro1.getPaginas() > libro2.getPaginas()) {
            System.out.println("El libro con mayor cantidad de páginas es el primero con " + libro1.getPaginas() + "páginas, el segundo "+ libro2.getPaginas());
        }
    }
}