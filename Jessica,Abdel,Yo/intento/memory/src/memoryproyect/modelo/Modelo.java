package memoryproyect.modelo;

import java.awt.*;
import java.util.*;

public class Modelo {
    private Color[][] tabla;
    private boolean[][] revelado;
    private int size = 4;
    private ArrayList<Color> colores;

    public Modelo() {
        tabla = new Color[size][size];
        revelado = new boolean[size][size];
        colores = new ArrayList<>();

        initializeColors();
        initializeBoard();
    }

    private void initializeColors() {
        colores.add(Color.RED);
        colores.add(Color.BLUE);
        colores.add(Color.GREEN);
        colores.add(Color.YELLOW);
        colores.add(Color.ORANGE);
        colores.add(Color.CYAN);
        colores.add(Color.MAGENTA);
        colores.add(Color.PINK);
    }

    private void initializeBoard() {
        ArrayList<Color> tablaColores = new ArrayList<>(colores);
        tablaColores.addAll(colores);
        Collections.shuffle(tablaColores);

        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tabla[i][j] = tablaColores.get(index++);
                revelado[i][j] = false;
            }
        }
    }

    public Color getColorAt(int row, int col) {
        return tabla[row][col];
    }

    public boolean isRevealed(int row, int col) {
        return revelado[row][col];
    }

    public void reveal(int row, int col) {
        revelado[row][col] = true;
    }

    public void hide(int row, int col) {
        revelado[row][col] = false;
    }
}