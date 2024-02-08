import java.util.Scanner;

public class T5Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de articulos: ");
        int articulos = sc.nextInt();
        double sumventas = 0.0;
        for (int i = 1; i <= articulos; i++) {
            System.out.println("Precio del artículo: ");
            String txtprecio = sc.next();
            txtprecio = txtprecio.replace(",", ".");
            double precio = Double.parseDouble(txtprecio);
            sumventas += precio;
        }
        System.out.println("La broma sale a: " + sumventas + "€");
        sc.close();
    }
}
