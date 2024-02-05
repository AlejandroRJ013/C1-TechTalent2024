public class Ejercicio03 {
    public static void main(String[] args){
        
    	//COLORES
        String morado = "\033[35m";
        String verde = "\033[32m";
        String azul = "\033[34m";
        String rojo = "\033[31m";
        String naranja = "\u001B[33m";
        String amarillo = "\033[33m";
        String reset = "\u001B[0m";
        
        //Ejercicio03
    	int X =(55) , Y =(71);
        double N =(25.25) , M =(33.14);

        System.out.println("Los valores asignados han sido los siguientes:");
        System.out.println("para X="+morado+X+reset+", para Y="+verde+Y+reset+", para N="+azul+N+reset+" y para M="+rojo+M+reset);
        
        //Definiremos las acciones de sumar, restar, etc.
        int isuma= X+Y, iresta=X-Y, imulti=X*Y, idivi=X/Y, imodulo=X%Y, xdoble=X*2, ydoble=Y*2;
        double dsuma= N+M, dresta=N-M, dmulti=N*M, ddivi=N/M, dmodulo=N%M, ndoble=N*2, mdoble=M*2;

        double supsuma=X+Y+N+M, supmulti=X*Y*N*M;

        System.out.println("Numeros enteros");
        System.out.println("La suma entre "+morado+X+reset+" y "+verde+Y+reset+" es igual= "+naranja+isuma+reset);
        System.out.println("La resta entre "+morado+X+reset+" y "+verde+Y+reset+" es igual= "+naranja+iresta+reset);
        System.out.println("La multiplicación entre "+morado+X+reset+" y "+verde+Y+reset+" es igual= "+amarillo+imulti+reset);
        System.out.println("La división entre "+morado+X+reset+" y "+verde+Y+reset+" es igual= "+amarillo+idivi+reset+". Con resto: "+amarillo+imodulo+reset);

        System.out.println("Numeros reales");
        System.out.println("La suma entre "+azul+N+reset+" y "+rojo+M+reset+" es igual= "+naranja+dsuma+reset);
        System.out.println("La resta entre "+azul+N+reset+" y "+rojo+M+reset+" es igual= "+naranja+dresta+reset);
        System.out.println("La multiplicación entre "+azul+N+reset+" y "+rojo+M+reset+" es igual= "+dmulti+reset);
        System.out.println("La división entre "+azul+N+reset+" y "+rojo+M+reset+" es igual= "+amarillo+ddivi+reset+". Con resto: "+amarillo+dmodulo+reset);

        System.out.println("El doble del valor "+morado+X+reset+" es igual a= "+morado+xdoble+reset);
        System.out.println("El doble del valor "+verde+Y+reset+" es igual a= "+verde+ydoble+reset);
        System.out.println("El doble del valor "+azul+N+reset+" es igual a= "+azul+ndoble+reset);
        System.out.println("El doble del valor "+rojo+M+reset+" es igual a= "+rojo+mdoble+reset);

        System.out.println("La suma de todas las variables es: "+naranja+supsuma+reset);
        System.out.println("La multiplicación de todas las variables es: "+amarillo+supmulti+reset);
    }
}