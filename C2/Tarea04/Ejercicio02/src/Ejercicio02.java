
public class Ejercicio02 {
    public static void main(String[] args){
        int N = 8;
        double A = 12.05;
        char C = 'L';

        System.out.println("He definido a <N> como: " + N);
        System.out.println("He definido a <A> como: " + A);
        System.out.println("He definido a <C> como: " + C);

        double Suma = N + A;
        System.out.println("El resultado de la suma de los valores asignados en N y A es: "+Suma);
        double Diferencia = A - N;
        System.out.println("El resultado de la diferencia entre los valores asignados en N y A es: "+Diferencia);
        double ValNum = (int) C;
        System.out.println("El valor numerico asignado por el codigo ASCII a C es: "+ValNum);
    }
}