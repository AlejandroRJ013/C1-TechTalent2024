import java.text.*;
import java.util.*;

public class electrodosMain {
    public static void main(String[] args) {
        DecimalFormat formateo = new DecimalFormat("0.00");
        Television television1 = new Television(120.20, 12.5, "negro", 'D', 22, true);
        Television television2 = new Television(250.0, 15.0, "blanco", 'A', 32, false);
        Television television3 = new Television(400.50, 18.7, "rojo", 'C', 42, true);
        Television television4 = new Television(699.99, 20.2, "azul", 'B', 50, false);
        Television television5 = new Television(899.95, 25.0, "gris", 'E', 55, true);

        Lavadora lavadora1 = new Lavadora(8, 299.99, 45.0, "azul", 'A');
        Lavadora lavadora2 = new Lavadora(7, 199.0, 40.0, "rojo", 'B');
        Lavadora lavadora3 = new Lavadora(9, 399.50, 50.5, "gris", 'C');
        Lavadora lavadora4 = new Lavadora(6, 499.99, 55.2, "negro", 'D');
        Lavadora lavadora5 = new Lavadora(10, 599.95, 60.0, "blanco", 'E');

        ArrayList<Object> electrodomesticos = new ArrayList<>();
        electrodomesticos.addAll(List.of(television1, television2, television3, television4, television5, lavadora1, lavadora2, lavadora3, lavadora4, lavadora5));

        double precioElectrodomesticos = 0.0;
        double precioLavadoras = 0.0;
        double precioTelevisiones = 0.0;
        for (Object electrodo : electrodomesticos) {
            if (electrodo instanceof Television) {
                Television tele = (Television) electrodo;
                precioTelevisiones += tele.precioFinal();
                precioElectrodomesticos += tele.precioFinal();
            } else {
                Lavadora lava = (Lavadora) electrodo;
                precioLavadoras += lava.precioFinal();
                precioElectrodomesticos += lava.precioFinal();
            }
        }

        System.out.println("Precio de las lavadoras:\t"+formateo.format(precioLavadoras)+"€\nPrecio de los televisores:\t"+formateo.format(precioTelevisiones)+"€\nPrecio total electrodomésticos:\t"+formateo.format(precioElectrodomesticos)+"€");
    }
}