public class Lavadora extends Electrodomestico{
    //  ATRIBUTO
    private double carga;
    private final double CARGA_PREDETERMINADA = 5;

    //  CONSTRUCTORES
    public Lavadora() {
    	this.precio=PRECIO_PREDETERMINADO;
    	this.peso=PESO_PREDETERMINADO;
    	this.color=COLOR_PREDETERMINADO;
    	this.consumo=CONSUMO_PREDETERMINADO;
    	this.carga =CARGA_PREDETERMINADA;
    }

    public Lavadora(double precio, double peso) {
    	this.precio=precio;
    	this.peso=peso;
    	this.color=COLOR_PREDETERMINADO;
    	this.consumo=CONSUMO_PREDETERMINADO;
    	this.carga =CARGA_PREDETERMINADA;
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


    public static void main(String[] args) {
        Lavadora lav = new Lavadora(50, 5.2, 4, "rojo", 'f');
        System.out.println(lav.toString());
    }
}