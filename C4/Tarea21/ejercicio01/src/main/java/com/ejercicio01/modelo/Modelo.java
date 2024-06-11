package com.ejercicio01.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Modelo {
    private ArrayList<Double> numerosOp = new ArrayList<>();
    private ArrayList<Character> simbolosOp = new ArrayList<>();
    private ArrayList<Character> simbolosOperaciones;
    private StringBuilder operacion = new StringBuilder();
    private StringBuilder historial = new StringBuilder();
    private boolean plusDiv = false;
    private boolean sumRes = false;
    private boolean potencia = false;

    public Modelo() {
        simbolosOperaciones = new ArrayList<>(Arrays.asList('+', '-', 'x', '/'));
        operacion.setLength(0);
        operacion.append("0");
    }

    public Modelo(String nuevaEntrada) {
        simbolosOperaciones = new ArrayList<>(Arrays.asList('+', '-', 'x', '/'));
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

        for (Character caracter : operacion.toString().toCharArray()) {
            if (caracter == '(' || caracter == ')') {
                if (parteProcesada.length() > 0) {
                    partesOperacion.add(parteProcesada.toString());
                    parteProcesada.setLength(0);
                }
                partesOperacion.add(caracter.toString());
            } else {
                parteProcesada.append(caracter);
            }
        }
        if (parteProcesada.length() > 0) {
            partesOperacion.add(parteProcesada.toString());
        }

        StringBuilder oper = new StringBuilder();
        for (String parte : partesOperacion) {
            oper.append(parte);
        }
        leerYOperar(oper.toString());
    }

    public void leerYOperar(String parteOperacion) {
        StringBuilder numDecimal = new StringBuilder();
        numerosOp.clear(); simbolosOp.clear(); 
        plusDiv = false; sumRes = false; potencia = false;
        char[] partesOper = parteOperacion.toCharArray();

        int i = 0;
        for (Character caracterOp : partesOper) {
            if (Character.isDigit(caracterOp) || caracterOp == '.' || (caracterOp == '-' && Character.isDigit(partesOper[i+1]))) {
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
            i++;
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
                    historial.append("\n& " + operacion.toString() + " = " + ((int) resultadoDouble));
                    operacion.setLength(0);
                    operacion.append(((int) resultadoDouble));
                } else {
                    historial.append("\n& " + operacion.toString() + " = " + resultadoDouble);
                    operacion.setLength(0);
                    operacion.append(resultadoDouble);
                }
                System.out.println(historial.toString());
            } else {
                System.out.println(operacion.toString());
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
            historial.append("\n& " + resultadoFraccion + " = " + "(1/" + numOperador + ") // Pertenece a la siguiente operación");
            System.out.println(historial.toString());
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
            historial.append("\n& " + potencia + " = " + "(" + numOperador + "^2) // Pertenece a la siguiente operación");
            System.out.println(historial.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            operacion.setLength(0);
            operacion.append("Error");
        }
    }

    public void raiz() {
        try {
            String[] operacionSeparada = operacion.toString().split(" ");
            double numOperador = Double.parseDouble(operacionSeparada[operacionSeparada.length - 1]);
            double raizCuadrada = Math.sqrt(numOperador);
            if (entero(raizCuadrada)) {
                operacionSeparada[operacionSeparada.length - 1] = String.valueOf(((int) raizCuadrada));
            } else {
                operacionSeparada[operacionSeparada.length - 1] = String.valueOf(raizCuadrada);
            }
            operacion = new StringBuilder(String.join(" ", operacionSeparada));
            historial.append("\n& " + raizCuadrada + " = " + "(²√" + numOperador + ") // Pertenece a la siguiente operación");
            System.out.println(historial.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            operacion.setLength(0);
            operacion.append("Error");
        }
    }

    public void porcentaje() {
        try {
            String[] operacionSeparada = operacion.toString().split(" ");
            if (operacionSeparada.length >= 3) {
                double numPorcentual = Double.parseDouble(operacionSeparada[operacionSeparada.length - 1]);
                double numOperador = Double.parseDouble(operacionSeparada[operacionSeparada.length - 3]);
                double porcentaje = (numOperador / 100) * numPorcentual;
                if (entero(porcentaje)) {
                    operacionSeparada[operacionSeparada.length - 1] = String.valueOf(((int) porcentaje));
                } else {
                    operacionSeparada[operacionSeparada.length - 1] = String.valueOf(porcentaje);
                }
                operacion = new StringBuilder(String.join(" ", operacionSeparada));
                historial.append("\n& " + porcentaje + " = " + "(" + numPorcentual + "% de " + numOperador + ") // Pertenece a la siguiente operación");
                System.out.println(historial.toString());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            operacion.setLength(0);
            operacion.append("Error");
        }
    }

    //mal
    public void cambiarSentido() {
        try {
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
        return ((int) numero) == numero;
    }
}
