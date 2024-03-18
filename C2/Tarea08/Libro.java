public class Libro {
    // ATRIBUTOS
    String titulo;
    String autor;
    int fechaEstreno;

    // CONSTRUCTORES
    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.fechaEstreno = 0;
    }

    public Libro(String titulo, String autor, int fechaEstreno) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaEstreno = fechaEstreno;
    }

    // METODOS
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

    public void setFecha(int fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public int getFecha() {
        return fechaEstreno;
    }

    public String toString() {
        return "  -  Libro:\n\t{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", Año de publicación=" + fechaEstreno + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Libro libro1 = new Libro("Hábitos atómicos", "James Clear", 2020);
        System.out.println(libro1.toString());
        libro1.setTitulo("Antimatéria, mágia y poesía");
        libro1.setAutor("José Edelstein y Andrés Gomberoff");
        libro1.setFecha(2021);
        System.out.println("\n" + libro1.getTitulo() + ", " + libro1.getAutor() + ", " + libro1.getFecha());

    }
}