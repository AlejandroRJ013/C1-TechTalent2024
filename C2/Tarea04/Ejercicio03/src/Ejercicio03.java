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
    	int X1 =(55) , Y1 =(71);
        double N1 =(25.25) , M1 =(33.14);
        
        //Definiremos las acciones de sumar, restar, etc.
        int isumar= X1+Y1, irestar=X1-Y1, imultiplicar=X1*Y1, idividir=X1/Y1, imodulos=X1%Y1, xdobles=X1*2, ydobles=Y1*2;
        double dsumar= N1+M1, drestar=N1-M1, dmultiplicar=N1*M1, ddividir=N1/M1, dmodulos=N1%M1, ndobles=N1*2, mdobles=M1*2;
        double supersuma=X1+Y1+N1+M1, supermulti=X1*Y1*N1*M1;
        
        //Numeros con colores ;)
        String X=morado+X1+reset, Y=verde+Y1+reset, N=azul+N1+reset, M=rojo+M1+reset;
        String isuma=naranja+isumar+reset, iresta=naranja+irestar+reset, imulti=amarillo+imultiplicar+reset, idivi=amarillo+idividir+reset, imodulo=amarillo+imodulos+reset;
        String dsuma=naranja+dsumar+reset, dresta=naranja+drestar+reset, dmulti=amarillo+dmultiplicar+reset, ddivi=amarillo+ddividir+reset, dmodulo=amarillo+dmodulos+reset;        
        String xdoble=morado+xdobles+reset, ydoble=verde+ydobles+reset, ndoble=azul+ndobles+reset, mdoble=rojo+mdobles+reset, supsuma=naranja+supersuma+reset, supmulti=amarillo+supermulti+reset;
        
        System.out.println("Los valores asignados han sido los siguientes:");
        System.out.println("para X="+X+", para Y="+Y+", para N="+N+" y para M="+M);
        
        System.out.println("Numeros enteros");
        System.out.println("La suma entre "+X+" y "+Y+" es igual= "+isuma);
        System.out.println("La resta entre "+X+" y "+Y+" es igual= "+iresta);
        System.out.println("La multiplicación entre "+X+" y "+Y+" es igual= "+imulti);
        System.out.println("La división entre "+X+" y "+Y+" es igual= "+idivi+". Con resto: "+imodulo);

        System.out.println("Numeros reales");
        System.out.println("La suma entre "+N+" y "+M+" es igual= "+dsuma);
        System.out.println("La resta entre "+N+" y "+M+" es igual= "+dresta);
        System.out.println("La multiplicación entre "+N+" y "+M+" es igual= "+dmulti);
        System.out.println("La división entre "+N+" y "+M+" es igual= "+ddivi+". Con resto: "+dmodulo);

        System.out.println("El doble del valor "+X+" es igual a= "+xdoble);
        System.out.println("El doble del valor "+Y+" es igual a= "+ydoble);
        System.out.println("El doble del valor "+N+" es igual a= "+ndoble);
        System.out.println("El doble del valor "+M+" es igual a= "+mdoble);

        System.out.println("La suma de todas las variables es: "+supsuma);
        System.out.println("La multiplicación de todas las variables es: "+supmulti);
    }
}