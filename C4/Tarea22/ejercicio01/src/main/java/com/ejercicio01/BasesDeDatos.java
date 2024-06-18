package com.ejercicio01;

import java.sql.*;
import java.util.*;

public class BasesDeDatos {
    private static String queryAntes = "";
    private static String queryDespues = "";
    private static ArrayList<String> lineasConsola = new ArrayList<>();
    private static String host;
    private static int port;
    private static String user;
    private static String password;
    private static String reset = "\u001B[0m";

    public BasesDeDatos() {
        BasesDeDatos.host = "localhost";
        BasesDeDatos.port = 3306;
        BasesDeDatos.user = "root";
        BasesDeDatos.password = "";
    }

    public BasesDeDatos(String host, int port, String user, String password) {
        BasesDeDatos.host = host;
        BasesDeDatos.port = port;
        BasesDeDatos.user = user;
        BasesDeDatos.password = password;
    }

    public static String rojo(String texto) {
        String rojo = "\u001B[31m";
        return rojo + texto + reset;
    }

    public static String verde(String texto) {
        String verde = "\u001B[32m";
        return verde + texto + reset;
    }

    public static String amarillo(String texto) {
        String amarillo = "\u001B[33m";
        return amarillo + texto + reset;
    }

    public static String azul(String texto) {
        String azul = "\u001B[34m";
        return azul + texto + reset;
    }

    public static String magenta(String texto) {
        String magenta = "\u001B[35m";
        return magenta + texto + reset;
    }

    public static String cyan(String texto) {
        String cyan = "\u001B[36m";
        return cyan + texto + reset;
    }

    public static String naranja(String texto) {
        String cyan = "\u001B[38;5;208m";
        return cyan + texto + reset;
    }

    public static int cantidadFilas(Connection con, String table) {
        int filas = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM " + table);
            if (rs.next()) {
                filas = rs.getInt(1);
            }
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return filas;
    }

