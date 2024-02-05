public class Ejercicio04 {
    public static void main(String[] args) {
        
    	//COLORES
        String morado = "\033[35m";
        String verde = "\033[32m";
        String azul = "\033[34m";
        String rojo = "\033[31m";
        String reset = "\u001B[0m";

        //Ejercicio04
        int N=63;
        System.out.println("El valor definido a N es = "+morado+N+reset);
        
        System.out.print("Al incrementar 77 valores a "+morado+N+reset);
        N=N+77;
        System.out.println(" da un igual de = "+verde+N+reset);

        System.out.print("Al decrementar 3 puntos al nuevo valor de N="+verde+N+reset);
        N=N-3;
        System.out.println(" da un igual de = "+azul+N+reset);
        
        System.out.print("El doble de "+azul+N+reset);
        N=N*2;
        System.out.println(" da un igual de = "+rojo+N+reset);
    }
}