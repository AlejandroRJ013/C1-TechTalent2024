import java.sql.*;
import java.util.logging.*;
import java.util.*;

public class BasesDeDatos {

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
                System.out.println(verde("Conexión establecida"));
            } else {
                System.out.println(verde("Conexión con la base de datos " + magenta(dataBase) + " establecida"));
            }
            System.out.println(String.format("jdbc:mysql://" + amarillo(host) + ":" + azul(String.valueOf(port)) +
                    "/" + magenta(dataBase)));
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(rojo("Error") + " : " + e.getMessage() +
                    amarillo("\n\nTipo") + " : " + e.getClass() +
                    cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static Connection crearDataBase(Connection conexion, String dataBase) {
        try {
            Statement st = conexion.createStatement();
            int filasAfectadas = st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dataBase);
            // CREAR DB SI NO EXISTE //
            System.out.println(verde("Nombre de la BD") + " : " + dataBase + "\n" + naranja("Filas afectadas")
                    + " : " + filasAfectadas);

            hacerConexionConBD(conexion, BasesDeDatos.host, BasesDeDatos.port, dataBase, BasesDeDatos.user,
                    BasesDeDatos.password);
            // HACER CONEXIÓN DE NUEVO PERO AHORA EN LA DB //
        } catch (SQLException e) {
            System.out.println(rojo("Error") + " : " + e.getMessage() +
                    amarillo("\n\nTipo") + " : " + e.getClass() +
                    cyan("\n\nCausa") + " : " + e.getCause());
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
            System.out
                    .println("Tabla : " + table + " / Creada\n" + naranja("Filas afectadas") + " : " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println(rojo("Error") + " : " + e.getMessage() +
                    amarillo("\n\nTipo") + " : " + e.getClass() +
                    cyan("\n\nCausa") + " : " + e.getCause());
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
            System.out.println(cyan("INSERT INTO " + table + " " + columasAfectadas + " VALUES " + values + ";"));
        } catch (SQLException e) {
            System.out.println(rojo("Error") + " : " + e.getMessage() +
                    amarillo("\n\nTipo") + " : " + e.getClass() +
                    cyan("\n\nCausa") + " : " + e.getCause());
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

            System.out.println("\nColumnas de la tabla: " + contarCol);
            Scanner sc = new Scanner(System.in);
            System.out.println("\nTuplas a insertar");
            int tuplas = sc.nextInt();
            sc.nextLine();

            for (int cant = 1; cant <= tuplas; cant++) {
                System.out.println("Tupla " + cant + " : ");
                for (int valor = 1; valor <= contarCol; valor++) {
                    while (true) {
                        System.out.println("Valor para " + metaData.getColumnName(valor));
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
            System.out.println(rojo("Error") + " : " + e.getMessage() +
                    amarillo("\n\nTipo") + " : " + e.getClass() +
                    cyan("\n\nCausa") + " : " + e.getCause());
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
            System.out.print(cyan(query.toString()) + "\n\n");
        }
    }

    public static Connection eliminarTabla(Connection conexion, String dataBase, String table) {
        try {
            Statement stdb = conexion.createStatement();
            stdb.execute("USE " + dataBase);
            Statement st = conexion.createStatement();
            int filasAfectadas = st.executeUpdate("DROP TABLE IF EXISTS " + table);
            System.out
                    .println(rojo("Tabla \"" + table + "\" eliminada\n" + naranja("Filas afectadas") + " : "
                            + filasAfectadas));
        } catch (SQLException e) {
            System.out.println(rojo("Error") + " : " + e.getMessage() +
                    amarillo("\n\nTipo") + " : " + e.getClass() +
                    cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static Connection eliminarDB(Connection conexion, String dataBase) {
        try {
            Statement st = conexion.createStatement();
            int filasAfectadas = st.executeUpdate("DROP DATABASE " + dataBase);
            System.out
                    .println(rojo("Base de datos \"" + dataBase + "\" eliminada\n" + naranja("Filas afectadas") + " : "
                            + filasAfectadas));
        } catch (SQLException e) {
            System.out.println(rojo("Error") + " : " + e.getMessage() +
                    amarillo("\n\nTipo") + " : " + e.getClass() +
                    cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static Connection desconectarBD(Connection conexion) {
        try {
            conexion.close();
            // DESCONECTARSE DE LA CONEXIÓN ESPEFICIDADA //
            System.out.println(rojo("Conexion cerrada"));
        } catch (SQLException e) {
            System.out.println(rojo("Error") + " : " + e.getMessage() +
                    amarillo("\n\nTipo") + " : " + e.getClass() +
                    cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }
}