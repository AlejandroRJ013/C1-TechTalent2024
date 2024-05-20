import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.*;

public class calculadoraPruebas {
    public static void main(String args[]) {
        int numeros[] = {7,8,9,4,5,6,1,2,3,0};
        String operadores[] = {"()", "+/-", "(n)!", "<--", "/","*","-", ",", "+", "C", "="};
        StringBuilder historialTxt = new StringBuilder();
        StringBuilder operacion = new StringBuilder();
        boolean ultimoNumParentesis = false;
        double operadoresNumeros[] = new double[2];
        String operador = "";

        // VENTANA //

        JFrame frame = new JFrame("¡MAS! - Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);

        // BARRA DE NAVEGACIÓN //

        JMenuBar nav = new JMenuBar();
        JMenu opciones = new JMenu("Opciones");
        JMenuItem historial = new JMenuItem("Historial");
        JMenuItem sobreNosotros = new JMenuItem("Sobre Nosotros");
        JMenuItem salir = new JMenuItem("Salir");

        historial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Crear un JEditorPane para mostrar contenido HTML
        JEditorPane panelHTML = new JEditorPane();
        panelHTML.setPreferredSize(new Dimension(300, 300));
        panelHTML.setContentType("text/html"); // Establecer el tipo de contenido como HTML
        panelHTML.setEditable(false);

        // Definir el contenido HTML a mostrar
        String paginaSobreNosotros = "<html><body><h1>¡MAS! Sobre nosotros</h1><p>Nuestra asociación políca <b>con ánimo de lucro</b> esta conformada por:<br>    -  Manel<br>    -  Sabastian<br>    -  Alejandro<br>Nuestras medidas son... <small>(CENSURADO)</small></p></body></html>";
        panelHTML.setText(paginaSobreNosotros);

        // Panel para mostrar el historial
        JPanel panelHistorial = new JPanel();
        panelHistorial.setLayout(new BoxLayout(panelHistorial, BoxLayout.Y_AXIS));

        // panelHistorial.setLayout(new BoxLayout(panelHistorial, BoxLayout.Y_AXIS));
        panelHistorial.setPreferredSize(new Dimension(300, 300));

        JPanel tituloHistorial = new JPanel();
        tituloHistorial.setBackground(Color.GRAY);

        JLabel tituloLabel = new JLabel("Historial");
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 25));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

        tituloHistorial.add(tituloLabel);
        panelHistorial.add(tituloHistorial);

        historial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String operaciones[] = historialTxt.toString().split("/");
                JPanel operacionesPanel = new JPanel();
                operacionesPanel.setLayout(new GridBagLayout());
                operacionesPanel.setBackground(Color.LIGHT_GRAY);

                GridBagConstraints posicion = new GridBagConstraints();
                posicion.fill = GridBagConstraints.BOTH;
                posicion.weightx = 1;
                posicion.weighty = 1;

                int pos = 0;
                for (String op : operaciones) {
                    JLabel operacionLabel = new JLabel(op);
                    operacionLabel.setFont(new Font("Arial", Font.BOLD, 15));
                    operacionLabel.setHorizontalAlignment(SwingConstants.LEFT);

                    posicion.gridy = pos;
                    operacionesPanel.add(operacionLabel, posicion);
                    pos++;
                }
                panelHistorial.add(operacionesPanel);

