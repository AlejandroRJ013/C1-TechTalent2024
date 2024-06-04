import java.sql.Connection;

public class ejercicio01 {
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
        database = "tienda_informatica_ej01";
        conec = BasesDeDatos.crearDataBase(conec, database);

        // Crear la primera tabla "fabricantes"
        table = "fabricantes";
        values = "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre NVARCHAR(100))";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la primera tabla
        columasAfectadas = "(nombre)";
        values = "('Juan'), ('Sebastian'), ('Ramirez'), ('Anna'), ('Francesca')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la segunda tabla "articulos"
        table = "articulos";
        values = "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre NVARCHAR(100), precio INT, fabricante INT, FOREIGN KEY (fabricante) REFERENCES fabricantes (codigo) ON DELETE CASCADE ON UPDATE CASCADE)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la segunda tabla
        columasAfectadas = "(nombre, precio, fabricante)";
        values = "('manzana', 2, 1), ('peras', 3, 2), ('piña', 6, 3), ('tomates', 2, 4), ('lechuga', 4, 5)";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);
    }
}