package com.ejercicio01.modelo;

import java.util.*;

public class Modelo {
    private ArrayList<Double> numerosOp = new ArrayList<>(); private ArrayList<Character> simbolosOp = new ArrayList<>();
    private ArrayList<Character> simbolosOperaciones = new ArrayList<>(Arrays.asList('+', '-', 'x', '/', '^'));
    private StringBuilder operacion = new StringBuilder(); private StringBuilder historial = new StringBuilder();
    private boolean plusDiv = false; private boolean sumRes = false; private boolean potencia = false;

    public Modelo() {
        operacion.setLength(0);
        operacion.append("0");
    }

    public Modelo(String nuevaEntrada) {
        operacion.setLength(0);
        operacion.append(nuevaEntrada);
    }

    public void setEntrada(String entrada) {
        if (operacion.toString().equals("0")) {
            operacion.setLength(0);
            operacion.append(entrada);
        } else {
            operacion.append(entrada);
        }
    }

    public String getOperacion() {
        return operacion.toString();
    }

    public void leerOperacion() {
        ArrayList<String> partesOperacion = new ArrayList<>();
        StringBuilder parteProcesada = new StringBuilder();
        boolean parentesis = false;

        for (Character caracter : operacion.toString().toCharArray()) {
            if (caracter == '(' || caracter == ')') {
                parentesis = true;
                partesOperacion.add(parteProcesada.toString());
                parteProcesada.setLength(0);
            } else {
                parteProcesada.append(caracter);
            }
        }
        if (parteProcesada.length() > 0) {
            partesOperacion.add(parteProcesada.toString());
            parteProcesada.setLength(0);
        }
        while (true) {
            if (partesOperacion.size() > 0) {
                boolean ahora = false;
                for (String parte : partesOperacion) {
                    if (ahora) {
                        if (parte.contains("(")) {
                            leerOperacion();
                        }
                        leerYOperar(parte);
                        ahora = false;
                    } else {
                        ahora = true;
                    }
                }
            } else {
                leerYOperar(partesOperacion.toString());
                break;
            }
        }
    }

