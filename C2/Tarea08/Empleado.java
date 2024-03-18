public class Empleado {
    // ATRIBUTOS
    String nombre;
    int edad;
    double salario;

    //CONSTRUCTORES
    public Empleado() {
        this.nombre = "";
        this.edad = 0;
        this.salario = 0.0;
    }

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    //METODOS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public double saliarioAnual() {
        return salario * 12;
    }

    public String toString() {
        return "  -  Empleado:\n\t{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", salario=" + salario + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Juan", 30, 1200);
        System.out.println(empleado1.toString());
        System.out.println(empleado1.saliarioAnual());
        empleado1.setNombre("Alfredo");
        empleado1.setEdad(20);
        empleado1.setSalario(1500);
        System.out.println("\n"+empleado1.getNombre()+", "+empleado1.getEdad()+", "+empleado1.getSalario());
        System.out.println(empleado1.saliarioAnual());
    }
}