                JOptionPane.showOptionDialog(null, new JScrollPane(panelHistorial), "Historial", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            }
        });

        sobreNosotros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showOptionDialog(null, new JScrollPane(panelHTML), "¡MAS! Sobre nosotros y nuestro partido político", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
                // JOptionPane.showMessageDialog(null, panelSobreNosotros, "¡MAS! Sobre nosotros y nuestro partido político", JOptionPane.PLAIN_MESSAGE);
            }
        });

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        opciones.add(historial);
        opciones.add(sobreNosotros);
        opciones.add(salir);
        nav.add(opciones);
        frame.setJMenuBar(nav);

        // BARRA DE NAVEGACIÓN //

        // PANTALLA DE CÁLCULO //

        JPanel panelDePaneles = new JPanel();
        panelDePaneles.setLayout(new BoxLayout(panelDePaneles, BoxLayout.Y_AXIS));
        panelDePaneles.setBorder(new EmptyBorder(10, 20, 10, 20));

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
        panelDeBotones.setLayout(new GridBagLayout());

        GridBagConstraints carCelda = new GridBagConstraints();
        carCelda.fill = GridBagConstraints.BOTH;
        carCelda.weightx = 1;
        carCelda.weighty = 1;

        // CREACIÓN DE LOS BOTONES //

        Border separacionBotones = BorderFactory.createEmptyBorder(2, 2, 2, 2);
        int num_cel = 0;
        int indice_op = 0;
        int indice_nu = 0;
        boolean doble = false;

        for (int j = 1; j <= 6; j++) {
            for (int i = 1; i <= 4; i++) {
                if (num_cel == 17 || num_cel == 19 || num_cel == 20) {
                    carCelda.gridwidth = 2;
                    doble = true;
                } else {
                    carCelda.gridwidth = 1;
                    doble = false;
                }
                
                if (!(i%4 == 0) && !(num_cel == 16) && !(j == 1) && !(j == 6)) {
                    JPanel panelBoton = new JPanel(new BorderLayout()); 
                    panelBoton.setBorder(separacionBotones); 

                    RoundedButton boton = new RoundedButton(String.valueOf(numeros[indice_nu]), 25, "numeros");
                    boton = caracteristicasBotones(boton);

                    panelBoton.add(boton, BorderLayout.CENTER);
                    carCelda.gridx = i;
                    carCelda.gridy = j;
                    panelDeBotones.add(panelBoton, carCelda);

                    indice_nu++;
                } else {
                    JPanel panelBoton = new JPanel(new BorderLayout()); 
                    panelBoton.setBorder(separacionBotones); 

                    RoundedButton boton = new RoundedButton(null);
                    switch (num_cel) {
                        case 16:
                            boton = new RoundedButton(operadores[indice_op], 25, "coma");
                            boton = caracteristicasBotones(boton);
                            break;
                    
                        case 19:
                            boton = new RoundedButton(operadores[indice_op], 25, "cancelar");
                            boton = caracteristicasBotones(boton);
                            break;
                    
                        case 20:
                            boton = new RoundedButton(operadores[indice_op], 25, "resultado");
                            boton = caracteristicasBotones(boton);
                            break;
                    
                        default:
                            boton = new RoundedButton(operadores[indice_op], 25, "string");
                            boton = caracteristicasBotones(boton);
                            break;
                    }

                    panelBoton.add(boton, BorderLayout.CENTER);
                    carCelda.gridx = i;
                    carCelda.gridy = j;
                    panelDeBotones.add(panelBoton, carCelda);

                    indice_op++;
                }
                if (doble) {
                    i++;
                }

                num_cel++;
            }
        }
        panelDePaneles.add(panelDeBotones);

        // CREACIÓN DE LOS BOTONES //

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
                                funcionBoton(panelDeBotones, pantalla, boton.getText(), operadoresNumeros, operador, ultimoNumParentesis, operacion, historialTxt, numeros, operadores);
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

    public static JTextPane repintarPantalla(JTextPane pantalla, String infoPantalla) {
        pantalla.setText(infoPantalla);
        pantalla.repaint();
        pantalla.revalidate();
        return pantalla;
    }

    public static RoundedButton caracteristicasBotones(RoundedButton boton) {
        boton.setBorder(new EmptyBorder(2,2,2,2));
        boton.setFont(new Font("Arial", Font.BOLD, 24));
        return boton;
    }
    
    public static int factorial(int fac) {
        int resul = fac;
        for (int operador = (fac-1); operador >= 1; operador--) {
            resul *= operador;
        }
        return resul;
    }
    
    public static boolean esEntero(String entrada) {
        if (entrada.matches("\\d+(.\\d+)?")) {
            return true;
        } else {
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

    public static String[] separarOperacion(StringBuilder operacion) {
        String operacionStr = operacion.toString();
        String posibleDespuesDeParentesis = "";
        if (operacionStr.contains("(")) {
            String partesOperacion[] = operacionStr.split("\\(", 2);
            String partesOperacion2[] = partesOperacion[1].split("\\)", 2);
            try {
                posibleDespuesDeParentesis = partesOperacion2[1];
            } catch (Exception e) {}
            operacionStr = partesOperacion[0] + " 0 " + posibleDespuesDeParentesis;
        }
        String partes[] = operacionStr.split("\\s+");
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

    // NO SE UTILIZA
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
        boolean parar = false;
        for (Component componente : panelDeBotones.getComponents()) {
            if (componente instanceof JPanel) {
                JPanel panelBoton = (JPanel) componente;
                Component[] botones_array = panelBoton.getComponents();
                for (Component componente_boton : botones_array) {
                    if (componente_boton instanceof RoundedButton) {
                        boton = (RoundedButton) componente_boton;
                        if (boton.getText().equals(busqueda)) {
                            parar = true;
                            break;
                        }
                    }
                }
            }
            if (parar) {
                break;
            }
        }
        return boton;
    }

    
    public static void estadoBotones(JPanel panelDeBotones, StringBuilder operacion, String estado, String tipo, int numeros[], String operadores[]) {
        switch (tipo) {
                case "numeros":
                switch (estado) {
                    case "habilitado":
                        for (int numero : numeros) {
                            RoundedButton botonNum = buscarBoton(panelDeBotones, String.valueOf(numero));
                            botonNum.setEnabled(true);
                        }
                        break;
                
                    case "deshabilitado":
                        for (int numero : numeros) {
                            RoundedButton botonNum = buscarBoton(panelDeBotones, String.valueOf(numero));
                            botonNum.setEnabled(false);
                        }
                        break;
                
                    default:
                        break;
                }
                break;
            
            case "operadores":
                switch (estado) {
                    case "habilitado":
                        for (String operador : operadores) {
                            if (!operador.equals("C")) {
                                RoundedButton botonOp = buscarBoton(panelDeBotones, operador);
                                botonOp.setEnabled(true);
                            }
                        }
                        break;
                
                    case "deshabilitado":
                        for (String operador : operadores) {
                            if (!operador.equals("C")) {
                                RoundedButton botonOp = buscarBoton(panelDeBotones, operador);
                                botonOp.setEnabled(false);
                            }
                        }
                        break;
                
                    default:
                        break;
                }        
                break;
            
            default:
                break;
        }
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
    
    public static String ultimoStringOperacion(StringBuilder operacion) {
        String partes[] = separarOperacion(operacion);
        switch (partes.length) {
            case 1:
            case 3:
                return partes[partes.length - 1];                
            default:
                return "";
        }
    }

    public static boolean escribiendoComa(StringBuilder operacion) {
        String ultimo = ultimoStringOperacion(operacion);
        if (ultimo.contains(".")) {
            return true;
        } else {
            return false;
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
        } else if (entrada.equals("(n)!")) {
            return "factorial";
        } else if (entrada.equals("<--")) {
            return "borrar";
        } else if (entrada.equals("()")) {
            return "parentesis";
        } else if (entrada.equals("+/-")) {
            return "negacion";
        } else {
            return "operador";
        }
    }

    public static void funcionBoton(JPanel panelDeBotones, JTextPane pantalla, String entrada, double operadoresNumeros[], String operador, boolean ultimoNumParentesis, StringBuilder operacion, StringBuilder historialTxt, int numeros[], String operadores[]) {
        String partes[] = separarOperacion(operacion);
        String ultimo = ultimoStringOperacion(operacion); 

        // HACER COSAS PARENTESIS Y NEGACION, LO DEMAS FUNCIONA. ¡DOCUMENTA!

        double operador1 = 0;
        double operador2 = 0;

        if (partes.length == 3 && entrada.matches("[+\\-*/]")) {
            operador1 = operadoresNumeros[0];
            operador2 = operadoresNumeros[1];
            double resultado = operar(operador1, operador2, operador);
            String resultadoFormateado = resultadoStringFormat(resultado);
            repintarPantalla(pantalla, resultadoFormateado);
            habilitarTodo(panelDeBotones, operacion, numeros, operadores);
            historialTxt.append(operacion.toString() + " = " + resultado + "/");
            operacion.setLength(0);
        }

        switch (queBotonEs(entrada)) {
            case "numero":
            if (escribiendoComa(operacion)) {
                String partesNumero[] = ultimo.split("\\.");
                if (partesNumero.length > 1) {
                    if (partesNumero[1].length() == 1) {
                        estadoBotones(panelDeBotones, operacion, "deshabilitado", "numeros", numeros, operadores);
                    }
                }
                operacion.append(Integer.parseInt(entrada));
                repintarPantalla(pantalla, operacion.toString());
                estadoBotones(panelDeBotones, operacion, "habilitado", "operadores", numeros, operadores);
                RoundedButton coma = buscarBoton(panelDeBotones, ",");
                coma.setEnabled(false);
            } else {
                operacion.append(Integer.parseInt(entrada));
                repintarPantalla(pantalla, operacion.toString());
                estadoBotones(panelDeBotones, operacion, "habilitado", "operadores", numeros, operadores);
            }
                break;
        
            case "coma":
            if (partes.length == 0 || partes.length == 2) {
                operacion.append("0.");
            } else {
                operacion.append(".");
            }
            estadoBotones(panelDeBotones, operacion, "deshabilitado", "operadores", numeros, operadores);
            repintarPantalla(pantalla, operacion.toString());
            break;
            
            case "operador":
            if (operacion.length() == 0 && historialTxt.length() != 0) {
                System.out.println("d");
                String operaciones[] = historialTxt.toString().split("/");
                String resultado[] = operaciones[operaciones.length-1].split(" = ");
                operadoresNumeros[0] = Double.parseDouble(resultado[resultado.length-1]);
                operador = entrada;
                operacion.append(resultado[resultado.length-1] + " " + entrada + " ");
                repintarPantalla(pantalla, operacion.toString());
                estadoBotonesParaOperadores(panelDeBotones, operacion, numeros, operadores);
            } else if (operacion.toString().contains("(")) {
                ultimoNumParentesis = true;
                operacion.append(" " + entrada + " ");
                repintarPantalla(pantalla, operacion.toString());
                estadoBotonesParaOperadores(panelDeBotones, operacion, numeros, operadores);
            } else if (partes.length != 0) {
                operadoresNumeros[0] = Double.parseDouble(partes[0]);
                operador = entrada;
                operacion.append(" " + entrada + " ");
                repintarPantalla(pantalla, operacion.toString());
                estadoBotonesParaOperadores(panelDeBotones, operacion, numeros, operadores);
            }
                break;
        
            case "negacion":
                break;
        
            case "factorial":
            String[] numero = separarOperacion(operacion);
            if (esEntero(ultimo)) {
                int entero = Integer.parseInt(numero[0]);
                int fact = factorial(entero);
                operacion.setLength(0);
                operacion.append(fact);
                repintarPantalla(pantalla, String.valueOf(fact));
            }
                break;
        
                // HACER COSAS PARENTESIS//
            case "parentesis":
            if (esEntero(ultimo)) {
                operadoresNumeros[0] = Integer.parseInt(partes[0]);
                operacion.append(" * (");
            } else {
                try {
                operadoresNumeros[0] = Integer.parseInt(partes[0]);
                } catch (Exception e) {}
                operacion.append(" (");
            }
            estadoBotones(panelDeBotones, operacion, "deshabilitado", "operadores", numeros, operadores);
                break;
            
                // HACER COSAS PARENTESIS//
            case "igual":
            if (partes.length == 3) {
                operador2 = Double.parseDouble(partes[2]);
                operador1 = operadoresNumeros[0];
                double resultado = operar(operador1, operador2, operador);
                String resultadoFormateado = resultadoStringFormat(resultado);
                repintarPantalla(pantalla, resultadoFormateado);
                habilitarTodo(panelDeBotones, operacion, numeros, operadores);
                historialTxt.append(operacion.toString() + " = " + resultado + "/");
                operacion.setLength(0);
            }
                break;
        
            case "borrar": 
            if (operacion.length() == 0 || operacion.toString().equals("0")) {
            } else if (operacion.length() == 1 && !operacion.toString().equals("0")) {
                operacion.setLength(operacion.length()-1);
                repintarPantalla(pantalla, "0");
            } else {
                operacion.setLength(operacion.length()-1);
                repintarPantalla(pantalla, operacion.toString());
            }               
                break;
        
            case "cancelar":
            operacion.setLength(0);
            habilitarTodo(panelDeBotones, operacion, numeros, operadores);
            repintarPantalla(pantalla, "0");
                break;
        
            default:
                break;
        }
    }
}