public class Ejercicio01 {
    
    public static void main(String[] args) {
    	//COLORES
        String morado = "\033[35m";
        String verde = "\033[32m";
        String azul = "\033[34m";
        String rojo = "\033[31m";
        String reset = "\u001B[0m";

        //Ejercicio01
    	int val1=8 , val2=5;
		int suma=val1+val2;
		int resta=val1-val2;
		int multi=val1*val2;
		int divi=val1/val2;
		int modulo=val1%val2;
        
		System.out.println("El valor asignado al primer numero es: "+val1);
		System.out.println("El valor asignado al segundo numero es: "+val2+"\n");
		
		System.out.println("La suma de los valores:"+val1+" más "+val2+" es igual a: "+suma);
		System.out.println("La resta de los valores:"+val1+" menos "+val2+" es igual a: "+resta);
		System.out.println("La división de los valores:"+val1+" entre "+val2+" es igual a: "+multi);
		System.out.println("La multipicación de los valores:"+val1+" por "+val2+" es igual a: "+divi+"con resto"+modulo);
    }
}