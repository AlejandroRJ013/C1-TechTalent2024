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

    // public static void setValues(String nuevoHost, int nuevoPuerto, String
    // nuevoUser, String nuevaPass) {
    // nuevoHost = BasesDeDatos.host;
    // nuevoPuerto = BasesDeDatos.port;
    // nuevoUser = BasesDeDatos.user;
    // nuevaPass = BasesDeDatos.password;
    // }

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
                System.out.println(verde("Conectado al servidor"));
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
            System.out.println(verde("Base de datos") + " : " + dataBase + " / Creada\n" + naranja("Filas afectadas")
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
            int filasAfectadas = st.executeUpdate("CREATE TABLE IF NOT EXISTS " + table + valoresTabla);
            System.out
                    .println("Tabla : " + table + " / Creada\n" + naranja("Filas afectadas") + " : " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println(rojo("Error") + " : " + e.getMessage() +
                    amarillo("\n\nTipo") + " : " + e.getClass() +
                    cyan("\n\nCausa") + " : " + e.getCause());
        }
        return conexion;
    }

    public static Connection insertarDatos(Connection conexion, String dataBase, String table) {
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + table);
            ResultSetMetaData metaData = rs.getMetaData();
            int contarCol = metaData.getColumnCount();

            Scanner sc = new Scanner(System.in);
            System.out.println("\nCantidad de tuplas a insertar: ");
            int cantTupla = sc.nextInt();

            ArrayList<Object> columnas = new ArrayList<>();

            for (int cant = 1; cant <= cantTupla; cant++) {
                System.out.println("Tupla " + cant + " : ");
                for (int valor = 1; valor <= contarCol; valor++) {
                    System.out.println("Valor para " + metaData.getColumnName(valor));
                    String tupla = sc.nextLine();
                    columnas.add(tupla);
                }
            }
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
            Logger.getLogger(ejemplo.class.getName()).log(Level.SEVERE, null, e);
        }
        return conexion;
    }
}