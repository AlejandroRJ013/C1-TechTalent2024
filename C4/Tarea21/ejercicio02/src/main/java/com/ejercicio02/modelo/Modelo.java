package com.ejercicio02.modelo;

import java.util.*;

public class Modelo {
    private ArrayList<Double> numerosOp = new ArrayList<>();
    private ArrayList<Character> simbolosOp = new ArrayList<>();
    private ArrayList<Character> simbolosOperaciones;
    private StringBuilder operacion = new StringBuilder();
    private StringBuilder historial = new StringBuilder();
    private double eulier = Math.E;
    private double pi = Math.PI;

    {
        simbolosOperaciones = new ArrayList<>(Arrays.asList('+', '-', 'x', '/', '*'));
    }

    public Modelo() {
        operacion.append("0");
    }

    public Modelo(String nuevaEntrada) {
        operacion.append(nuevaEntrada);
    }

    public void setEntrada(String entrada) {
        if (operacion.toString().equals("Error")) {
            operacion.setLength(0);
        } else if (operacion.toString().equals("0")) {
            if (!entrada.equals(".")) {
                operacion.setLength(0);
            }
        } /*
           * else if (operacion.toString().matches("-?\\d+(\\.\\d+)?")) {
           * if (entrada.matches("\\d")) {
           * operacion.setLength(0);
           * }
           * }
           */
        operacion.append(entrada);
    }

    public double getE() {
        return eulier;
    }

    public double getPI() {
        return pi;
    }

    public String getOperacion() {
        return operacion.toString();
    }

    public void leerYOperar(String parteOperacion) {
        leer(parteOperacion);

        operar(numerosOp, simbolosOp);
    }

    public void leer(String parteOperacion) {
        numerosOp.clear();
        simbolosOp.clear();
        char[] partesOper = parteOperacion.toCharArray();
        StringBuilder numDecimal = new StringBuilder();

        for (int i = 0; i < partesOper.length; i++) {
            Character caracterOp = partesOper[i];
            if (Character.isDigit(caracterOp) || caracterOp == '.'
                    || (caracterOp == '-' && (i == 0 || Character.isDigit(partesOper[i + 1])))) {
                numDecimal.append(caracterOp);
            } else if (simbolosOperaciones.contains(caracterOp)) {
                if (!Character.isLetter(partesOper[i + 1])) {
                    agregarNumero(numDecimal);
                    simbolosOp.add(caracterOp);
                }
            }
        }
        agregarNumero(numDecimal);
    }

    public boolean hayModExp() {
        ArrayList<String> partesOp = new ArrayList<>(Arrays.asList(operacion.toString().split(" ")));
        return (partesOp.contains("exp")) ? true : (partesOp.contains("mod")) ? true : false;
    }

    public void modExp() {
        ArrayList<String> partesOp = new ArrayList<>(Arrays.asList(operacion.toString().split(" ")));
        double resultado = 0;
        for (int i = 0; i < partesOp.size(); i++) {
            switch (partesOp.get(i)) {
                case "exp":
                    double num11 = Double.parseDouble(partesOp.get(i - 1));
                    double num12 = Double.parseDouble(partesOp.get(i + 1));
                    double diezElevado = Math.pow(10, num12);
                    resultado = num11 * diezElevado;
                    partesOp.set(i, String.valueOf(resultado));
                    partesOp.remove(i + 1);
                    partesOp.remove(i - 1);
                    historial.append("\n& " + resultado + " = exp(" + num11 + " x 10 ^ " + num12
                            + ") // Pertenece a la siguiente operación");
                    System.out.println(historial.toString());
                    break;

                case "mod":
                    double num21 = Double.parseDouble(partesOp.get(i - 1));
                    double num22 = Double.parseDouble(partesOp.get(i + 1));
                    resultado = num21 % num22;
                    partesOp.set(i, String.valueOf(resultado));
                    partesOp.remove(i + 1);
                    partesOp.remove(i - 1);
                    historial.append("\n& " + resultado + " = mod(" + num21 + " % " + num22
                            + ") // Pertenece a la siguiente operación");
                    System.out.println(historial.toString());
                    break;

                default:
                    break;
            }
        }

        operacion = new StringBuilder(String.join(" ", partesOp));
    }

    private void agregarNumero(StringBuilder numDecimal) {
        if (numDecimal.length() > 0) {
            try {
                numerosOp.add(Double.parseDouble(numDecimal.toString()));
            } catch (NumberFormatException e) {
                manejarError(e);
            }
            numDecimal.setLength(0);
        }
    }

    public void operar(ArrayList<Double> numeros, ArrayList<Character> simbolos) {
        try {
            ArrayList<Double> resultados = new ArrayList<>(numeros);
            ArrayList<Character> ops = new ArrayList<>(simbolos);

            if (hayModExp()) {
                modExp();
                resultados.clear();
                simbolos.clear();
                leer(operacion.toString());
                resultados.addAll(numerosOp);
            }

            if (resultados.size() > 1) {
                procesarOperaciones(resultados, ops, '^', '$');
                procesarOperaciones(resultados, ops, 'x', '/');
                procesarOperaciones(resultados, ops, '+', '-');
            }

            if (resultados.size() == 1) {
                String operacionTxt = operacion.toString();
                double resultadoDouble = resultados.get(0);
                actualizarOperacion(resultadoDouble);
                historial.append("\n&" + operacionTxt + " = " + operacion.toString());
                System.out.println(historial.toString());
            } else {
                throw new IllegalStateException("Operación no válida");
            }
        } catch (Exception e) {
            manejarError(e);
        }
    }

