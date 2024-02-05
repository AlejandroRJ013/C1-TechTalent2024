
public class Ejercicio02 {
    public static void main(String[] args){
        
    	//COLORES
        String morado = "\033[35m";
        String verde = "\033[32m";
        String azul = "\033[34m";
        String rojo = "\033[31m";
        String reset = "\u001B[0m";

        //Ejercicio02
    	int N = 8;
        double A = 12.05;
        char C = 'L';

        System.out.println("He definido a <N> como: " +morado+N+reset);
        System.out.println("He definido a <A> como: " +verde+A+reset);
        System.out.println("He definido a <C> como: " +rojo+C+reset);

        double Suma = N + A;
        System.out.println("El resultado de la suma de los valores asignados en N y A es: "+azul+Suma+reset);
        double Diferencia = A - N;
        System.out.println("El resultado de la diferencia entre los valores asignados en N y A es: "+azul+Diferencia+reset);
        double ValNum = (int) C;
        System.out.println("El valor numerico asignado por el codigo ASCII a C es: "+azul+ValNum+reset);
    }
}