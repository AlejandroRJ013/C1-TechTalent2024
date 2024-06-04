import java.sql.Connection;

public class ejercicio08 {
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
        database = "supermercado_mercaroña_ej08";
        conec = BasesDeDatos.crearDataBase(conec, database);

        // Crear la primera tabla "cajeros"
        table = "cajeros";
        values = "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombreAp NVARCHAR(100))";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la primera tabla
        columasAfectadas = "(nombreAp)";
        values = "('Maria Ortega'), ('Fernando Rabassó'), ('Franccesca Feinzi'), ('Jonthan Beaulfils'), ('Judit Arenal')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la segunda tabla "maq_registradora"
        table = "maq_registradora";
        values = "(codigo INT AUTO_INCREMENT PRIMARY KEY, piso INT)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la segunda tabla
        columasAfectadas = "(piso)";
        values = "('1'), ('2'), ('3'), ('4'), ('5')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la tercera tabla "productos"
        table = "productos";
        values = "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre NVARCHAR(100), precio INT)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la tercera tabla
        columasAfectadas = "(nombre, precio)";
        values = "('Pechuga de pollo', '12'), ('Queso', '10'), ('Patatas', '6'), ('Futas', '4'), ('Pan', '1')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la cuarta tabla "asignado_a"
        table = "venta";
        values = "(cajero INT, maquina INT, producto INT, PRIMARY KEY(cajero, maquina, producto), FOREIGN KEY (cajero) REFERENCES cajeros (codigo) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (maquina) REFERENCES maq_registradora (codigo) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (producto) REFERENCES productos (codigo) ON DELETE CASCADE ON UPDATE CASCADE)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la cuarta tabla
        columasAfectadas = "(cajero, maquina, producto)";
        values = "('1', '1', '1'), ('2', '2', '2'), ('3', '3', '3'), ('4', '4', '4'), ('5', '5', '5')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);
    }
}