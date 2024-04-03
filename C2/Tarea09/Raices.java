import java.text.*;
import java.util.*;

public class Raices {
    //   ATRIBUTOS
    private double a;
    private double b;
    private double c;
    private double resultado1;
    private double resultado2;


    //  CONSTRUCTORES
    public Raices() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public Raices(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //METODOS
    public double getDiscriminate() {
        return (Math.pow(b, 2)) - 4 * a *c;
    }

    public boolean tieneRaices(double discriminenteN) {
        if (discriminenteN > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean tieneRaiz(double discriminenteN) {
        if (discriminenteN == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String obtenerRaiz() {
        DecimalFormat dosDecimales = new DecimalFormat("0.000");
        String respu = dosDecimales.format(resultado1);
        return "\nTiene una unica raiz: " + respu;
    }

    public String obtenerRaices() {
        DecimalFormat dosDecimales = new DecimalFormat("0.000");
        String respu1 = dosDecimales.format(resultado1);
        String respu2 = dosDecimales.format(resultado2);
        return "\nPrimera: " + respu1 + "\nSegunda: " + respu2;
    }

    public void calcular() {
        double B_alcuadrado = Math.pow(b, 2);
        System.out.println("B_Alcuadrado: "+B_alcuadrado);
        double cuatro_A_C = 4*a*c;
        System.out.println("cuatro_A_C: "+cuatro_A_C);
        double raiz = Math.sqrt(B_alcuadrado - cuatro_A_C);
        System.out.println("raiz: "+raiz);
        double nuevaB = b * (-1);
        System.out.println("nuevaB: "+nuevaB);
        double divisor = 2 * a;
        System.out.println("divisor: "+divisor);

        resultado1 = (nuevaB + raiz) / divisor;
        System.out.println("resultado1: "+ resultado1);
        resultado2 = (nuevaB - raiz) / divisor;
        System.out.println("resultado2: "+ resultado2);

    }

    //  MAIN
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Indique los números con los que se hara la equacion de segundo grado:\n - A:");
        double a = Double.parseDouble(scaner.next());
        System.out.println("\n - B:");
        double b = Double.parseDouble(scaner.next());
        System.out.println("\n - C:");
        double c = Double.parseDouble(scaner.next());
        System.out.println("\n");

        Raices raiz_cuadratica = new Raices(a, b, c);
        double negro = raiz_cuadratica.getDiscriminate();
        raiz_cuadratica.calcular();
        System.out.println("Discriminante: "+negro);
        if(!raiz_cuadratica.tieneRaiz(negro) && !raiz_cuadratica.tieneRaices(negro)) {
            System.out.print("No tiene raices esta ecuación");
        } else if(raiz_cuadratica.tieneRaices(negro)) {
            System.out.print(raiz_cuadratica.obtenerRaices());
        } else {
            System.out.print(raiz_cuadratica.obtenerRaiz());
        }
        scaner.close();
    }
}