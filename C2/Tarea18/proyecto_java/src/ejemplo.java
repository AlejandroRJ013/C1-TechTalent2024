import java.sql.*;
import java.util.Scanner;

public class ejemplo {
    public static void main(String[] args) {
        Connection conec = null;
        String host = "127.0.0.1";
        String user = "root";
        String password = "";
        int port = 3306;
        String database = "";
        String table = "";

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEntrar: ");
        String entrada = sc.nextLine();
        if (entrada.toLowerCase().equals("entrar")) {
            conec = BasesDeDatos.hacerConexionConBD(conec, host, port, database, user, password);
        }

        System.out.print("\nCrear base de datos: ");
        database = sc.nextLine();
        if (!database.toLowerCase().isEmpty()) {
            conec = BasesDeDatos.crearDataBase(conec, database);
        }

        System.out.print("\nCrear tabla: ");
        table = sc.nextLine();
        if (!table.toLowerCase().isEmpty()) {
            String valoresTabla = " (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(50), apellido VARCHAR(50), edad INT, sexo VARCHAR(1))";
            conec = BasesDeDatos.crearTabla(conec, database, table, valoresTabla);
            conec = BasesDeDatos.insertarDatos(conec, database, table);
        }

        System.out.print("\nSalir: ");
        String salida = sc.nextLine();
        if (salida.toLowerCase().equals("salir")) {
            conec = BasesDeDatos.desconectarBD(conec);
        }
        sc.close();
    }
}