import java.util.Scanner;

public class T5Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            System.out.println("Que dia es hoy?");
        
        String respuesta = sc.nextLine();
        sc.close();
        
        String dia = respuesta.toLowerCase();

            switch (dia) {
                case "lunes":
                    System.out.println("Este día te toca trabajar listillo - dia laboral");
                    break;
                case "martes":
                    System.out.println("Este día te toca trabajar listillo - dia laboral");
                    break;
                case "miercoles":
                    System.out.println("Este día te toca trabajar listillo - dia laboral");
                    break;
                case "jueves":
                    System.out.println("Este día te toca trabajar listillo - dia laboral");
                    break;
                case "viernes":
                    System.out.println("Este día te toca trabajar listillo - dia laboral");
                    break;
                case "sabado":
                    System.out.println("Hoy a disfrutar como un señor - dia festivo");
                    break;
                case "domingo":
                    System.out.println("Hoy a disfrutar como un señor - dia festivo");
                    break;
                default:
                    System.out.println("-- Escribe un dia de la semana --");
            }
    } 
}