import java.text.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class ejercicio04 {
    public static void main(String[] args) {
        int numeros[] = {7,8,9,4,5,6,1,2,3,0};
        String operadores[] = {"/","*","-", ",", "+", "C", "="};
        StringBuilder historialTxt = new StringBuilder();
        StringBuilder operacion = new StringBuilder();

        // VENTANA //
        JFrame frame = new JFrame("¡MAS! - Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);

        // BARRA DE NAVEGACIÓN //
        JMenuBar barraDeNavegacion = new JMenuBar();
        JMenu opciones = new JMenu("Opciones");

        JMenuItem historial = new JMenuItem("Historial");
        historial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelHistorial = new JPanel();
                panelHistorial(panelHistorial, historialTxt);
                JOptionPane.showOptionDialog(null, 
                new JScrollPane(panelHistorial), "Historial", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
                null, new Object[]{}, null);
            }
        });
        
        JMenuItem sobreNosotros = new JMenuItem("Sobre Nosotros");
        sobreNosotros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JEditorPane panelHTML = new JEditorPane();
                panelHtmlSobreNosotros(panelHTML);
                JOptionPane.showOptionDialog(null, 
                new JScrollPane(panelHTML), 
                "¡MAS! Sobre nosotros y nuestro partido político", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
                null, new Object[]{}, null);
            }
        });

        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        opciones.add(historial);
        opciones.add(sobreNosotros);
        opciones.add(salir);
        barraDeNavegacion.add(opciones);
        frame.setJMenuBar(barraDeNavegacion);
        // BARRA DE NAVEGACIÓN //

        JPanel panelDePaneles = new JPanel();
        panelDePaneles.setLayout(new BoxLayout(panelDePaneles, BoxLayout.Y_AXIS));
        panelDePaneles.setBorder(new EmptyBorder(10, 20, 10, 20));
        
        // PANTALLA DE CÁLCULO //
        JTextPane pantalla = new JTextPane();
        pantalla.setBorder(new LineBorder(new Color(160, 80, 190), 4));
        pantalla.setMaximumSize(new Dimension(frame.getWidth()-10, 300));
        pantalla.setFont(new Font("arial", Font.BOLD, 32));
        pantalla.setEditable(false);
        pantalla.setText("0");
        panelDePaneles.add(pantalla);
        // PANTALLA DE CÁLCULO //

        // PANEL BOTONES NÚMEROS //
        JPanel panelDeBotones = new JPanel();
        crearPanelBotones(panelDeBotones, numeros, operadores);
        panelDePaneles.add(panelDeBotones);
        // PANEL BOTONES NÚMEROS //

        // FUNCIONES BOTONES //
        for (Component componente : panelDeBotones.getComponents()) {
            if (componente instanceof JPanel) {
                JPanel panelBoton = (JPanel) componente;
                Component[] botones_array = panelBoton.getComponents();
                for (Component componente_boton : botones_array) {
                    if (componente_boton instanceof RoundedButton) {
                        RoundedButton boton = (RoundedButton) componente_boton;
                        boton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String entrada = boton.getText();
                                funcionBoton(panelDeBotones, entrada, pantalla, 
                                operacion, historialTxt, numeros, operadores);
                            }
                        });
                    }
                }
            }
        }
        // FUNCIONES BOTONES //

        frame.add(panelDePaneles);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        // VENTANA //
    }

    public static void crearPanelBotones(JPanel panelDeBotones, int numeros[], String operadores[]) {
        panelDeBotones.setLayout(new GridBagLayout());
        GridBagConstraints carCelda = new GridBagConstraints();
        carCelda.fill = GridBagConstraints.BOTH;
        carCelda.weightx = 1;
        carCelda.weighty = 1;
        crearBotones(panelDeBotones, carCelda, numeros, operadores);
    }

    public static void crearBotones(JPanel panelDeBotones, GridBagConstraints carCelda, int numeros[], String operadores[]) {
        int num_cel = 0;
        int indice_op = 0;
        int indice_nu = 0;
        for (int j = 1; j <= 5; j++) {
            for (int i = 1; i <= 4; i++) {
                carCelda.gridwidth = 1;
                boolean doble = false;
                if (num_cel == 13 || num_cel == 15 || num_cel == 16) {
                    carCelda.gridwidth = 2;
                    doble = true;
                }
                JPanel panelBoton = new JPanel(new BorderLayout()); 
                panelBoton.setBorder(new EmptyBorder(2, 2, 2, 2)); 
                RoundedButton boton = new RoundedButton(null);
                if (!(i%4 == 0) && !(num_cel == 12) && !(j == 5)) {
                    boton = new RoundedButton(String.valueOf(numeros[indice_nu]), 25, "numeros");
                    boton = caracteristicasBotones(boton);
                    indice_nu++;
                } else {
                    switch (num_cel) {
                        case 12:
                            boton = new RoundedButton(operadores[indice_op], 25, "coma");
                            break;
                        case 15:
                            boton = new RoundedButton(operadores[indice_op], 25, "cancelar");
                            break;
                        case 16:
                            boton = new RoundedButton(operadores[indice_op], 25, "resultado");
                            break;
                        default:
                            boton = new RoundedButton(operadores[indice_op], 25, "string");
                            break;
                    }
                    boton = caracteristicasBotones(boton);
                    indice_op++;
                }
                panelBoton.add(boton, BorderLayout.CENTER);
                carCelda.gridx = i;
                carCelda.gridy = j;
                panelDeBotones.add(panelBoton, carCelda);
                if (doble) {
                    i++;
                }
                num_cel++;
            }
        }
    }

    public static void panelHtmlSobreNosotros(JEditorPane panelHTML) {
        panelHTML.setContentType("text/html"); // Establecer el tipo de contenido como HTML
        panelHTML.setEditable(false);

        String paginaSobreNosotros = "<html> <head> <title>¡MAS! Sobre nosotros</title> <style> body { font-family: 'Comic Sans MS'; font-size: 16px; display: flex; justify-content: center; align-items: center; } .container { background-color: #81d3bd; padding: 20px; max-width: 600px; text-align: center; } h1 { color: #e74c3c; font-size: 2.5em; margin-bottom: 20px; } p { font-size: 1.2em; line-height: 1.6; } .highlight { color: #e74c3c; font-weight: bold; } .censored { font-size: 0.8em; color: #556bb7; } .list-item { margin: 10px 0; } .emoji { color: #d718f8; font-size: 1.2em; margin-right: 5px; } </style> </head> <body> <div class=\"container\"> <h1>¡MAS! Sobre nosotros</h1> <p>Nuestra asociación políca <span class=\"highlight\">con ánimo de lucro</span> está conformada por:</p> <p class=\"list-item\"><span class=\"emoji\">🎉  </span>Manel</p> <p class=\"list-item\"><span class=\"emoji\">🎉  </span>Sabastian</p> <p class=\"list-item\"><span class=\"emoji\">🎉  </span>Alejandro</p> <p>Nuestras medidas son... <span class=\"censored\">(CENSURADO)</span></p> </div> </body> </html>";

        panelHTML.setText(paginaSobreNosotros);
    }
    
    public static void panelHistorial(JPanel panelHistorial, StringBuilder historialTxt) {
        panelHistorial.setLayout(new BoxLayout(panelHistorial, BoxLayout.Y_AXIS));
        panelHistorial.setPreferredSize(new Dimension(300, 300));
        JPanel tituloHistorial = new JPanel();
        tituloHistorial.setBackground(Color.GRAY);
        JLabel tituloLabel = new JLabel("Historial");
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 25));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloHistorial.add(tituloLabel);
        panelHistorial.add(tituloHistorial);
        JPanel operacionesPanel = new JPanel();
        operacionesPanel = panelOperaciones(operacionesPanel, historialTxt);
        panelHistorial.add(operacionesPanel);
    }
    
    public static JPanel panelOperaciones(JPanel operacionesPanel, StringBuilder historialTxt) {
        operacionesPanel.setLayout(new GridBagLayout());
        operacionesPanel.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints posicion = new GridBagConstraints();
        posicion.fill = GridBagConstraints.BOTH;
        posicion.weightx = 1;
        posicion.weighty = 1;
        String operaciones[] = historialTxt.toString().split("%");
        int pos = 0;
        for (String op : operaciones) {
            JLabel operacionLabel = new JLabel(op);
            operacionLabel.setFont(new Font("Arial", Font.BOLD, 15));
            operacionLabel.setHorizontalAlignment(SwingConstants.LEFT);
            posicion.gridy = pos;
            operacionesPanel.add(operacionLabel, posicion);
            pos++;
        }
        return operacionesPanel;
    }
    
    public static RoundedButton caracteristicasBotones(RoundedButton boton) {
        boton.setBorder(new EmptyBorder(2,2,2,2));
        boton.setFont(new Font("Arial", Font.BOLD, 24));
        return boton;
    }
    
    public static boolean esEntero(String entrada) {
        try {
            double numero = Double.parseDouble(entrada);
            if (numero % 1 == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public static String resultadoStringFormat(double resultado) {
        DecimalFormat formato = new DecimalFormat("#.###");
        if (esEntero(String.valueOf(resultado))) {
            return String.valueOf((int) resultado);
        } else {
            return formato.format(resultado);
        }
    }
    
    public static String ultimoResultado(StringBuilder historialtxt) {
        String partes[] = historialtxt.toString().split("%");
        String resultado[] = partes[partes.length-1].split(" = ");
        return resultado[resultado.length - 1];
    }

    public static int cantidadDecimales(String numeroDecimal) {
        String partesNumero[] = numeroDecimal.split("\\.");
        if (partesNumero.length > 1) {
            return partesNumero[1].length();
        } else {
            return 0;
        }
    }
    
    public static String[] separarOperacion(StringBuilder operacion) {
        String partes[] = operacion.toString().split(" ");
        return partes;
    }
    
    public static double operar(double op1, double op2, String operador) {
        double result = 0;
        switch (operador) {
            case "+":
            result = (op1 + op2);
                break;
        
            case "-":
                result = (op1 - op2);
                break;
        
            case "*":
                result = (op1 * op2);  
                break;
        
            case "/":
                result = (op1 / op2);
                break;
        
            default:
                System.out.println("UPS...");
                break;
        }
        return result;
    }

    public static String separarYOperar(StringBuilder operacion) {
        String partes[] = separarOperacion(operacion);
        String operador1 = partes[0].replace(",", ".");
        double num1 = Double.parseDouble(operador1);
        String operador = partes[1];
        double num2 = Double.parseDouble(partes[2]);
        double resultado = operar(num1, num2, operador);
        String resultadoFormateado = resultadoStringFormat(resultado);

        return resultadoFormateado;
    }

    public static RoundedButton buscarBoton(JPanel panelDeBotones, String busqueda) {
        RoundedButton boton = new RoundedButton(null);
        bucleExterior:
        for (Component componente : panelDeBotones.getComponents()) {
            if (componente instanceof JPanel) {
                JPanel panelBoton = (JPanel) componente;
                Component[] botones_array = panelBoton.getComponents();
                for (Component componente_boton : botones_array) {
                    if (componente_boton instanceof RoundedButton) {
                        boton = (RoundedButton) componente_boton;
                        if (boton.getText().equals(busqueda)) {
                            break bucleExterior;
                        }
                    }
                }
            }
        }
        return boton;
    }
    
    public static void estadoBotonesParaOperadores(JPanel panelDeBotones, StringBuilder operacion, int numeros[], String operadores[]) {
        estadoBotones(panelDeBotones, operacion, "habilitado", "numeros", numeros, operadores);
        estadoBotones(panelDeBotones, operacion, "deshabilitado", "operadores", numeros, operadores);
        RoundedButton coma = buscarBoton(panelDeBotones, ",");
        RoundedButton igual = buscarBoton(panelDeBotones, "=");
        coma.setEnabled(true);
        igual.setEnabled(true);
    }

    public static void habilitarTodo(JPanel panelDeBotones, StringBuilder operacion, int numeros[], String operadores[]) {
        estadoBotones(panelDeBotones, operacion, "habilitado", "operadores", numeros, operadores);
        estadoBotones(panelDeBotones, operacion, "habilitado", "numeros", numeros, operadores);
    }
    
    public static void estadoBotones(JPanel panelDeBotones, StringBuilder operacion, String estado, String tipo, int numeros[], String operadores[]) {
        switch (tipo) {
            case "numeros":
            if (estado.equals("habilitado")) {
                for (int numero : numeros) {
                    RoundedButton botonNum = buscarBoton(panelDeBotones, String.valueOf(numero));
                    botonNum.setEnabled(true);
                }
            } else if (estado.equals("deshabilitado")) {
                for (int numero : numeros) {
                    RoundedButton botonNum = buscarBoton(panelDeBotones, String.valueOf(numero));
                    botonNum.setEnabled(false);
                }
            }
                break;

            case "operadores":
            if (estado.equals("habilitado")) {
                for (String operador : operadores) {
                    if (!operador.equals("C")) {
                        RoundedButton botonOp = buscarBoton(panelDeBotones, operador);
                        botonOp.setEnabled(true);
                    }
                }
            } else if (estado.equals("deshabilitado")) {
                for (String operador : operadores) {
                    if (!operador.equals("C")) {
                        RoundedButton botonOp = buscarBoton(panelDeBotones, operador);
                        botonOp.setEnabled(false);
                    }
                }
            }    
                break;
        }
    }

    public static String queBotonEs(String entrada) {
        if (esEntero(entrada)) {
            return "numero";
        } else if (entrada.equals("C")) {
            return "cancelar";
        } else if (entrada.equals("=")) {
            return "igual";
        } else if (entrada.equals(",")) {
            return "coma";
        } else {
            return "operador";
        }
    }

    public static void funcionBoton(JPanel panelDeBotones, String entrada, JTextPane pantalla, StringBuilder operacion, StringBuilder historialTxt, int numeros[], String operadores[]) {
        boolean pintar = false;
        String partes[] = separarOperacion(operacion);
        switch (queBotonEs(entrada)) {
            case "numero":
            int entradaEntero = Integer.parseInt(entrada);
            if (partes[partes.length - 1].contains(".")) {
                if (cantidadDecimales(partes[partes.length - 1]) == 1) {
                    estadoBotones(panelDeBotones, operacion, "deshabilitado", "numeros", numeros, operadores);
                }
                operacion.append(entradaEntero);
                pintar = true;
                estadoBotones(panelDeBotones, operacion, "habilitado", "operadores", numeros, operadores);
                RoundedButton coma = buscarBoton(panelDeBotones, ",");
                coma.setEnabled(false);
            } else {
                operacion.append(entradaEntero);
                pintar = true;
                estadoBotones(panelDeBotones, operacion, "habilitado", "operadores", numeros, operadores);
            }
                break;
        
            case "cancelar":
            operacion.setLength(0);
            habilitarTodo(panelDeBotones, operacion, numeros, operadores);
            repintarPantalla(pantalla, "0");
            pintar = false;
                break;
        
            case "igual":
            if (partes.length == 3) {
                String resultado = separarYOperar(operacion);
                pintar = false;
                repintarPantalla(pantalla, resultado);
                habilitarTodo(panelDeBotones, operacion, numeros, operadores);
                historialTxt.append(operacion.toString() + " = " + resultado + "%");
                operacion.setLength(0);
            }
                break;

            case "coma":
            if (operacion.length() == 0 && historialTxt.length() != 0 && !ultimoResultado(historialTxt).contains(",")) {
                String ultimmoResultado = ultimoResultado(historialTxt);
                operacion.append(ultimmoResultado + entrada);
            } else if (operacion.length() == 0 || partes.length == 2) {
                operacion.append("0.");
            } else {
                operacion.append(".");
            }
            estadoBotones(panelDeBotones, operacion, "deshabilitado", "operadores", numeros, operadores);
            pintar = true;
                break;
        
            case "operador":
            if (partes.length == 3) {
                String resultado = separarYOperar(operacion);
                historialTxt.append(operacion.toString() + " = " + resultado + "%");
                operacion.setLength(0);
                operacion.append(resultado + " " + entrada + " ");
            } else if (operacion.length() == 0 && historialTxt.length() != 0) {
                String ultimmoResultado = ultimoResultado(historialTxt);
                operacion.append(ultimmoResultado + " " + entrada + " ");
            } else if (operacion.length() != 0 && partes.length != 2) {
                operacion.append(" " + entrada + " ");
            }
            pintar = true;
            estadoBotonesParaOperadores(panelDeBotones, operacion, numeros, operadores);
                break;
        }
        if (pintar) {
            repintarPantalla(pantalla, operacion.toString());
        }
    }
    
    public static JTextPane repintarPantalla(JTextPane pantalla, String infoPantalla) {
        pantalla.setText(infoPantalla);
        pantalla.repaint();
        pantalla.revalidate();

        return pantalla;
    }
}