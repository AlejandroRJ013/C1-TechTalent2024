import java.util.*;

public class Profesores extends Personas {
    //  ATRIBUTOS
    private String materia;
    private final String[] materiaOpciones = {"Sin seleccionar", "matematicas", "filosofia", "fisica"};
    protected boolean ausente;

    //CONSTUCTORES
    public Profesores() {
        super();

        this.materia = materiaOpciones[0];
        this.ausente = false;
    }

    public Profesores(String nombre, int edad, String sexo, String materia) {
        super(nombre, edad, sexo);
        
        for (int i = 0; i <= 3; i++) {
            if (materia.equals(materiaOpciones[i])) {
                this.materia = materiaOpciones[i];
                break;
            } else {
                this.materia = materiaOpciones[0];
            }
        }

        this.ausente = falta();
    }

    // METODOS
    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setAusencia(boolean ausente) {
        this.ausente = ausente;
    }

    public boolean getAusencia() {
        return ausente;
    }

    @Override
    public boolean falta() {
        Random probabilidad = new Random();
        int numProbabilidad = probabilidad.nextInt(100) + 1;
        if (numProbabilidad <= 20) {
            return true;
        } else {
            return false;
        }
    }
}