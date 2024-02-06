public class Ejercicio05prueba {
    public static void main(String[] args) {
        //COLORES
        String morado = "\033[35m";
        String verde = "\033[32m";
        String azul = "\033[34m";
        String rojo = "\033[31m";
        String reset = "\u001B[0m";
     
        int A=85, B=53, C=77, D=37;
        int sumatotal= (A+B+C+D);

        System.out.println("Valores iniciales: \n A="+morado+A+reset+"   "
        		+ "C="+verde+C+reset+"\n B="+azul+B+reset+"   D="+rojo+D+reset);
        
        System.out.println("Valores Después de la assignación: \n "
        		+ "A="+morado+(sumatotal-B-C-A)+reset+"   C="+verde+(sumatotal-B-C-D)+reset+"\n "
        		+ "B="+azul+(sumatotal-A-B-D)+reset+"    D="+rojo+(sumatotal-D-C-A)+reset);
    }
}