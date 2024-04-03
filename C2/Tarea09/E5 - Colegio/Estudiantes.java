import java.util.*;

public class Estudiantes extends Personas {
    //  ATRIBUTOS
    private double nota;
    protected boolean ausente;

    // CONSTRUCTORES
    public Estudiantes() {
        super();

        this.nota = 0;
        this.ausente = false;
    }

    public Estudiantes(String nombre, int edad, String sexo, double nota) {
        super(nombre, edad, sexo);

        if (nota > 0 && nota < 10) {
            this.nota = nota;
        } else {
            this.nota = 0;
            System.out.println("La nota del alumno debe estar entre '0' y '10'");
        }
        this.ausente = falta();
    }

    //METODOS
    public void setAusencia(boolean ausente) {
        this.ausente = ausente;
    }

    public boolean getAusencia() {
        return ausente;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public static ArrayList<Estudiantes> alumnosAusentes(ArrayList<Estudiantes> estudiantes) {
        ArrayList<Estudiantes> ausentes = new ArrayList<>();
        for(Estudiantes estudiante : estudiantes) {
            if (estudiante.getAusencia()) {
                ausentes.add(estudiante);
            }
        }
        return ausentes;
    }

    public static int cantAlumnosEnClase(ArrayList<Estudiantes> estudiantes) {
        int cantidadEnClase = 0;
        for(Estudiantes estudiante : estudiantes) {
            if (!estudiante.getAusencia()) {
                cantidadEnClase++;
            }
        }
        return cantidadEnClase;
    }

    public static ArrayList<Estudiantes> alumnosAprobados(ArrayList<Estudiantes> estudiantes) {
        ArrayList<Estudiantes> aprobados = new ArrayList<>();
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getNota() >= 5) {
                aprobados.add(estudiante);
            }
        }
        return aprobados;
    }

    public static ArrayList<Estudiantes> alumnosNOAprobados(ArrayList<Estudiantes> estudiantes) {
        ArrayList<Estudiantes> suspendidos = new ArrayList<>();
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getNota() < 5) {
                suspendidos.add(estudiante);
            }
        }
        return suspendidos;
    }

    @Override
    public boolean falta() {
        Random probabilidad = new Random();
        int numProbabilidad = probabilidad.nextInt(100) + 1;
        if (numProbabilidad <= 50) {
            return true;
        } else {
            return false;
        }
    }
}