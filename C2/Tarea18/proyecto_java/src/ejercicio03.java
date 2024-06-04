import java.sql.Connection;

public class ejercicio03 {
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
        database = "almacenes_Amazon_ej03";
        conec = BasesDeDatos.crearDataBase(conec, database);

        // Crear la primera tabla "almacenes"
        table = "almacenes";
        values = "(codigo INT AUTO_INCREMENT PRIMARY KEY, lugar NVARCHAR(100), capacidad INT)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la primera tabla
        columasAfectadas = "(lugar, capacidad)";
        values = "('Venezuela', 10), ('España', 20), ('Alemania', 25), ('Rusia', 30), ('Ucrania', 10)";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la segunda tabla "cajas"
        table = "cajas";
        values = "(num_ref CHAR(5) PRIMARY KEY, contenido NVARCHAR(100), valor INT, almacen INT, FOREIGN KEY (almacen) REFERENCES almacenes (codigo) ON DELETE CASCADE ON UPDATE CASCADE)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la segunda tabla
        columasAfectadas = "(num_ref, contenido, valor, almacen)";
        values = "('11111', 'Juguetes', 10, 3), ('22222', 'Ropa', 25, 2), ('33333', 'Envases', 5, 1), ('44444', 'Electronicos', 10, 4), ('55555', 'Cables', 20, 5)";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);
    }
}