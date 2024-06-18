package com.ejercicio01.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PanelVistaActualizado extends JPanel {
    private static JTable table1;
    private static JTable table2;
    private static DefaultTableModel tableModel1;
    private static DefaultTableModel tableModel2;

    public PanelVistaActualizado() {
        setLayout(new GridLayout(1, 1));
        setBorder(new LineBorder(Color.BLACK, 2));
        setPreferredSize(new Dimension(400, getHeight()));

        JPanel panelVista1 = new JPanel(new GridLayout(1, 1));
        panelVista1.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelVista1.setBackground(Color.decode("#b9ddff"));

        JPanel panelVistaLinea = new JPanel(new GridLayout(1, 1));
        panelVistaLinea.setBorder(new LineBorder(Color.BLACK, 2));

        JPanel panelVista2 = new JPanel(new GridLayout(2, 1, 0, 10));

        JPanel tabla1 = new JPanel(new BorderLayout());
        JPanel tabla2 = new JPanel(new BorderLayout());

        panelVista2.add(tabla1);
        panelVista2.add(tabla2);
        panelVistaLinea.add(panelVista2);
        panelVista1.add(panelVistaLinea);
        add(panelVista1);

        // Agregar las tablas
        table1 = initTable();
        table2 = initTable();
        tabla1.add(new JScrollPane(table1), BorderLayout.CENTER);
        tabla2.add(new JScrollPane(table2), BorderLayout.CENTER);
    }

    private JTable initTable() {
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[] { "Id", "Nombre", "Apellidos", "Direccion", "DNI", "Fecha" }, 0);
        JTable table = new JTable(tableModel);
        return table;
    }

    private static void ajustarAnchoColumnas(JTable table) {
        for (int col = 0; col < table.getColumnCount(); col++) {
            TableColumn column = table.getColumnModel().getColumn(col);
            int preferredWidth = calcularAnchoColumna(table, col);
            column.setPreferredWidth(preferredWidth);
        }
    }

    private static int calcularAnchoColumna(JTable table, int colIndex) {
        int width = 0;
        TableColumn column = table.getColumnModel().getColumn(colIndex);
        Component comp = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table,
                column.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;
        for (int row = 0; row < table.getRowCount(); row++) {
            comp = table.getCellRenderer(row, colIndex).getTableCellRendererComponent(table,
                    table.getValueAt(row, colIndex), false, false, row, colIndex);
            width = Math.max(width, comp.getPreferredSize().width);
        }
        return width + 10; // Espacio extra para margen
    }

    // Método para actualizar los datos de la tabla
    public static void actualizarTabla1(ArrayList<ArrayList<String>> datosTabla) {
        DefaultTableModel tableModel1 = (DefaultTableModel) table1.getModel();
        tableModel1.setRowCount(0);
        for (ArrayList<String> fila : datosTabla) {
            tableModel1.addRow(fila.toArray(new Object[0]));
        }
        ajustarAnchoColumnas(table1);
    }

    public static void actualizarTabla2(ArrayList<ArrayList<String>> datosTabla) {
        DefaultTableModel tableModel2 = (DefaultTableModel) table2.getModel();
        tableModel2.setRowCount(0);
        for (ArrayList<String> fila : datosTabla) {
            tableModel2.addRow(fila.toArray(new Object[0]));
        }
        ajustarAnchoColumnas(table2);
    }
}