import java.sql.Connection;

public class ejercicio04 {
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
        database = "peliculas_Yelmo_ej04";
        conec = BasesDeDatos.crearDataBase(conec, database);

        // Crear la primera tabla "peliculas"
        table = "peliculas";
        values = "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre NVARCHAR(100), calificacionEdad INT)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la primera tabla
        columasAfectadas = "(nombre, calificacionEdad)";
        values = "('Host', 18), ('Jeepers Creepers: El renacer', 20), ('The taking of Deborah Logan', 18), ('Relic', 16), ('Starry Eyes', 16)";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la segunda tabla "salas"
        table = "salas";
        values = "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre NVARCHAR(100), pelicula INT, FOREIGN KEY (pelicula) REFERENCES peliculas (codigo) ON DELETE CASCADE ON UPDATE CASCADE)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la segunda tabla
        columasAfectadas = "(nombre, pelicula)";
        values = "('Sala 1', 1), ('Sala 2', 2), ('Sala 3', 3), ('Sala 4', 4), ('Sala 5', 5)";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);
    }
}