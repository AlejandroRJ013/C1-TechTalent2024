import java.sql.Connection;

public class ejercicio06 {
    public static void main(String[] args) {
        Connection conec = null;
        String host = "127.0.0.1";
        String user = "root";
        String password = "";
        int port = 3306;
        String database = "";
        String table = "";
        String columasAfectadas = "";
        String values = "";

        // Hacer conexión con el localhost
        conec = BasesDeDatos.hacerConexionConBD(conec, host, port, database, user, password);
        // Crear base de datos para el ejercicio
        database = "piezas_proveedores_ej06";
        conec = BasesDeDatos.crearDataBase(conec, database);

        // Crear la primera tabla "piezas"
        table = "piezas";
        values = "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre NVARCHAR(100))";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la primera tabla
        columasAfectadas = "(nombre)";
        values = "('Tornillos'), ('Tablas'), ('Tubos'), ('Tapones'), ('Clavo')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la segunda tabla "proveedores"
        table = "proveedores";
        values = "(id INT AUTO_INCREMENT PRIMARY KEY, nombre NVARCHAR(100))";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la segunda tabla
        columasAfectadas = "(nombre)";
        values = "('Carrefour'), ('Leroy Merlin'), ('El corte ingles'), ('Spar'), ('Mercadona')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la tercera tabla "suministra"
        table = "suministra";
        values = "(codigoPieza INT, idProveedor INT, precio INT, PRIMARY KEY(codigoPieza, idProveedor), FOREIGN KEY (codigoPieza) REFERENCES piezas (codigo) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (idProveedor) REFERENCES proveedores (id) ON DELETE CASCADE ON UPDATE CASCADE)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la tercera tabla
        columasAfectadas = "(codigoPieza, idProveedor, precio)";
        values = "(1, 1, 5), (2, 2, 10), (3, 3, 7), (4, 4, 2), (5, 5, 2)";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);
    }
}