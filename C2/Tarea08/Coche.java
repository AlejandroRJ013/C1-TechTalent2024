public class Coche {
    // ATRIBUTOS
    String marca;
    String modelo;
    int fechaSalida;

    //CONSTRUCTORES
    public Coche() {
        this.marca = "";
        this.modelo = "";
        this.fechaSalida = 0;
    }

    public Coche(String marca, String modelo, int fechaSalida) {
        this.marca = marca;
        this.modelo = modelo;
        this.fechaSalida = fechaSalida;
    }
    

    //METODOS
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setFecha(int fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public int getFecha() {
        return fechaSalida;
    }

    public String toString() {
        return "  -  Coche:\n\t{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", Año de fabricación=" + fechaSalida + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Coche coche1 = new Coche("Mercedes", "Clase C", 1999);
        System.out.println(coche1.toString());
        coche1.setMarca("Renault");
        coche1.setModelo("Clio");
        coche1.setFecha(2005);
        System.out.println("\n"+coche1.getMarca()+", "+coche1.getModelo()+", "+coche1.getFecha());

    }
}