    public static int cantidadColumnas(Connection con, String table) {
        int columnas = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " LIMIT 1");
            if (rs.next()) {
                columnas = rs.getMetaData().getColumnCount();
            }
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return columnas;
    }

    public static ArrayList<String> recogerNombresColumnas(Connection con, String table) {
        ArrayList<String> nombres = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " LIMIT 1");
            if (rs.next()) {
                int columnCount = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    nombres.add(rs.getMetaData().getColumnName(i).toUpperCase());
                }
            }
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return nombres;
    }

    public static ArrayList<ArrayList<Object>> obtenerDatosDeTabla(Connection conexion, String dataBase, String table) {
        ArrayList<ArrayList<Object>> datos = new ArrayList<>();
        try {
            Statement stdb = conexion.createStatement();
            stdb.execute("USE " + dataBase);
            ResultSet rs = stdb.executeQuery("SELECT * FROM " + table);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnas = metaData.getColumnCount();

            while (rs.next()) {
                ArrayList<Object> fila = new ArrayList<>();
                for (int i = 1; i <= columnas; i++) {
                    fila.add(rs.getObject(i));
                }
                datos.add(fila);
            }
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return datos;
    }

    public static Connection hacerConexionConBD(Connection conexion, String host, int port, String dataBase,
            String user, String password) {
        try {
            String url = String.format("jdbc:mysql://%s:%d/%s", host, port, dataBase);
            new BasesDeDatos(host, port, user, password);

            Class.forName("com.mysql.cj.jdbc.Driver");
            // CONECTARSE AL DRIVER MYSQL ?//
            conexion = DriverManager.getConnection(url, user, password);
            // CONECTARSE AL SERVIDOR ESPEFICIDADO //

            if (dataBase.isEmpty()) {
                imprimirConsola("Conexión establecida");
            } else {
                imprimirConsola("Conexión con la base de datos " + dataBase + " establecida");
            }
            imprimirConsola(String.format(
                    "jdbc:mysql://" + host + ":" + String.valueOf(port) + "/" + dataBase));
        } catch (ClassNotFoundException | SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static Connection crearDataBase(Connection conexion, String dataBase) {
        try {
            Statement st = conexion.createStatement();
            int filasAfectadas = st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dataBase);
            // CREAR DB SI NO EXISTE //
            imprimirConsola("Nombre de la BD : " + dataBase);
            imprimirConsola("Filas afectadas : " + filasAfectadas);
            hacerConexionConBD(conexion, BasesDeDatos.host, BasesDeDatos.port, dataBase, BasesDeDatos.user,
                    BasesDeDatos.password);
            // HACER CONEXIÓN DE NUEVO PERO AHORA EN LA DB //
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static Connection crearTabla(Connection conexion, String dataBase, String table, String valoresTabla) {
        try {
            Statement stdb = conexion.createStatement();
            stdb.execute("USE " + dataBase);
            Statement st = conexion.createStatement();
            int filasAfectadas = st.executeUpdate("CREATE TABLE IF NOT EXISTS " + table + " " + valoresTabla);
            // CREAR TABLA SI NO EXISTE //
            imprimirConsola("Tabla : " + table + " / Creada");
            imprimirConsola("Filas afectadas : " + filasAfectadas);
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static Connection insertarValues(Connection conexion, String dataBase, String table, String columasAfectadas,
            String values) {
        try {
            Statement stdb = conexion.createStatement();
            stdb.execute("USE " + dataBase);
            Statement st = conexion.createStatement();
            st.executeUpdate("INSERT INTO " + table + " " + columasAfectadas + " VALUES " + values + ";");
            // INSERTAR VALORES EN LA TABLA //
            imprimirConsola("INSERT INTO " + table + " " + columasAfectadas + " VALUES " + values + ";");
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static ArrayList<ArrayList<String>> recogerValoresTabla(Connection conexion, String table) {
        ArrayList<ArrayList<String>> datosTabla = new ArrayList<>();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + table);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                ArrayList<String> fila = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    fila.add(rs.getString(i));
                }
                datosTabla.add(fila);
            }
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return datosTabla;
    }

    public static ArrayList<ArrayList<String>> recogerValoresConsulta(Connection conexion, String query) {
        ArrayList<ArrayList<String>> datosTabla = new ArrayList<>();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                ArrayList<String> fila = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    fila.add(rs.getString(i));
                }
                datosTabla.add(fila);
            }
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return datosTabla;
    }

    public static Connection hacerUpdate(Connection conexion, String queryUpdate, String querySelect) {
        queryAntes = querySelect;
        queryDespues = queryUpdate;
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(querySelect);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Imprimir los nombres de las columnas
            for (int i = 1; i <= columnCount; i++) {
                imprimirConsola(metaData.getColumnName(i) + "\t");
            }
            imprimirConsola("");

            // Imprimir los datos de cada fila
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    imprimirConsola(rs.getString(i) + "\t");
                }
                imprimirConsola("");
            }
            int filasAfectadas = st.executeUpdate(queryUpdate);
            imprimirConsola("Filas afectadas: " + filasAfectadas);
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static Connection hacerSelect(Connection conexion, String query) {
        queryAntes = query;
        queryDespues = "";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Imprimir los nombres de las columnas
            for (int i = 1; i <= columnCount; i++) {
                imprimirConsola(metaData.getColumnName(i) + "\t");
            }
            imprimirConsola("");

            // Imprimir los datos
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    imprimirConsola(rs.getString(i) + "\t");
                }
                imprimirConsola("");
            }
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static Connection itinerarInsertandoDatos(Connection conexion, String dataBase, String table) {
        try {
            ArrayList<Object> columnaNombre = new ArrayList<>();
            ArrayList<Object> columnasValor = new ArrayList<>();

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + table);
            ResultSetMetaData metaData = rs.getMetaData();
            int contarCol = metaData.getColumnCount();

            imprimirConsola("");
            imprimirConsola("Columnas de la tabla: " + contarCol);
            Scanner sc = new Scanner(System.in);
            imprimirConsola("");
            imprimirConsola("Tuplas a insertar");
            int tuplas = sc.nextInt();
            sc.nextLine();

            for (int cant = 1; cant <= tuplas; cant++) {
                imprimirConsola("Tupla " + cant + " : ");
                for (int valor = 1; valor <= contarCol; valor++) {
                    while (true) {
                        imprimirConsola("Valor para " + metaData.getColumnName(valor));
                        String tupla = sc.nextLine();
                        if (!tupla.isEmpty()) {
                            columnaNombre.add(metaData.getColumnName(valor));
                            columnasValor.add("'" + tupla.replace("'", "''") + "'");
                            break;
                        }
                    }
                }
                recogerValores(table, st, contarCol, columnaNombre, columnasValor);
            }
            sc.reset();
            sc.close();
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static void recogerValores(String table, Statement st, int contarCol, ArrayList<Object> columnaNombre,
            ArrayList<Object> columnasValor) throws SQLException {
        if (columnaNombre.size() == contarCol && columnasValor.size() == contarCol) {
            StringBuilder query = new StringBuilder("INSERT INTO " + table + " (");
            for (Object nombre : columnaNombre) {
                query.append(nombre).append(",");
            }
            query.setLength(query.length() - 1);
            query.append(") VALUES (");
            for (Object valor : columnasValor) {
                query.append(valor).append(",");
            }
            query.setLength(query.length() - 1);
            query.append(");");
            columnaNombre.clear();
            columnasValor.clear();
            st.executeUpdate(query.toString());
            imprimirConsola(query.toString());
            imprimirConsola("");
        }
    }

    public static Connection eliminarTabla(Connection conexion, String dataBase, String table) {
        try {
            Statement stdb = conexion.createStatement();
            stdb.execute("USE " + dataBase);
            Statement st = conexion.createStatement();
            int filasAfectadas = st.executeUpdate("DROP TABLE IF EXISTS " + table);
            imprimirConsola("Tabla \"" + table + "\" eliminada");
            imprimirConsola("Filas afectadas : " + filasAfectadas);
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static Connection eliminarDB(Connection conexion, String dataBase) {
        try {
            Statement st = conexion.createStatement();
            int filasAfectadas = st.executeUpdate("DROP DATABASE " + dataBase);
            imprimirConsola("Base de datos \"" + dataBase + "\" eliminada");
            imprimirConsola("Filas afectadas : " + filasAfectadas);
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage());
            imprimirConsola("");
            imprimirConsola("Tipo : " + e.getClass());
            imprimirConsola("");
            imprimirConsola("Causa : " + e.getCause());
            System.out.println(rojo("Error") + " : " + e.getMessage() + amarillo("\n\nTipo") + " : " + e.getClass()
                    + cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static Connection desconectarBD(Connection conexion) {
        try {
            conexion.close();
            // DESCONECTARSE DE LA CONEXIÓN ESPEFICIDADA //
            imprimirConsola("Conexion cerrada");
        } catch (SQLException e) {
            imprimirConsola("Error : " + e.getMessage() + "\n\nTipo : " + e.getClass() + "\n\nCausa : " + e.getCause());
        }
        return conexion;
    }

    private static void imprimirConsola(String texto) {
        System.out.println(texto);
        lineasConsola.add(texto);
    }

    public static ArrayList<String> getTextoConsola() {
        return lineasConsola;
    }

    public static String getQueryAntes() {
        return queryAntes;
    }

    public static String getQueryDespues() {
        return queryDespues;
    }
}