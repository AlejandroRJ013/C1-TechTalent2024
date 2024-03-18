import javax.swing.JOptionPane;

    //preguntar que significa que se puedan heredar
public class Electrodomestico {
    // ATRIBUTOS
    double precio;
    final double PRECIO_PRED = 100;
    double peso;
    final double PESO_PRED = 5;
    String color;
    final String blanco = "blanco";
    final String negro = "negro";
    final String rojo = "rojo";
    final String azul = "azul";
    final String gris = "gris";
    String[] opcionesColores = {"blanco", "negro", 
                          "rojo", "azul", "gris"};
    String consumo;
    final String CONSUMO_A = "A";
    final String CONSUMO_B = "B";
    final String CONSUMO_C = "C";
    final String CONSUMO_D = "D";
    final String CONSUMO_E = "E";
    final String CONSUMO_F = "F";
    String[] opcionesConsumos = {"A", "B", "C", 
                                "D", "E", "F"};


    // CONSTRUCTORES
    public Electrodomestico() {
        this.precio = PRECIO_PRED;
        this.peso = PESO_PRED;
        this.color = blanco;
        this.consumo = CONSUMO_F;
    }

    public Electrodomestico(double precio, double peso) {
        this.precio = precio;
        this.peso = peso;
        this.color = blanco;
        this.consumo = CONSUMO_F;
    }

    public Electrodomestico(double precio, double peso, String color, String consumo) {
        this.precio = precio;
        this.peso = peso;
        boolean mal = false;
        for (int i = 0; i < opcionesColores.length; i++) {
            if (opcionesColores[i].equals(color.toLowerCase())) {
                this.color = color;
                mal = false;
                break;
            } else {
                mal = true;
            }
        }
        if (mal) {
            JOptionPane.showMessageDialog(null,
                        "Los colores disponibles son:\n- Blanco\n- Negro\n- Rojo"+
                        "\n- Azul\n- Gris", "Opciones colores",
                        JOptionPane.INFORMATION_MESSAGE);
                this.color = blanco;
        }
        
        for (int i = 0; i < opcionesConsumos.length; i++) {
            if (opcionesConsumos[i].equals(consumo.toUpperCase())) {
                this.consumo = consumo;
                mal = false;
                break;
            } else {
                mal = true;
            }
        }
        if (mal) {
            JOptionPane.showMessageDialog(null,
                        "Los tipos de consumo de energia disponibles son:"+
                        "\n- A\n- B\n- C\n- D\n- E\n- F",
                        "Opciones colores", JOptionPane.INFORMATION_MESSAGE);
                this.consumo = CONSUMO_F;
        }
    }

    // METODOS
    @Override
    public String toString() {
        return "    Electrodomestico\n\t{" +
                "precio='" + precio + "€" + '\'' +
                ", peso=" + peso + "kg" + '\'' +
                ", color=" + color + '\'' +
                ", consumo=" + consumo + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Electrodomestico elec1 = new Electrodomestico();
        Electrodomestico elec2 = new Electrodomestico(12.5, 10);
        Electrodomestico elec3 = new Electrodomestico(21.6, 34, 
                                                 "rojo", "B");

        System.out.println(elec1.toString() + "\n" + elec2.toString() + "\n" + elec3.toString());
    }
}
