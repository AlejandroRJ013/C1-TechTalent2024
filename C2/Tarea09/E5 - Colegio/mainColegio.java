import java.text.*;
import java.util.*;

public class mainColegio {
    public static void main(String[] args) {
        ArrayList<Estudiantes> estudiantes = new ArrayList<>();
        DecimalFormat formato = new DecimalFormat("0.00");
        Random nota = new Random();

        double nota1 = nota.nextDouble() * 10;
        Estudiantes estudiante1 = new Estudiantes("Juan", 15, "H", nota1);

        double nota2 = nota.nextDouble() * 10;
        Estudiantes estudiante2 = new Estudiantes("Elisabeth", 16, "M", nota2);

        double nota3 = nota.nextDouble() * 10;
        Estudiantes estudiante3 = new Estudiantes("Fran", 14, "H", nota3);

        double nota4 = nota.nextDouble() * 10;
        Estudiantes estudiante4 = new Estudiantes("Maria", 15, "M", nota4);

        double nota5 = nota.nextDouble() * 10;
        Estudiantes estudiante5 = new Estudiantes("Pedro", 16, "H", nota5);

        double nota6 = nota.nextDouble() * 10;
        Estudiantes estudiante6 = new Estudiantes("Laura", 14, "M", nota6);

        double nota7 = nota.nextDouble() * 10;
        Estudiantes estudiante7 = new Estudiantes("Carlos", 15, "H", nota7);

        double nota8 = nota.nextDouble() * 10;
        Estudiantes estudiante8 = new Estudiantes("Ana", 16, "M", nota8);

        double nota9 = nota.nextDouble() * 10;
        Estudiantes estudiante9 = new Estudiantes("Pablo", 14, "H", nota9);

        double nota10 = nota.nextDouble() * 10;
        Estudiantes estudiante10 = new Estudiantes("Elena", 15, "M", nota10);

        double nota11 = nota.nextDouble() * 10;
        Estudiantes estudiante11 = new Estudiantes("Diego", 16, "H", nota11);

        double nota12 = nota.nextDouble() * 10;
        Estudiantes estudiante12 = new Estudiantes("Sara", 14, "M", nota12);

        double nota13 = nota.nextDouble() * 10;
        Estudiantes estudiante13 = new Estudiantes("Javier", 15, "H", nota13);

        double nota14 = nota.nextDouble() * 10;
        Estudiantes estudiante14 = new Estudiantes("Natalia", 16, "M", nota14);

        double nota15 = nota.nextDouble() * 10;
        Estudiantes estudiante15 = new Estudiantes("Luisa", 14, "M", nota15);
        
        estudiantes.addAll(Arrays.asList(estudiante1, estudiante2, estudiante3, estudiante4, estudiante5, estudiante6, estudiante7, estudiante8, estudiante9, estudiante10, estudiante11, estudiante12, estudiante13, estudiante14, estudiante15));

        Profesores profesor = new Profesores("Margarita", 42, "M", "filosofia");

        int cantidadEnClase = Estudiantes.cantAlumnosEnClase(estudiantes);
        ArrayList<Estudiantes> ausentes = Estudiantes.alumnosAusentes(estudiantes);
        ArrayList<Estudiantes> aprobados = Estudiantes.alumnosAprobados(estudiantes);
        ArrayList<Estudiantes> suspendidos = Estudiantes.alumnosNOAprobados(estudiantes);

        Aula aulaFilosofia = new Aula(1, estudiantes.size(), "filosofia", cantidadEnClase, profesor);

            if (aulaFilosofia.sePuedeDarClase()) {
                System.out.println("\t- - ALUMNOS MUJERES - -\n");
            for (Estudiantes estudiante : estudiantes) {
                if (estudiante.getSexo().equals("M")) {
                    System.out.println(estudiante.getNombre()+" es mujer.");
                }
            }
            System.out.println("\n");

            System.out.println("\t- - ALUMNOS HOMBRES - -\n");
            for (Estudiantes estudiante : estudiantes) {
                if (estudiante.getSexo().equals("H")) {
                    System.out.println(estudiante.getNombre()+" es hombre.");
                }
            }
            System.out.println("\n");
            
            System.out.println("\t- - ALUMNOS APROBADOS ["+aprobados.size()+"] - -\n");
            for (Estudiantes alumno : aprobados) {
                if (ausentes.contains(alumno)) {
                    System.out.println("¡AUSENTE! El alumno "+alumno.getNombre()+" está aprobado con un "+formato.format(alumno.getNota()));
                } else {
                    System.out.println("El alumno "+alumno.getNombre()+" está aprobado con un "+formato.format(alumno.getNota()));
                }
            }

            System.out.println("\n\t- - ALUMNOS SUSPENDIDOS ["+suspendidos.size()+"] - -\n");
            for (Estudiantes alumno : suspendidos) {
                if (ausentes.contains(alumno)) {
                    System.out.println("¡AUSENTE! El alumno "+alumno.getNombre()+" está suspendido con un "+formato.format(alumno.getNota()));
                } else {
                    System.out.println("El alumno "+alumno.getNombre()+" está suspendido con un "+formato.format(alumno.getNota()));
                }
            }

            System.out.println("\n\t- - ALUMNOS AUSENTES ["+ausentes.size()+"] - -\n");
            for (Estudiantes alumno : ausentes) {
                System.out.println("El alumno "+alumno.getNombre()+" está ausente");
            }

            System.out.println("\nSe puede dar clase");
        } else {
            System.out.println("No se puede dar clase");
        }
    }
}