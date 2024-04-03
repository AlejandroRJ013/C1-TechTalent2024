public class Television extends Electrodomestico{
    //  ATRIBUTOS
    private double resolucion;
    private final double RESOLUCION_PREDETERMINADA = 20;
    private boolean sintonizador;
    private final boolean SINTONIZADOR_PREDETERMINADO = false;

    //  CONSTRUCTORES
    public Television() {
        super();

        this.resolucion = RESOLUCION_PREDETERMINADA;
        this.sintonizador = SINTONIZADOR_PREDETERMINADO;
    }

    public Television(double precio, double peso) {
        super(precio, peso);

        this.resolucion = RESOLUCION_PREDETERMINADA;
        this.sintonizador = SINTONIZADOR_PREDETERMINADO;
    }

    public Television(double precio, double peso, String color, char consumo, double resolucion, boolean sintonizador) {
        super(precio, peso, color, consumo);

        this.resolucion = resolucion;
        this.sintonizador = sintonizador;
    }

    //  METODOS
    public double getResolucion() {
        return resolucion;
    }

    public boolean getSintonizador() {
        return sintonizador;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (resolucion > 40) {
            precioFinal += precio * 0.30;
        }

        if (sintonizador == true) {
            precioFinal += 50;
        }

        return precioFinal;
    }

    @Override
    public String toString() {
        return "Television:\n\tPrecio base: " + precio + " €\n\tColor: " + color + "\n\tConsumo energético: " + consumo + "\n\tPeso: " + peso + " kg\n\tResolución: " + resolucion + "\n\tSintonización TDT: " + sintonizador + "\n    Precio final: " + precioFinal();
    }

    public static void main(String[] args) {
        Television tele = new Television(100, 5, "negro", 'F', 50, true);
        System.out.println(tele.toString());
    }
}