public class Pelicula {
    //  ATRIBUTOS
    private String titulo;
    private String duracion;
    private int duracion_horas;
    private int duracion_minutos;
    private int duracion_segundos;
    private int edad_minima;
    private String director;

    //  CONSTRUCTORES
    public Pelicula() {
        this.titulo = "";
        this.duracion = "";
        this.duracion_horas = 0;
        this.duracion_minutos = 0;
        this.duracion_segundos = 0;
        this.edad_minima = 0;
        this.director = "";
    }

    public Pelicula(String titulo, String duracion, int edad_minima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        String[] duracionSeparado = duracion.split(":");
        if (duracionSeparado.length == 3) {
            this.duracion_horas = Integer.parseInt(duracionSeparado[0]);
            this.duracion_minutos = Integer.parseInt(duracionSeparado[1]);
            this.duracion_segundos = Integer.parseInt(duracionSeparado[2]);
        } else if (duracionSeparado.length == 2) {
            this.duracion_minutos = Integer.parseInt(duracionSeparado[0]);
            this.duracion_segundos = Integer.parseInt(duracionSeparado[1]);
        } else {
            this.duracion_minutos = Integer.parseInt(duracionSeparado[0]);
        }
        this.edad_minima = edad_minima;
        this.director = director;
    }

    //  METODOS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getDuracion_Horas() {
        return duracion_horas;
    }

    public void setDuracion_Horas(int horas) {
        this.duracion_horas = horas;
    }

    public int getDuracion_Minutos() {
        return duracion_minutos;
    }

    public void setDuracion_Minutos(int minutos) {
        this.duracion_minutos = minutos;
    }

    public int getDuracion_Segundos() {
        return duracion_segundos;
    }

    public void setDuracion_Segundos(int segundos) {
        this.duracion_segundos = segundos;
    }

    public int getEdad_Minima() {
        return edad_minima;
    }

    public void setEdad_Minima(int edad_minima) {
        this.edad_minima = edad_minima;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}