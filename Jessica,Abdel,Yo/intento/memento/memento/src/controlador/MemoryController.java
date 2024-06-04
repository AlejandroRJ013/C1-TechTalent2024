package controlador;

import modelo.*;
import vista.*;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class MemoryController {
    private MemoryModel model;
    private MemoryView view;
    private int firstRow, firstCol, secondRow, secondCol;
    private boolean firstSelection;
    private int[] successfulButtons;
    private int indexSuccessful = 0;

    public MemoryController(MemoryModel model, MemoryView view) {
        this.model = model;
        this.view = view;
        this.firstSelection = true;
        successfulButtons = new int[model.getSize() * 2];

        for (int i = 0; i < model.getSize(); i++) {
            for (int j = 0; j < model.getSize(); j++) {
                int row = i;
                int col = j;
                view.addButtonListener(row, col, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(row, col);
                    }
                });
            }
        }

        view.setVisible(true);
    }

    private void handleButtonClick(int row, int col) {
        if (firstSelection) {
            firstRow = row;
            firstCol = col;
            view.revealButton(row, col, model.getColorAt(row, col));
            model.reveal(row, col);
            firstSelection = false;
        } else {
            view.disableAllButtons();

            secondRow = row;
            secondCol = col;
            view.revealButton(row, col, model.getColorAt(row, col));
            model.reveal(row, col);

            if (model.getColorAt(firstRow, firstCol).equals(model.getColorAt(secondRow, secondCol))
                    && !model.getColorAt(firstRow, firstCol).equals(Color.LIGHT_GRAY)) {
                view.disableButton(firstRow, firstCol);
                view.disableButton(secondRow, secondCol);
                successfulButtons[indexSuccessful++] = firstRow;
                successfulButtons[indexSuccessful++] = firstCol;
                successfulButtons[indexSuccessful++] = secondRow;
                successfulButtons[indexSuccessful++] = secondCol;
            } else {
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        view.hideButton(firstRow, firstCol);
                        view.hideButton(secondRow, secondCol);
                        model.hide(firstRow, firstCol);
                        model.hide(secondRow, secondCol);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            view.enableAllButtons();
            int rowNew = 0;
            int colNew = 0;
            for (int rowCol : successfulButtons) {
                if (col != 0) {
                    view.disableButton(rowNew, colNew);
                    rowNew = 0;
                    colNew = 0;
                } else if (row != 0) {
                    colNew = rowCol;
                } else {
                    rowNew = rowCol;
                }
            }

            firstSelection = true;
        }
    }
}