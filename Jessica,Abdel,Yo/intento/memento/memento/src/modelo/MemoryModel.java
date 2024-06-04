package modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryModel {
    private Color[][] board;
    private boolean[][] revealed;
    private int size;
    private ArrayList<Color> colors;

    public MemoryModel(int size) {
        this.size = size;
        board = new Color[size][size];
        revealed = new boolean[size][size];
        colors = new ArrayList<>();

        initializeColors();
        initializeBoard();
    }

    private void initializeColors() {
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.ORANGE);
        colors.add(Color.CYAN);
        colors.add(Color.MAGENTA);
        colors.add(Color.PINK);
    }

    private void initializeBoard() {
        ArrayList<Color> boardColors = new ArrayList<>(colors);
        boardColors.addAll(colors);
        Collections.shuffle(boardColors);

        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = boardColors.get(index++);
                revealed[i][j] = false;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Color getColorAt(int row, int col) {
        return board[row][col];
    }

    public boolean isRevealed(int row, int col) {
        return revealed[row][col];
    }

    public void reveal(int row, int col) {
        revealed[row][col] = true;
    }

    public void hide(int row, int col) {
        revealed[row][col] = false;
    }
}
