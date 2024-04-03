public class Aula {
    //  ATRIBUTOS
    private int id;
    private int numMaxEstudiantes;
    private String materiaAula;
    private final String[] materiaOpciones = {"Sin seleccionar", "matematicas", "filosofia", "fisica"};
    private boolean sePuedeDarClase;

    //  CONSTRUCTORES
    public Aula() {
        this.id = 0;
        this.numMaxEstudiantes = 0;
        this.materiaAula = materiaOpciones[0];
        this.sePuedeDarClase = false;
    }

    public Aula(int id, int numMaxEstudiantes, String materiaAula, int estudiantesEnClase, Profesores profesor) {
        this.id = id;
        this.numMaxEstudiantes = numMaxEstudiantes;
        
        //materia
        for (int i = 0; i <= 3; i++) {
            if (materiaAula.equals(materiaOpciones[i])) {
                this.materiaAula = materiaOpciones[i];
                break;
            } else {
                this.materiaAula = materiaOpciones[0];
            }
        }
        
        this.sePuedeDarClase = posibilidadDeDarClase(estudiantesEnClase, profesor);
    }

    //  METODOS
    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
    
    public void setNumMaxEstudiantes(int numMaxEstudiantes) {
        this.numMaxEstudiantes = numMaxEstudiantes;
    }
    public int getNumMaxEstudiantes() {
        return numMaxEstudiantes;
    }

    public void setMateriaAula(String materiaAula) {
        this.materiaAula = materiaAula;
    }

    public String getMateriaAula() {
        return materiaAula;
    }

    public boolean sePuedeDarClase() {
        return sePuedeDarClase;
    }

    public boolean posibilidadDeDarClase(int estudiantesEnClase, Profesores profesor) {
        if (!profesor.getMateria().equals(materiaAula)) {
            System.out.println("Materia profesor: " + profesor.getMateria() + "\nMateria aula: " + materiaAula + "\n");
            return false;
        } else if (profesor.getAusencia()) {
            System.out.println("Profesor ausente\n");
            return false;
        } else if (estudiantesEnClase < (numMaxEstudiantes / 2)) {
            System.out.println("Cantidad de alumnos insuficientes.\nAlumnos asignados al aula: " + numMaxEstudiantes + "\nAlumnos en el aula: " + estudiantesEnClase + "\nMínimo requerido: " + (numMaxEstudiantes / 2) + "\n");
            return false;
        } else {
            return true;
        }
    }
}
