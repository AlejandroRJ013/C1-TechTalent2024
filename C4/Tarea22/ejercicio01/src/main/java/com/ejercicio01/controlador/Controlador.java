package com.ejercicio01.controlador;

import com.ejercicio01.*;
import com.ejercicio01.modelo.*;
import com.ejercicio01.vista.*;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Controlador {
    private Connection conec;
    private Modelo modelo;
    private Ventana ventana;
    private int columnas;
    private ArrayList<String> nombres;
    private ArrayList<String> valores;

    public Controlador(Modelo model, Ventana vent) {
        modelo = model;
        ventana = vent;
        columnas = BasesDeDatos.cantidadColumnas(modelo.getConexion(), modelo.getTable());
        nombres = BasesDeDatos.recogerNombresColumnas(modelo.getConexion(), modelo.getTable());
        valores = new ArrayList<>();
        conec = modelo.getConexion();
        PanelBotones.setListeners(new AccionesInsert(), new AccionesUpdate(), new AccionesSelect(),
                new AccionesDelete());
        PanelElegirTabla.addListenerMostrarTabla(new ActualizarTabla());
    }

    public class AccionesInsert implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    PanelInsertar insertar = new PanelInsertar(columnas, nombres, valores);
                    insertar.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            String columnasAfectadas = insertar.getColumnasAfectadas();
                            String values = insertar.getValoresIntroducidos();
                            conec = BasesDeDatos.insertarValues(conec, modelo.getDatabase(), modelo.getTable(),
                                    columnasAfectadas, values);
                            ArrayList<ArrayList<String>> datosTabla = BasesDeDatos.recogerValoresTabla(conec,
                                    modelo.getTable());
                            PanelTabla.actualizarTabla(datosTabla);
                            PanelConsola.setEntradaConsola(BasesDeDatos.getTextoConsola());
                        }
                    });
                }
            });
        }
    }

    public class AccionesSelect implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    PanelSelect select = new PanelSelect();
                    select.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            String query = select.getQuery();
                            conec = BasesDeDatos.hacerSelect(conec, query);
                            ArrayList<ArrayList<String>> datosTabla = BasesDeDatos.recogerValoresTabla(conec,
                                    modelo.getTable());
                            PanelTabla.actualizarTabla(datosTabla);
                            PanelConsola.setEntradaConsola(BasesDeDatos.getTextoConsola());
                        }
                    });
                }
            });
        }
    }

    public class AccionesUpdate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    PanelUpdate update = new PanelUpdate();
                    update.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            String queryUpdate = update.getQueryUpdate();
                            String querySelect = update.getQuerySelect();
                            int confirmacion = JOptionPane.showConfirmDialog(null,
                                    "¿Deseas ejecutar el comando SQL?\n\n " + queryUpdate, "Confirmación",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                            if (confirmacion == JOptionPane.YES_OPTION) {
                                conec = BasesDeDatos.hacerUpdate(conec, queryUpdate, querySelect);
                                ArrayList<ArrayList<String>> datosTabla = BasesDeDatos.recogerValoresTabla(conec,
                                        modelo.getTable());
                                PanelTabla.actualizarTabla(datosTabla);
                                PanelConsola.setEntradaConsola(BasesDeDatos.getTextoConsola());
                            }
                        }
                    });
                }
            });
        }
    }

    public class AccionesDelete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    PanelDelete delete = new PanelDelete();
                    delete.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            String queryDelete = delete.getQueryDelete();
                            String querySelect = delete.getQuerySelect();
                            int confirmacion = JOptionPane.showConfirmDialog(null,
                                    "¿Deseas ejecutar el comando SQL?\n\n " + queryDelete, "Confirmación",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                            if (confirmacion == JOptionPane.YES_OPTION) {
                                conec = BasesDeDatos.hacerUpdate(conec, queryDelete, querySelect);
                                ArrayList<ArrayList<String>> datosTabla = BasesDeDatos.recogerValoresTabla(conec,
                                        modelo.getTable());
                                PanelTabla.actualizarTabla(datosTabla);
                                PanelConsola.setEntradaConsola(BasesDeDatos.getTextoConsola());
                            }
                        }
                    });
                }
            });
        }
    }

    public class ActualizarTabla extends MouseAdapter {
        public void mouseClicked(java.awt.event.MouseEvent e) {
            String tablaSeleccionada = PanelElegirTabla.getTablaSeleccionada();
            ArrayList<ArrayList<String>> datosTabla = BasesDeDatos.recogerValoresTabla(conec, tablaSeleccionada);
            ArrayList<String> encabezados = BasesDeDatos.recogerNombresColumnas(conec, tablaSeleccionada);
            PanelTabla.actualizarTablaEncabezados(datosTabla, encabezados);
            modelo.setTable(tablaSeleccionada);
        }
    }