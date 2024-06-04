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
        while (true) {
            System.out.print("\nQuiere hacer conexión? (s/n): ");
            if (sc.hasNextLine()) {
                String entrada = sc.nextLine();
                if (entrada.matches("[sS]")) {
                    conec = BasesDeDatos.hacerConexionConBD(conec, host, port, database, user, password);
                    break;
                } else if (entrada.matches("[nN]")) {
                    System.out.println("Conexión no realizada. Saliendo del programa.");
                    sc.close();
                    return;
                } else {
                    System.out.print("\n - - Recordatorio de respuesta [ s/S | n/N ] - - \n");
                }
            }
        }

        System.out.print("\nCrear base de datos: ");
        if (sc.hasNextLine()) {
            database = sc.nextLine();
            if (!database.toLowerCase().isEmpty()) {
                conec = BasesDeDatos.crearDataBase(conec, database);
            }
        }

        System.out.print("\nCrear tabla: ");
        if (sc.hasNextLine()) {
            table = sc.nextLine();
            if (!table.toLowerCase().isEmpty()) {
                String valoresTabla = "(id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(50), apellido VARCHAR(50), edad INT, sexo VARCHAR(1))";
                conec = BasesDeDatos.crearTabla(conec, database, table, valoresTabla);
                conec = BasesDeDatos.itinerarInsertandoDatos(conec, database, table);
            }
        }

        conec = BasesDeDatos.eliminarTabla(conec, database, table);
        conec = BasesDeDatos.eliminarDB(conec, database);
        conec = BasesDeDatos.desconectarBD(conec);

        sc.close();
    }
}