    public void leerYOperar(String parteOperacion) {
        StringBuilder numDecimal = new StringBuilder();

        for (Character caracterOp : parteOperacion.toCharArray()) {
            if (Character.isDigit(caracterOp) || caracterOp == '.') {
                numDecimal.append(caracterOp);
            } else if (simbolosOperaciones.contains(caracterOp)) {
                if (numDecimal.length() > 0) {
                    try {
                        numerosOp.add(Double.parseDouble(numDecimal.toString()));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        parteOperacion = "Error";
                        return;
                    }
                    numDecimal.setLength(0);
                }
                simbolosOp.add(caracterOp);
                if (caracterOp == '^') {
                    potencia = true;
                } else if (caracterOp == 'x' || caracterOp == '/') {
                    plusDiv = true;
                } else {
                    sumRes = true;
                }
            }
        }

        if (numDecimal.length() > 0) {
            try {
                numerosOp.add(Double.parseDouble(numDecimal.toString()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                parteOperacion = "Error";
                return;
            }
        }
        operar(numerosOp, simbolosOp);
    }

    public void operar(ArrayList<Double> numeros, ArrayList<Character> simbolos) {
        try {
            ArrayList<Double> resultados = new ArrayList<>(numeros);
            ArrayList<Character> ops = new ArrayList<>(simbolos);

            if (potencia) {
                procesarOperaciones(resultados, ops, '^', '$');
            }
            if (plusDiv) {
                procesarOperaciones(resultados, ops, 'x', '/');
            }
            if (sumRes) {
                procesarOperaciones(resultados, ops, '+', '-');
            }
            
            if (resultados.size() == 1) {
                double resultadoDouble = resultados.get(0);
                if (entero(resultadoDouble)) {
                    historial.append(" &\n " + operacion.toString() + " = " + ((int) resultadoDouble));
                    operacion.setLength(0);
                    operacion.append(((int) resultadoDouble));
                } else {
                    historial.append(" &\n " + operacion.toString() + " = " + resultadoDouble);
                    operacion.setLength(0);
                    operacion.append(resultadoDouble);
                }
                System.out.println(historial.toString());
            } else {
                throw new IllegalStateException("Operación no válida");
            }
        } catch (Exception e) {
            operacion.setLength(0);
            operacion.append("Error");
            e.printStackTrace();
        }
    }

    private void procesarOperaciones(ArrayList<Double> numeros, ArrayList<Character> simbolos, char op1, char op2) {
        for (int i = 0; i < simbolos.size(); i++) {
            char simbolo = simbolos.get(i);
            if (simbolo == op1 || simbolo == op2) {
                double resultado;
                double num1 = numeros.get(i);
                double num2 = numeros.get(i + 1);
                if (simbolo == 'x') {
                    resultado = multiplicar(num1, num2);
                } else if (simbolo == '/') {
                    if (num2 == 0) {
                        throw new ArithmeticException("División por cero");
                    }
                    resultado = dividir(num1, num2);
                } else if (simbolo == '+') {
                    resultado = sumar(num1, num2);
                } else {
                    resultado = restar(num1, num2);
                }
                numeros.set(i, resultado);
                numeros.remove(i + 1);
                simbolos.remove(i);
                i--;
            }
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
        return op1 / op2;
    }

    public void fraccion() {
        try {
            String[] operacionSeparada = operacion.toString().split(" ");
            double numOperador = Double.parseDouble(operacionSeparada[operacionSeparada.length - 1]);
            double resultadoFraccion = 1 / numOperador;
            if (entero(resultadoFraccion)) {
                operacionSeparada[operacionSeparada.length - 1] = String.valueOf(((int) resultadoFraccion));
            } else {
                operacionSeparada[operacionSeparada.length - 1] = String.valueOf(resultadoFraccion);
            }
            operacion = new StringBuilder(String.join(" ", operacionSeparada));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            operacion.setLength(0);
            operacion.append("Error");
        }
    }

    public void elevar() {
        try {
            String[] operacionSeparada = operacion.toString().split(" ");
            double numOperador = Double.parseDouble(operacionSeparada[operacionSeparada.length - 1]);
            double potencia = Math.pow(numOperador, 2);
            if (entero(potencia)) {
                operacionSeparada[operacionSeparada.length - 1] = String.valueOf(((int) potencia));
            } else {
                operacionSeparada[operacionSeparada.length - 1] = String.valueOf(potencia);
            }
            operacion = new StringBuilder(String.join(" ", operacionSeparada));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            operacion.setLength(0);
            operacion.append("Error");
        }
    }

    public void cambiarSentido() {
        try {
            // if (simbolosOp.size() > 0) {
            //     char simbolo = simbolosOp.get(simbolosOp.size());

            // }
            String[] operacionSeparada = operacion.toString().split(" ");
            double numOperador = Double.parseDouble(operacionSeparada[operacionSeparada.length - 1]);
            double numeroCambiado = numOperador * (-1);
            if (entero(numeroCambiado)) {
                operacionSeparada[operacionSeparada.length - 1] = String.valueOf(((int) numeroCambiado));
            } else {
                operacionSeparada[operacionSeparada.length - 1] = String.valueOf(numeroCambiado);
            }
            operacion = new StringBuilder(String.join(" ", operacionSeparada));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            operacion.setLength(0);
            operacion.append("Error");
        }
    }

    public void limpiarOperacionYHistorial() {
        operacion.setLength(0);
        historial.setLength(0);
    }

    public void limpiarOperacion() {
        operacion.setLength(0);
    }

    public void borrarUno() {
        try {
            operacion.setLength(operacion.length() - 1);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("No hay más operación");
        }
    }

    public boolean entero(double numero) {
        if (((int) numero) == numero) {
            return true;
        } else {
            return false;
        }
    }
}