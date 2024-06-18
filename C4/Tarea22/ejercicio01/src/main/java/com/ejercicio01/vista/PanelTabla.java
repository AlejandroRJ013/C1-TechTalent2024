package com.ejercicio01.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class PanelTabla extends JPanel {

    private static JTable table;
    private static DefaultTableModel tableModel;

    public PanelTabla(int row, int col, ArrayList<String> nombres) {
        setLayout(new BorderLayout());

        // Asegúrate de que haya al menos 4 filas
        row = Math.max(row, 5);

        // Crear el modelo de la tabla con los nombres de las columnas
        tableModel = new DefaultTableModel(new Object[row][col], nombres.toArray());
        table = new JTable(tableModel);

        table.setEnabled(false);

        // Configurar el aspecto de la tabla
        table.getTableHeader().setBackground(Color.decode("#b08e6b"));
        table.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        table.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        table.setBackground(Color.decode("#e8c39e"));
        table.setRowHeight(30);

        // Ajustar el ancho de las columnas según el contenido
        ajustarAnchoColumnas();

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Crear un JPanel contenedor para establecer tamaño máximo
        JPanel scrollPanel = new JPanel(new BorderLayout());
        scrollPanel.setPreferredSize(new Dimension(468, 160));
        scrollPanel.setMaximumSize(new Dimension(468, 160));
        scrollPanel.add(scrollPane, BorderLayout.CENTER);

        // Agregar el panel contenedor al panel principal
        add(scrollPanel, BorderLayout.CENTER);
    }

    private static void ajustarAnchoColumnas() {
        for (int col = 0; col < table.getColumnCount(); col++) {
            TableColumn column = table.getColumnModel().getColumn(col);
            int preferredWidth = calcularAnchoColumna(col);
            column.setPreferredWidth(preferredWidth);
        }
    }

    private static int calcularAnchoColumna(int colIndex) {
        int width = 0;
        TableColumn column = table.getColumnModel().getColumn(colIndex);
        Component comp = table.getTableHeader().getDefaultRenderer()
                .getTableCellRendererComponent(table, column.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;
        for (int row = 0; row < table.getRowCount(); row++) {
            comp = table.getCellRenderer(row, colIndex)
                    .getTableCellRendererComponent(table, table.getValueAt(row, colIndex), false, false, row, colIndex);
            width = Math.max(width, comp.getPreferredSize().width);
        }
        return width + 10; // Espacio extra para margen
    }

    // Método para actualizar los datos de la tabla
    public static void actualizarTabla(ArrayList<ArrayList<String>> datosTabla) {
        tableModel.setRowCount(0);
        for (ArrayList<String> fila : datosTabla) {
            tableModel.addRow(fila.toArray(new Object[0]));
        }
        ajustarAnchoColumnas();
    }

    public static void actualizarTablaEncabezados(ArrayList<ArrayList<String>> datos, ArrayList<String> encabezados) {
        // Limpiar el modelo actual
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);

        // Establecer los nuevos encabezados
        for (String encabezado : encabezados) {
            tableModel.addColumn(encabezado);
        }

        // Añadir los nuevos datos
        for (ArrayList<String> fila : datos) {
            tableModel.addRow(fila.toArray());
        }

        // Actualizar la tabla
        table.setModel(tableModel);
    }

    // Método para obtener los datos actuales de la tabla
    public ArrayList<ArrayList<Object>> getTableData() {
        ArrayList<ArrayList<Object>> data = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            ArrayList<Object> rowData = new ArrayList<>();
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                rowData.add(tableModel.getValueAt(i, j));
            }
            data.add(rowData);
        }
        return data;
    }
}
