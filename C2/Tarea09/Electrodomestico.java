import java.util.*;

public class Electrodomestico {
    //  ATRIBUTOS
    protected double precio;
    protected static final double PRECIO_PREDETERMINADO = 100.0;

    protected String color;
    protected static final String COLOR_PREDETERMINADO = "blanco";
    protected static final List<String> COLORES_DISPONIBLES = Arrays.asList("negro", "rojo", "azul", "gris");

    protected char consumo;
    protected static final char CONSUMO_PREDETERMINADO = 'F';
    protected static final List<Character> CONSUMOS_DISPONIBLES = Arrays.asList('A', 'B', 'C', 'D', 'E');

    protected double peso;
    protected static final double PESO_PREDETERMINADO = 5;

    //  CONSTRUCTORES
    public Electrodomestico() {
        this(PRECIO_PREDETERMINADO, PESO_PREDETERMINADO, COLOR_PREDETERMINADO, CONSUMO_PREDETERMINADO);
    }

    public Electrodomestico(double precio, double peso) {
        this(precio, peso, COLOR_PREDETERMINADO, CONSUMO_PREDETERMINADO);
    }

    public Electrodomestico(double precio, double peso, String color, char consumo) {
        this.precio = precio;
        this.peso = peso;
        this.color = comprobarColor(color);
        this.consumo = comprobarLetraConsumo(consumo);
    }

    //  METODOS
    public double getPrecio() {
        return precio;
    }

    public double getPeso() {
        return peso;
    }

    public String getColor() {
        return color;
    }

    public Character getConsumo() {
        return consumo;
    }

    private String comprobarColor(String color) {
        color = color.toLowerCase();
        
        if (COLORES_DISPONIBLES.contains(color)) {
            return color;
        } else {
            return COLOR_PREDETERMINADO;
        }
    }

    private char comprobarLetraConsumo(char letraConsumo) {
        letraConsumo = Character.toUpperCase(letraConsumo);

        if (CONSUMOS_DISPONIBLES.contains(letraConsumo)) {
            return letraConsumo;
        } else {
            return CONSUMO_PREDETERMINADO;
        }
    }

    public double precioFinal() {
        double precioFinal = precio;

        if (peso >= 0 && peso < 20) {
            precioFinal += 10;
        } else if (peso < 50) {
            precioFinal += 50; 
        } else if (peso < 80) {
            precioFinal += 80;
        } else if  (peso >= 80) {
            precioFinal += 100;
        }

        switch(consumo) {
            case 'A':{
                precioFinal += 100;
                break;
            }

            case 'B':{
                precioFinal += 80;
                break;
            }

            case 'C':{
                precioFinal += 60;
                break;
            }

            case 'D':{
                precioFinal += 50;
                break;
            }

            case 'E':{
                precioFinal += 30;
                break;
            }

            default:{
                precioFinal += 10;
                break;
            }
        }

        return precioFinal;
    }

    @Override
    public String toString() {
        return "Artículo:\n\tPrecio base: " + precio + " €\n\tColor: " + color + "\n\tConsumo energético: " + consumo + "\n\tPeso: " + peso + " kg\n\tPrecio final: "+precioFinal();
    }

    public static void main(String[] args) {
        Electrodomestico lava = new Electrodomestico(120, 8, "azul", 'A');
        System.out.println(lava.toString());
    }
}