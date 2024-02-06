public class Ejercicio05 {
    public static void main(String[] args) {

        //COLORES
        String morado = "\033[35m";
        String verde = "\033[32m";
        String azul = "\033[34m";
        String rojo = "\033[31m";
        String reset = "\u001B[0m";

        //Ejercicio05
        int A=85, B=53, C=77, D=37;

        System.out.println("Valores iniciales: \n A="+morado+A+reset+"  "
        		+ " C="+verde+C+reset+"\n B="+azul+B+reset+"   D="+rojo+D+reset);

        B=C;
        C=A;
        A=D;
        D=B;

        System.out.println("Valores Después de la assignación: \n A="+morado+A+reset+"  "
        		+ " C="+verde+C+reset+"\n B="+azul+B+reset+"   D="+rojo+D+reset);
    }
}