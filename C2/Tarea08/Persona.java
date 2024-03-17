public class Persona {
    // ATRIBUTOS
    private String nombre;
    private int edad;
    private String sexo;
    public final String SEXO_HOMBRE = "H";
    private String dni;
    private double peso;
    private double altura;

    // CONTRUSCTORES
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = SEXO_HOMBRE;
        this.peso = 0.0;
        this.altura = 0.0;
    }

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = 0.0;
        this.altura = 0.0;
    }

    public Persona(String nombre, int edad, String sexo,
            String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    // METODOS
    @Override
    public String toString() {
        return "  -  Persona:\n\t{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", sexo=" + sexo + '\'' +
                ", dni=" + dni + '\'' +
                ", peso=" + peso + "kg" + '\'' +
                ", altura=" + altura + "m" + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Marissa", 21, "M");
        Persona persona3 = new Persona("Alfredo", 32, "H", "39256249J", 75.2, 1.78);

        System.out.println(persona1.toString() + "\n" + persona2.toString() + "\n" + persona3.toString());
    }
}