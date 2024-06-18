package com.ejercicio01;

import java.sql.*;
import java.util.*;

import com.ejercicio01.vista.*;
import com.ejercicio01.controlador.*;
import com.ejercicio01.modelo.*;

public class AppEj01 {
        public static void main(String[] args) {
                Connection conec = null;
                Modelo modelo = new Modelo();
                // Hacer conexión con el localhost
                conec = BasesDeDatos.hacerConexionConBD(modelo.getConexion(), modelo.getHost(), modelo.getPort(),
                                modelo.getDatabase(), modelo.getUser(), modelo.getPassword());
                modelo.setConexion(conec);
                // Crear base de datos para el ejercicio
                modelo.setDatabase("crud_ej01");
                conec = BasesDeDatos.crearDataBase(modelo.getConexion(), modelo.getDatabase());
                modelo.setConexion(conec);
                // Crear la tabla "cliente"
                modelo.setTable("cliente");
                modelo.setValues(
                                "(id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                                                "nombre NVARCHAR(250) DEFAULT NULL, " +
                                                "apellido NVARCHAR(250) DEFAULT NULL, " +
                                                "direccion NVARCHAR(250) DEFAULT NULL, " +
                                                "dni int(11) DEFAULT NULL, " +
                                                "fecha date DEFAULT NULL)");
                conec = BasesDeDatos.crearTabla(modelo.getConexion(), modelo.getDatabase(), modelo.getTable(),
                                modelo.getValues());
                modelo.setConexion(conec);

                String columnasAfectadas = ("(nombre, apellido, direccion, dni, fecha)");
                String values = ("('Juan', 'Pérez', 'Calle Falsa 123', 12345678, '2020-01-01'), "
                                + "('María', 'López', 'Avenida Siempre 742', 87654321, '2021-02-02'), "
                                + "('Carlos', 'Gómez', 'Calle de la Paz 456', 45678912, '2022-03-03'), "
                                + "('Ana', 'Martínez', 'Puerta del Sol 789', 78912345, '2023-04-04')");

                conec = BasesDeDatos.insertarValues(conec, modelo.getDatabase(), modelo.getTable(), columnasAfectadas,
                                values);

                int columnas = BasesDeDatos.cantidadColumnas(modelo.getConexion(), modelo.getTable());
                int filas = BasesDeDatos.cantidadFilas(modelo.getConexion(), modelo.getTable());
                ArrayList<String> nombres = BasesDeDatos.recogerNombresColumnas(modelo.getConexion(),
                                modelo.getTable());
                Ventana ventana = new Ventana(modelo.getTable(), filas, columnas,
                                new ArrayList<String>(Arrays.asList("cliente")), nombres);

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
