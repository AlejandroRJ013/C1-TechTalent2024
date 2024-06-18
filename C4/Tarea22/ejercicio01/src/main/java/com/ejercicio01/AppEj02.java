package com.ejercicio01;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.ejercicio01.vista.*;
import com.ejercicio01.controlador.Controlador;
import com.ejercicio01.modelo.*;

public class AppEj02 {
        public static void main(String[] args) {
                Connection conec = null;
                Modelo modelo = new Modelo();
                String columnasAfectadas = "";
                String values = "";
                ArrayList<String> tablas = new ArrayList<>(Arrays.asList("cliente", "videos"));

                // Hacer conexión con el localhost
                conec = BasesDeDatos.hacerConexionConBD(modelo.getConexion(), modelo.getHost(), modelo.getPort(),
                                modelo.getDatabase(), modelo.getUser(), modelo.getPassword());
                modelo.setConexion(conec);
                // Crear base de datos para el ejercicio
                modelo.setDatabase("crud_ej02");
                conec = BasesDeDatos.crearDataBase(modelo.getConexion(), modelo.getDatabase());
                modelo.setConexion(conec);
                // Crear la tabla "cliente"
                modelo.setTable(tablas.get(0));
                modelo.setValues("(id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                                "nombre NVARCHAR(250) DEFAULT NULL, " +
                                "apellido NVARCHAR(250) DEFAULT NULL, " +
                                "direccion NVARCHAR(250) DEFAULT NULL, " +
                                "dni INT(11) DEFAULT NULL, " +
                                "fecha date DEFAULT NULL)");
                conec = BasesDeDatos.crearTabla(modelo.getConexion(), modelo.getDatabase(), modelo.getTable(),
                                modelo.getValues());
                modelo.setConexion(conec);

                columnasAfectadas = ("(nombre, apellido, direccion, dni, fecha)");
                values = ("('Pedro', 'García', 'Calle Mayor 456', 98765432, '2019-05-15'), "
                                + "('Laura', 'Sánchez', 'Avenida del Sol 789', 65432198, '2020-06-20'), "
                                + "('Antonio', 'Fernández', 'Calle del Río 321', 74185296, '2021-07-25'), "
                                + "('Elena', 'Díaz', 'Plaza España 654', 85296374, '2022-08-30')");

                conec = BasesDeDatos.insertarValues(conec, modelo.getDatabase(), modelo.getTable(), columnasAfectadas,
                                values);

                // Crear la tabla "videos"
                modelo.setTable(tablas.get(1));
                modelo.setValues("(id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                                "title NVARCHAR(250) DEFAULT NULL, " +
                                "director NVARCHAR(250) DEFAULT NULL, " +
                                "clid_id INT(11) DEFAULT NULL, " +
                                "CONSTRAINT videos_fk FOREIGN KEY (clid_id) REFERENCES cliente (id))");
                conec = BasesDeDatos.crearTabla(modelo.getConexion(), modelo.getDatabase(), modelo.getTable(),
                                modelo.getValues());
                modelo.setConexion(conec);

                columnasAfectadas = ("(title, director, clid_id)");
                values = ("('El Secreto de sus Ojos', 'Juan José Campanella', 1), "
                                + "('Relatos Salvajes', 'Damián Szifron', 2), "
                                + "('Nueve Reinas', 'Fabián Bielinsky', 3), "
                                + "('El Hijo de la Novia', 'Juan José Campanella', 4)");

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