    private void procesarOperaciones(ArrayList<Double> numeros, ArrayList<Character> simbolos, char op1, char op2) {
        for (int i = 0; i < simbolos.size(); i++) {
            char simbolo = simbolos.get(i);
            if (simbolo == op1 || simbolo == op2) {
                double resultado = realizarOperacion(numeros.get(i), numeros.get(i + 1), simbolo);
                numeros.set(i, resultado);
                numeros.remove(i + 1);
                simbolos.remove(i);
                i--;
            }
        }
    }

    private double realizarOperacion(double num1, double num2, char operador) {
        switch (operador) {
            case 'x':
                return multiplicar(num1, num2);
            case '/':
                return dividir(num1, num2);
            case '+':
                return sumar(num1, num2);
            case '-':
                return restar(num1, num2);
            case '^':
                return Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException("Operador no válido");
        }
    }

    public double sumar(double op1, double op2) {
        return op1 + op2;
    }

    public double restar(double op1, double op2) {
        return op1 - op2;
    }

    public double multiplicar(double op1, double op2) {
        return op1 * op2;
    }

    public double dividir(double op1, double op2) {
        if (op2 == 0) {
            throw new ArithmeticException("División por cero");
        }
        return op1 / op2;
    }

    public void fraccion(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = 1 / ultimoNumero;
        actualizarUltimoValor(resultado);
        historial.append("\n& " + resultado + " = (1/" + ultimoNumero + ") // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void factorial(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = 1;
        for (int i = 1; i <= ultimoNumero; i++) {
            resultado *= i;
        }
        actualizarUltimoValor(resultado);
        historial.append("\n& " + resultado + " = " + ultimoNumero + "! // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void valorAbsoluto(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = Math.abs(ultimoNumero);
        actualizarUltimoValor(resultado);
        historial.append("\n& " + resultado + " = valor absoluto ( " + (ultimoNumero * -1) + " || " + ultimoNumero
                + " ) // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void log(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = Math.log10(ultimoNumero);
        actualizarUltimoValor(resultado);
        historial.append("\n& " + resultado + " = log(" + ultimoNumero + ") // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void logaritmoNeperiano(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = Math.log(ultimoNumero);
        actualizarUltimoValor(resultado);
        historial.append("\n& " + resultado + " = log(" + ultimoNumero + ") // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void elevar(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = Math.pow(ultimoNumero, 2);
        actualizarUltimoValor(resultado);
        historial.append("\n& " + resultado + " = (" + ultimoNumero + "^2) // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void potenciaDeDiez(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = Math.pow(10, ultimoNumero);
        actualizarUltimoValor(resultado);
        historial.append(
                "\n& " + resultado + " = (" + 10 + "^" + ultimoNumero + ") // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void elevarY(String operacionEntrada) {
        ArrayList<String> partesOp = new ArrayList<>(Arrays.asList(operacionEntrada.toString().split(" ")));
        double valorElevado = Integer.parseInt(partesOp.get(partesOp.size() - 3));
        double potencia = Integer.parseInt(recogerUltimoValor(operacionEntrada));
        double resultado = Math.pow(valorElevado, potencia);
        partesOp.remove(partesOp.size() - 3);
        partesOp.remove(partesOp.size() - 2);
        operacion = new StringBuilder(String.join(" ", partesOp));
        actualizarUltimoValor(resultado);
        historial.append("\n& " + resultado + " = (" + valorElevado + "^" + potencia
                + ") // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void raiz(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = Math.sqrt(ultimoNumero);
        actualizarUltimoValor(resultado);
        historial.append(
                "\n& " + resultado + " = " + "(\u221A" + ultimoNumero + ") // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public void cambiarSentido(String operacion) {
        double ultimoNumero = Integer.parseInt(recogerUltimoValor(operacion));
        double resultado = -ultimoNumero;
        actualizarUltimoValor(resultado);
        historial.append("\n& " + resultado + " = " + "(-" + ultimoNumero + ") // Pertenece a la siguiente operación");
        System.out.println(historial.toString());
    }

    public int cogerIndice() {
        int indice = -1;
        try {
            indice = (operacion.toString().split(" ").length == 0) ? -1
                    : (operacion.toString().split(" ").length > 1) ? numerosOp.size() - 1 : 0;
        } catch (Exception e) {
            manejarError(e);
        }
        return indice;
    }

    private String recogerUltimoValor(String operacion) {
        String[] partesOperacion = operacion.toString().split(" ");
        return partesOperacion[partesOperacion.length - 1];
    }

    private void actualizarUltimoValor(double resultado) {
        String[] operacionSeparada = operacion.toString().split(" ");
        if (entero(resultado)) {
            operacionSeparada[operacionSeparada.length - 1] = String.valueOf(((int) resultado));
        } else {
            operacionSeparada[operacionSeparada.length - 1] = String.valueOf(resultado);
        }
        operacion = new StringBuilder(String.join(" ", operacionSeparada));
    }

    public void actualizarOperacion(double nuevoResultado) {
        operacion.setLength(0);
        if (entero(nuevoResultado)) {
            operacion.append(((int) nuevoResultado));
        } else {
            operacion.append(nuevoResultado);
        }
    }

    public void limpiarOperacionYHistorial() {
        operacion.setLength(0);
        historial.setLength(0);
        operacion.append("0");
    }

    public void limpiarOperacion() {
        operacion.setLength(0);
        operacion.append("0");
    }

    public void borrarUno() {
        try {
            operacion.setLength(operacion.length() - 1);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("No hay más operación");
        }
    }

    public boolean entero(double numero) {
        return ((int) numero) == numero;
    }

    private void manejarError(Exception e) {
        operacion.setLength(0);
        operacion.append("Error");
        e.printStackTrace();
    }
}