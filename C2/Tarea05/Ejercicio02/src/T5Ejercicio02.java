import java.util.Scanner;

public class T5Ejercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("EL MEJOR DROMEDARIO ;)");
        System.out.println("¿Cual es tu nombre?");
        String name = sc.nextLine();
        sc.close();
        System.out.println("¡Oh!, encantado " + "\033[34m" + name.toUpperCase() + "\u001B[0m"
                + ". Esperamos verte mucho por aquí");
    }
}