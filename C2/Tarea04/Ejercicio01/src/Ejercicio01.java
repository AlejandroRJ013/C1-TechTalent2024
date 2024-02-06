public class Ejercicio01 {
    
    public static void main(String[] args) {
    	//COLORES
        String morado = "\033[35m";
        String verde = "\033[32m";
        String azul = "\033[34m";
        String rojo = "\033[31m";
        String naranja = "\u001B[33m";
        String amarillo = "\033[33m";
        String reset = "\u001B[0m";

        //Ejercicio01
    	int valor1=48, valor2=3;
		int sumar=valor1+valor2;
		int restar=valor1-valor2;
		int multiplicar=valor1*valor2;
		int dividir=valor1/valor2;
		int modulos=valor1%valor2;
		String val1=morado+valor1+reset, val2=verde+valor2+reset;
		String suma=azul+sumar+reset, resta=rojo+restar+reset, multi=naranja+multiplicar+reset;
		String divi=amarillo+dividir+reset, modulo=amarillo+modulos+reset;
		
		System.out.println("El valor asignado al primer numero es: "+val1);
		System.out.println("El valor asignado al segundo numero es: "+val2+"\n");
		
		System.out.println("La suma de los valores:"+val1+" más "+val2+" es igual a: "+suma);
		System.out.println("La resta de los valores:"+val1+" menos "+val2+" es igual a: "+resta);
		System.out.println("La división de los valores:"+val1+" entre "+val2+" es igual a: "+multi);
		System.out.println("La multipicación de los valores:"+val1+" por "+val2+" es igual a: "+divi+" con resto "+modulo);
    }
}