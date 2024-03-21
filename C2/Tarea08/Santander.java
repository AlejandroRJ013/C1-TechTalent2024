//enum

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class Santander {
    // ATRIBUTOS
    private long numeroCuenta;
    private double saldo;

    // CONSTRUCTORES
    public Santander() {
        this.numeroCuenta = 0;
        this.saldo = 0.0;
    }

    public Santander(long numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    // METODOS
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public long getNumeroCuenta() {
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

    @Override
    public String toString() {
        return  "│\t      " + numeroCuenta + "\t    │\t\t " + saldo + "\t\t│\n"+
        "├ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┼ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┤";
    }

    public static void main(String[] args) {
        
        boolean error = false;
        long numeroCuenta = preguntarNumeroCuenta(error);
        double salario = preguntarSalarioCuenta(error);
        Santander cuentaUsuario1 = new Santander(numeroCuenta, salario);
        System.out.println("┌ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ "+
        "─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┐\n" +
        "│ \t\t\t╔═══════════════════════╗\t\t\t│\n" +
        "│ \t\t\t║ Tu cuenta Santander ;)║\t\t\t│\n" +
        "│ \t\t\t╚═══════════════════════╝\t\t\t│\n│\t" +
        "░░░░░░▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"+
        "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░\t│\n" +
        "├ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┬ ─ ─ ─ "+
        "─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ┤");
        System.out.println(cuentaUsuario1.toString());
        
        creacionFrame(cuentaUsuario1);
    }

    public static long preguntarNumeroCuenta(boolean error) {
        long numeroDiezDigitos = 0;
        
        do {
            String numCuentaInput = "";
            do {
                numCuentaInput = JOptionPane.showInputDialog(null, 
                "Ingrese su número de cuenta", "Tu cuenta Santander",
                        JOptionPane.QUESTION_MESSAGE);
                try {
                    numeroDiezDigitos = Long.parseLong(numCuentaInput);
                    error = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Solo puede contener números", "ERROR 404",
                            JOptionPane.ERROR_MESSAGE);
                    error = true;
                }
            } while (error);

            if (numCuentaInput.length() != 10) {
                JOptionPane.showMessageDialog(null, 
                "El número de cuenta debe tener 10 dígitos", "ERROR 404",
                        JOptionPane.ERROR_MESSAGE);
                error = true;
            }
        } while (error);

        return numeroDiezDigitos;
    }

    public static double preguntarSalarioCuenta(boolean error) {
        double saldoIngresado = 0;
        String numSaldoInput = "";
        
        do {
            numSaldoInput = JOptionPane.showInputDialog(null, "¿De cuanto saldo dispone en su cuenta?", "Tu cuenta Santander", JOptionPane.QUESTION_MESSAGE);
            try {
                saldoIngresado = Double.parseDouble(numSaldoInput);
                error = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha habido un error al comprobar su sucio dinero", "ERROR 404",
                        JOptionPane.ERROR_MESSAGE);
                error = true;
            }
        } while (error);
        return saldoIngresado;
    }

    public static void creacionFrame(Santander cuentaUsuario1) {
        JFrame frameCajero = new JFrame();
        frameCajero.setSize(1000, 1000);
        frameCajero.setTitle("Operaciones cajero");
        frameCajero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panelCajero = new JPanel();
        panelCajero.setLayout(new GridLayout(2,0));
        
        JPanel textoCajero = new JPanel();
        
        JPanel opcionesCajero = new JPanel();
        opcionesCajero.setLayout(new GridLayout(0,2));

        JLabel opcionesTXT = new JLabel("¿Que operaciones quieres hacer?");
        opcionesTXT.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel ingresarTXT = new JLabel("Ingresar");
        ingresarTXT.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton ingresar = new JButton(escalarImagen("Iconos\\add-cash.png"));
        modificarBoton(ingresar);
        JLabel sacarTXT = new JLabel("Sacar");
        sacarTXT.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton sacar = new JButton(escalarImagen("Iconos\\sub-cash.png"));
        modificarBoton(sacar);
        accionesBotones(cuentaUsuario1, ingresar, sacar);
        
        textoCajero.add(opcionesTXT);
        textoCajero.setBorder(new EmptyBorder(5, 20, 4, 20));
        
        opcionesCajero.add(ingresar);
        opcionesCajero.add(sacar);
        opcionesCajero.setBorder(new EmptyBorder(3, 5, 4, 5));

        panelCajero.add(textoCajero);
        panelCajero.add(opcionesCajero);
        panelCajero.setBorder(new EmptyBorder(8, 8, 8, 8));

        frameCajero.add(panelCajero);

        frameCajero.pack();
        frameCajero.setLocationRelativeTo(null);
        frameCajero.setVisible(true);
    }

    public static void modificarBoton(JButton boton) {
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public static ImageIcon escalarImagen(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        ImageIcon imagenEscalada = new ImageIcon(imagen.getImage().getScaledInstance(55, 25, Image.SCALE_SMOOTH));
        return imagenEscalada;
    }

    public static void accionesBotones(Santander cuentaUsuario1, JButton ingresar, JButton sacar) {
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean invalido = false;
                double ingreso = 0.0;
                do {
                    String ingresoTxt = JOptionPane.showInputDialog(null, 
                    "Indique la cantidad de dinero a ingresar a la cuente", "INGRESO", JOptionPane.PLAIN_MESSAGE);
                    try {
                        ingreso = Double.parseDouble(ingresoTxt);
                        invalido = false;
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, 
                        "Ingrese un número válido, por favor", "ERROR 404", JOptionPane.ERROR_MESSAGE);
                        invalido = true;
                    }
                } while (invalido);
                cuentaUsuario1.meter(ingreso);
                System.out.println(cuentaUsuario1.toString() +  "  INGRESO +" + ingreso);
            }
        });

        sacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean invalido = false;
                double extracto = 0.0;
                do {
                    String extractoTxt = JOptionPane.showInputDialog(null,
                     "Indique la cantidad de dinero a ingresar a la cuente", "INGRESO", JOptionPane.PLAIN_MESSAGE);
                    try {
                        extracto = Double.parseDouble(extractoTxt);
                        invalido = false;
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, 
                        "Ingrese un número válido, por favor", "ERROR 404", JOptionPane.ERROR_MESSAGE);
                        invalido = true;
                    }
                } while (invalido);
                cuentaUsuario1.sacar(extracto);
                System.out.println(cuentaUsuario1.toString() +  "  EXTRACCIÓN -" + extracto);
            }
        });
    }
}