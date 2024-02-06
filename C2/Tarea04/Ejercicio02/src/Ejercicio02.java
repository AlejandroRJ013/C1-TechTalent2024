
public class Ejercicio02 {
    public static void main(String[] args){
        
    	//COLORES
        String morado = "\033[35m";
        String verde = "\033[32m";
        String azul = "\033[34m";
        String rojo = "\033[31m";
        String reset = "\u001B[0m";

        //Ejercicio02
    	int N1 = 8;
        double A1 = 12.05;
        char C1 = 'L';
        double Sumar = N1 + A1;
        double Diferenciar = A1 - N1;
        double ValNume = (int) C1;
        String N=morado+N1+reset, A=verde+A1+reset, C=rojo+C1+reset, Suma=azul+Sumar+reset, Diferencia=azul+Diferenciar+reset, ValNum=azul+ValNume+reset;
    	

        System.out.println("He definido a <N> como: " +N);
        System.out.println("He definido a <A> como: " +A);
        System.out.println("He definido a <C> como: " +C);

        System.out.println("El resultado de la suma de los valores asignados en N y A es: "+Suma);
        
        System.out.println("El resultado de la diferencia entre los valores asignados en N y A es: "+Diferencia);
        
        System.out.println("El valor numerico asignado por el codigo ASCII a C es: "+ValNum);
    }
}