import java.sql.Connection;

public class ejercicio05 {
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
        database = "despachos_directores_ej05";
        conec = BasesDeDatos.crearDataBase(conec, database);

        // Crear la primera tabla "despachos"
        table = "despachos";
        values = "(numero INT AUTO_INCREMENT PRIMARY KEY, capacidad INT)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la primera tabla
        columasAfectadas = "(capacidad)";
        values = "(10), (10), (10), (10), (10)";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la segunda tabla "directores"
        table = "directores";
        values = "(dni VARCHAR(8) PRIMARY KEY, nombreAp NVARCHAR(100), dniJefe VARCHAR(8), despacho INT, FOREIGN KEY (dniJefe) REFERENCES directores (dni) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (despacho) REFERENCES despachos (numero) ON DELETE CASCADE ON UPDATE CASCADE)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la segunda tabla
        columasAfectadas = "(dni, nombreAp, dniJefe, despacho)";
        values = "('11111111', 'Luis Aker', '11111111', 1), ('22222222', 'Juan Magan', '22222222', 2), ('33333333', 'Tony Flags', '33333333', 3), ('44444444', 'Frank Costello', '44444444', 4), ('55555555', 'Charles Luciano', '55555555', 5)";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);
    }
}