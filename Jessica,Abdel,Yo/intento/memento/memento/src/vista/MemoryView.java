package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MemoryView extends JFrame {
    private JPanel panelBotones;
    private JToggleButton[][] buttons;
    private int size;

    public MemoryView(int size) {
        this.size = size;
        setTitle("Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(size, size));
        buttons = new JToggleButton[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = new JToggleButton();
                panelBotones.add(buttons[i][j]);
            }
        }

        add(panelBotones, BorderLayout.CENTER);
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    public void addButtonListener(int row, int col, ActionListener listener) {
        buttons[row][col].addActionListener(listener);
    }

    public void revealButton(int row, int col, Color color) {
        buttons[row][col].setBackground(color);
        buttons[row][col].setOpaque(true);
        buttons[row][col].setContentAreaFilled(false);
        buttons[row][col].setSelected(true);
    }

    public void hideButton(int row, int col) {
        buttons[row][col].setBackground(Color.LIGHT_GRAY);
        buttons[row][col].setOpaque(true);
        buttons[row][col].setContentAreaFilled(false);
        buttons[row][col].setSelected(false);
    }

    public void disableButton(int row, int col) {
        buttons[row][col].setEnabled(false);
    }

    public void disableAllButtons() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public void enableAllButtons() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].setEnabled(true);
            }
        }
    }
}