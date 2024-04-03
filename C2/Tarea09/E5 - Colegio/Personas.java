public class Personas implements MetodosPersonas {
    //  ATRIBUTOS
    protected String nombre;
    protected int edad;
    protected String sexo;
    protected final String[] sexoOpciones = {"Sin seleccionar", "H", "M"};

    //  CONSTRUCTORES
    public Personas() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = sexoOpciones[0];
    }

    public Personas(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        if (sexo.equals(sexoOpciones[1])) {
            this.sexo = sexoOpciones[1];
        } else if (sexo.equals(sexoOpciones[2])) {
            this.sexo = sexoOpciones[2];
        } else {
            this.sexo = sexoOpciones[0];
            System.out.println("Opciones:  'H'  'M'");
        }
    }

    //  METODOS
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean falta() {
        return false;
    }
}