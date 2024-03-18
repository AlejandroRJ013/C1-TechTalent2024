import javax.swing.JOptionPane;

public class Santander {
    // ATRIBUTOS
    int numeroCuenta;
    double saldo;

    // CONSTRUCTORES
    public Santander() {
        this.numeroCuenta = 0000000000;
        this.saldo = 0.0;
    }

    public Santander(int numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    // METODOS
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void meter(double ingreso) {
        this.saldo = saldo + ingreso;
    }

    public void sacar(double elRetiro) {
        this.saldo = saldo - elRetiro;
    }

    public static void main(String[] args) {
        
        boolean error = false;
        int numeroDiezDigitos = preguntarNumeroCuenta(error);
        System.out.println(numeroDiezDigitos);
    }

    public static int preguntarNumeroCuenta(boolean error) {
        
        int numeroDiezDigitos = 0;
        
        do {
            String numCuentaInput = "";
            do {
                numCuentaInput = JOptionPane.showInputDialog(null, "Ingrese su número de cuenta",
                        "Tu cuenta Santander",
                        JOptionPane.QUESTION_MESSAGE);
                try {
                    numeroDiezDigitos = Integer.parseInt(numCuentaInput);
                    error = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Solo puede contener números", "ERROR 404",
                            JOptionPane.ERROR_MESSAGE);
                    error = true;
                }
            } while (error);

            if (numCuentaInput.length() != 10) {
                JOptionPane.showMessageDialog(null, "El número de cuenta debe tener 10 dígitos", "ERROR 404",
                        JOptionPane.ERROR_MESSAGE);
                error = true;
            }
        } while (error);

        return numeroDiezDigitos;
    }

    public static void preguntarSalarioCuenta(boolean error) {

    }
}