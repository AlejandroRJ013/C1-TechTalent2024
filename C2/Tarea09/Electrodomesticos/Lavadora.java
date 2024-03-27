public class Lavadora extends Electrodomestico{
    //  ATRIBUTO
    private double carga;
    private final double CARGA_PREDETERMINADA = 5;

    //  CONSTRUCTORES
    public Lavadora() {
        super();

    	this.carga = CARGA_PREDETERMINADA;
    }

    public Lavadora(double precio, double peso) {
        super(precio, peso);

    	this.carga = CARGA_PREDETERMINADA;
    }

    public Lavadora(double carga, double precio, double peso, String color, char consumo) {
        super(precio, peso, color, consumo);
        this.carga = carga;
    }

    //  METODOS
    public double getCarga() {
        return carga;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (carga > 30) {
            precioFinal += 50;
        }

        return precioFinal;
    }

    public String toString() {
        return "Lavadora:\n\tPrecio base: " + precio + " €\n\tColor: " + color + "\n\tConsumo energético: " + consumo + "\n\tPeso: " + peso + " kg\n\tCarga: "+carga+"\n    Precio final: "+precioFinal();
    }

    public static void main(String[] args) {
        Lavadora lav = new Lavadora(50, 5.2, 4, "rojo", 'f');
        System.out.println(lav.toString());
    }
}