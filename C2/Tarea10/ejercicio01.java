import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.atomic.*;

public class ejercicio01 {
    public static void main(String[] args) {
        int numero[] = new int[1];
        AtomicBoolean jugar = new AtomicBoolean(false), mayor = new AtomicBoolean(false), menor = new AtomicBoolean(false), adivinado = new AtomicBoolean(false), error = new AtomicBoolean(false), caliente = new AtomicBoolean(false), frio = new AtomicBoolean(false);
        int intentos[] = new int[1];
        intentos[0] = 0;

        ImageIcon mayorImagen = imagen("imagenes/flecha-hacia-arriba.png");
        ImageIcon menorImagen = imagen("imagenes/flecha-hacia-abajo.png");
        ImageIcon adivinadoImagen = imagen("imagenes/enhorabuena.png");
        ImageIcon errorImagen = imagen("imagenes/error.png");
        ImageIcon calienteImagen = imagen("imagenes/caliente.png");
        ImageIcon frioImagen = imagen("imagenes/baja-temperatura.png");

        HashMap<String, ImageIcon> imagenes = new HashMap<>();
        imagenes.put("mayor", mayorImagen);
        imagenes.put("menor", menorImagen);
        imagenes.put("adivinado", adivinadoImagen);
        imagenes.put("error", errorImagen);
        imagenes.put("caliente", calienteImagen);
        imagenes.put("frio", frioImagen);

        JFrame frame = new JFrame();
        frame.setSize(500, 300);
        frame.setTitle("Adivina el número");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        antesDeJugar(frame, numero, jugar);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (jugar.get() == false) {
        }

        System.out.println(numero[0]);
        JPanel panelJuego = new JPanel(new GridBagLayout());
        GridBagConstraints p = new GridBagConstraints();
        p.fill = GridBagConstraints.BOTH;
        p.weightx = 1;
        p.weighty = 1;

        StringBuilder mensajeMostrar = new StringBuilder();
        StringBuilder intentosMostrar = new StringBuilder();
        // PANELES // 
        JPanel introduceNumTitul = new JPanel();
        introduceNumTitul.setBackground(Color.GRAY);
        JLabel introduce = new JLabel("Introduce un número para intentar adivinarlo");
        introduce.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        introduceNumTitul.add(introduce);

        JPanel numeroEntrante = new JPanel();
        introduceNumTitul.setBackground(Color.LIGHT_GRAY);
        JTextField numeroEntrada = new JTextField();
        numeroEntrada.setPreferredSize(new Dimension(50, 30));
        numeroEntrada.setHorizontalAlignment(SwingConstants.CENTER);
        Image checkImg = new ImageIcon("imagenes/check.png").getImage();
        checkImg = checkImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon checkImagen = new ImageIcon(checkImg);
        JButton botonIntento = new JButton(checkImagen);
        botonIntento.setSize(30, 30);
        botonIntento.setBorderPainted(false);
        botonIntento.setContentAreaFilled(false);
        numeroEntrante.add(numeroEntrada);
        numeroEntrante.add(botonIntento);

        JPanel mensajeSalida = new JPanel();
        mensajeSalida.setLayout(new BoxLayout(mensajeSalida, BoxLayout.Y_AXIS));
        mensajeSalida.setBackground(Color.GRAY);
        JLabel mensajeLabel = new JLabel("Haz algún intento ;)");
        mensajeLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mensajeLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        mensajeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel intentosLabel = new JLabel("Haz algún intento ;)");
        intentosLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        intentosLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        intentosLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel pista = new JPanel();
        pista.setBackground(Color.LIGHT_GRAY);

        botonIntento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menor.set(false);
                mayor.set(false);
                adivinado.set(false);
                error.set(false);
                caliente.set(false);
                frio.set(false);
                if (!numeroEntrada.getText().equals("")) {
                    int numeroIntroducido = 0;
                    try {
                        numeroIntroducido = Integer.parseInt(numeroEntrada.getText());
                        mensajeMostrar.setLength(0);
                        intentosMostrar.setLength(0);
                    } catch (NumberFormatException exception) {
                        mensajeMostrar.setLength(0);
                        mensajeMostrar.append("Entrada inválida. Debes ingresar un número.");
                        vibrar(frame);
                        error.set(true);
                    }
                    if (numeroIntroducido < numero[0]) {
                        intentos[0]++;
                        mensajeMostrar.append("El número introducido es menor que el número a adivinar");
                        intentosMostrar.append("Intentos: " + String.valueOf(intentos[0]));
                        vibrar(frame);
                        menor.set(true);
                    } else if (numeroIntroducido > numero[0]) {
                        intentos[0]++;
                        mensajeMostrar.append("El número introducido es mayor que el número a adivinar");
                        intentosMostrar.append("Intentos: " + String.valueOf(intentos[0]));
                        vibrar(frame);
                        mayor.set(true);
                    } else if (numeroIntroducido > 500 || numeroIntroducido < 1) {
                        mensajeMostrar.append("El valor esta fuera de los rangos [1, 500]");
                        vibrar(frame);
                        error.set(true);
                    } else {
                        intentos[0]++;
                        mensajeMostrar.append("¡Enhorabuena, has adivinado el número en");
                        intentosMostrar.append(String.valueOf(intentos[0]) + " intentos");
                        adivinado.set(true);
                    }
                    if(numeroIntroducido > (numero[0]-25) && numeroIntroducido < (numero[0]+25)) {
                        caliente.set(true);
                        frio.set(false);
                    } else {
                        frio.set(true);
                        caliente.set(false);
                    }
                } else {
                    mensajeMostrar.setLength(0);
                    mensajeMostrar.append("Introduce un valor para comparar");
                    vibrar(frame);
                    error.set(true);
                }

                mensajeLabel.setText(mensajeMostrar.toString());
                intentosLabel.setText(intentosMostrar.toString());
                mensajeSalida.add(mensajeLabel);
                mensajeSalida.add(intentosLabel);

                pista.removeAll();
                if (adivinado.get()) {
                    ImageIcon img = imagenes.get("adivinado");
                    JLabel imagen = new JLabel(img);
                    pista.add(imagen);
                } else if (error.get()) {
                    ImageIcon img = imagenes.get("error");
                    JLabel imagen = new JLabel(img);
                    pista.add(imagen);
                } else if (mayor.get()) {
                    ImageIcon img = imagenes.get("mayor");
                    JLabel imagen = new JLabel(img);
                    pista.add(imagen);
                } else if (menor.get()) {
                    ImageIcon img = imagenes.get("menor");
                    JLabel imagen = new JLabel(img);
                    pista.add(imagen);
                }

                if (!adivinado.get() && caliente.get()) {
                    ImageIcon img = imagenes.get("caliente");
                    JLabel imagen = new JLabel(img);
                    pista.add(imagen);
                } else if (!adivinado.get() && frio.get()) {
                    ImageIcon img = imagenes.get("frio");
                    JLabel imagen = new JLabel(img);
                    pista.add(imagen);
                }

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.revalidate();
                frame.repaint();
            }
        });

        p.gridx = 0;
        p.gridy = 0;
        panelJuego.add(introduceNumTitul, p);
        p.gridy = 1;
        panelJuego.add(numeroEntrante, p);
        p.gridy = 2;
        panelJuego.add(mensajeSalida, p);
        p.gridy = 3;
        panelJuego.add(pista, p);

        frame.add(panelJuego);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void antesDeJugar(JFrame frame, int numero[], AtomicBoolean jugar) {
        JPanel panelEmpezar = new JPanel();
        Color colorSemiTransparente = new Color(254, 79, 183, 128);
        panelEmpezar.setBackground(colorSemiTransparente);
        panelEmpezar.setAlignmentX(Component.CENTER_ALIGNMENT);

        Image iniciarImg = new ImageIcon("imagenes/boton-de-inicio.png").getImage();
        iniciarImg = iniciarImg.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon iconoInicar = new ImageIcon(iniciarImg);
        JLabel adivina = new JLabel("¡Adivina el numero!");
        adivina.setFont(new Font(Font.MONOSPACED, Font.BOLD, 32));
        adivina.setForeground(Color.BLACK);
        JLabel labelImg = new JLabel(iconoInicar);

        panelEmpezar.setAlignmentY(Component.TOP_ALIGNMENT);
        panelEmpezar.add(adivina);

        panelEmpezar.setAlignmentY(Component.CENTER_ALIGNMENT);
        panelEmpezar.add(labelImg);

        panelEmpezar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelEmpezar.setVisible(false);
                numero[0] = (int) (Math.random() * 500 + 1);
                jugar.set(true);
            }
        });

        frame.add(panelEmpezar);
    }

    public static ImageIcon imagen(String ruta) {
        Image img = new ImageIcon(ruta).getImage();
        img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(img);
        return imagen;
    }

    public static void vibrate(JFrame frame) {
        final int originalX = frame.getLocation().x;
        final int originalY = frame.getLocation().y;
        final int shakeDistance = 5; // Distancia del movimiento
        final int shakeDuration = 10; // Duración en milisegundos
        final int shakeCount = 10; // Número de veces que se mueve

        Timer timer = new Timer(shakeDuration, new ActionListener() {
            int count = 0;
            boolean movedRight = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count >= shakeCount) {
                    ((Timer) e.getSource()).stop();
                    frame.setLocation(originalX, originalY); // Restaurar la posición original
                } else {
                    int deltaX = movedRight ? shakeDistance : -shakeDistance;
                    frame.setLocation(originalX + deltaX, originalY);
                    movedRight = !movedRight;
                    count++;
                }
            }
        });

        timer.start();
    }

    public static void vibrar(JFrame frame) {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Timer) e.getSource()).stop();
                vibrate(frame);
            }
        }).start();

    }
}