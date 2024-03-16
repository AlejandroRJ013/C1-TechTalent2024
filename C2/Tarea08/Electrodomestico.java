import javax.swing.JOptionPane;

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
    String consumo;
    final String CONSUMO_A = "A";
    final String CONSUMO_B = "B";
    final String CONSUMO_C = "C";
    final String CONSUMO_D = "D";
    final String CONSUMO_E = "E";
    final String CONSUMO_F = "F";

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
        if (color.equals(blanco) || color.equals(negro) || color.equals(rojo) || color.equals(azul)
                || color.equals(gris)) {
            this.color = color;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Los colores disponibles son:\n- Blanco\n- Negro\n- Rojo\n- Azul\n- Gris", "Opciones colores",
                    JOptionPane.INFORMATION_MESSAGE);
            this.color = blanco;
        }
        if (consumo.equals(CONSUMO_A) || consumo.equals(CONSUMO_B) || consumo.equals(CONSUMO_C)
                || consumo.equals(CONSUMO_D) || consumo.equals(CONSUMO_E) || consumo.equals(CONSUMO_F)) {
            this.consumo = consumo;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Los tipos de consumo de energia disponibles son:\n- A\n- B\n- C\n- D\n- E\n- F",
                    "Opciones colores", JOptionPane.INFORMATION_MESSAGE);
            this.consumo = CONSUMO_F;
        }
    }

    // METODOS
    @Override
    public String toString() {
        return "Electrodomestico\t{" +
                "precio='" + precio + "€" + '\'' +
                ", peso=" + peso + "kg" + '\'' +
                ", color=" + color + '\'' +
                ", consumo=" + consumo + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Electrodomestico elec1 = new Electrodomestico();
        Electrodomestico elec2 = new Electrodomestico(12.5, 10);
        Electrodomestico elec3 = new Electrodomestico(21.6, 34, "rojo", "B");

        System.out.println(elec1.toString() + "\n" + elec2.toString() + "\n" + elec3.toString());
    }
}
