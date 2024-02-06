public class T5Ejercicio09 {
    public static void main(String[] args) {
        int numero=0;
        String verde = "\033[32m";
        String azul = "\033[34m";
        String rojo = "\033[31m";
        String reset = "\u001B[0m";
        for(numero=1; numero<101; numero++) {
            if(numero%2==0){
                System.out.println("Divisible entre 2 "+verde+numero+reset);
            }else if(numero%3==0) {
                System.out.println("Divisible entre 3 "+azul+numero+reset);
            }else{
                System.out.println("Indivisible entre 2 o 3 "+rojo+numero+reset);
            }
        }
    }
}