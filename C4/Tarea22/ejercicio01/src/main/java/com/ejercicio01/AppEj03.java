package com.ejercicio01;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.ejercicio01.vista.*;
import com.ejercicio01.controlador.Controlador;
import com.ejercicio01.modelo.*;

public class AppEj03 {
        public static void main(String[] args) {
                Connection conec = null;
                Modelo modelo = new Modelo();
                String columnasAfectadas = "";
                String values = "";
                ArrayList<String> tablas = new ArrayList<>(Arrays.asList("cientificos", "proyecto", "asignado_a"));

                conec = BasesDeDatos.hacerConexionConBD(modelo.getConexion(), modelo.getHost(), modelo.getPort(),
                                modelo.getDatabase(), modelo.getUser(), modelo.getPassword());
                modelo.setConexion(conec);
                modelo.setDatabase("crud_ej03");
                conec = BasesDeDatos.crearDataBase(modelo.getConexion(), modelo.getDatabase());
                modelo.setConexion(conec);
                // Crear la tabla "cientificos"
                modelo.setTable(tablas.get(0));
                modelo.setValues("(DNI varchar(8) NOT NULL PRIMARY KEY, NOMAPELS nvarchar(255) NOT NULL)");
                conec = BasesDeDatos.crearTabla(modelo.getConexion(), modelo.getDatabase(), modelo.getTable(),
                                modelo.getValues());
                modelo.setConexion(conec);
                columnasAfectadas = ("(DNI, NOMAPELS)");
                values = ("('12345678', 'Juan Pérez'), ('87654321', 'Ana López'), " +
                                "('98765432', 'Pedro García'), ('23456789', 'María González');");
                conec = BasesDeDatos.insertarValues(conec, modelo.getDatabase(), modelo.getTable(), columnasAfectadas,
                                values);

                // Crear la tabla "proyecto"
                modelo.setTable(tablas.get(1));
                modelo.setValues("(ID char(4) PRIMARY KEY, NOMBRE nvarchar(255) NOT NULL, HORAS int NOT NULL)");
                conec = BasesDeDatos.crearTabla(modelo.getConexion(), modelo.getDatabase(), modelo.getTable(),
                                modelo.getValues());
                modelo.setConexion(conec);
                columnasAfectadas = ("(ID, NOMBRE, HORAS)");
                values = ("('PR01', 'Desarrollo de un nuevo medicamento', 120), ('PR02', 'Análisis del cambio climático', 80), "
                                +
                                "('PR03', 'Investigación de la biodiversidad', 150), ('PR04', 'Diseño de una nueva tecnología', 100)");
                conec = BasesDeDatos.insertarValues(conec, modelo.getDatabase(), modelo.getTable(), columnasAfectadas,
                                values);

                // Crear la tabla "asignado_a"
                modelo.setTable(tablas.get(2));
                modelo.setValues("(PROYECTO char(4), CIENTIFICO varchar(8), PRIMARY KEY(PROYECTO, CIENTIFICO), " +
                                "FOREIGN KEY (CIENTIFICO) REFERENCES CIENTIFICOS(DNI), FOREIGN KEY (PROYECTO) REFERENCES PROYECTO(ID))");
                conec = BasesDeDatos.crearTabla(modelo.getConexion(), modelo.getDatabase(), modelo.getTable(),
                                modelo.getValues());
                modelo.setConexion(conec);
                columnasAfectadas = ("(PROYECTO, CIENTIFICO)");
                values = ("('PR01', '12345678'), ('PR01', '87654321'), ('PR02', '98765432'), ('PR02', '23456789'), " +
                                "('PR03', '12345678'), ('PR03', '87654321'), ('PR04', '98765432'), ('PR04', '23456789');");
                conec = BasesDeDatos.insertarValues(conec, modelo.getDatabase(), modelo.getTable(), columnasAfectadas,
                                values);

                int columnas = BasesDeDatos.cantidadColumnas(modelo.getConexion(), modelo.getTable());
                int filas = BasesDeDatos.cantidadFilas(modelo.getConexion(), modelo.getTable());
                ArrayList<String> nombres = BasesDeDatos.recogerNombresColumnas(modelo.getConexion(),
                                modelo.getTable());
                Ventana ventana = new Ventana(modelo.getTable(), filas, columnas, tablas, nombres);
                ArrayList<ArrayList<String>> datosTabla = BasesDeDatos.recogerValoresTabla(conec, modelo.getTable());
                PanelTabla.actualizarTabla(datosTabla);
                PanelConsola.setEntradaConsola(BasesDeDatos.getTextoConsola());

                new Controlador(modelo, ventana);

                Scanner sc = new Scanner(System.in);
                System.out.println("SALIR?");
                while (true) {
                        String entrada = sc.nextLine();
                        if (entrada.equals("s")) {
                                conec = BasesDeDatos.eliminarTabla(conec, modelo.getDatabase(), modelo.getTable());
                                conec = BasesDeDatos.eliminarDB(conec, modelo.getDatabase());
                                conec = BasesDeDatos.desconectarBD(conec);
                                sc.close();
                                System.exit(0);
                        }
                }
        }
}
