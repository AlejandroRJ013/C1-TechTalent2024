import java.sql.Connection;

public class ejercicio09 {
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
        database = "equipos_investigadores_ej09";
        conec = BasesDeDatos.crearDataBase(conec, database);

        // Crear la primera tabla "facultades"
        table = "facultades";
        values = "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre NVARCHAR(100))";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la primera tabla
        columasAfectadas = "(nombre)";
        values = "('Arquitectura'), ('Artes y Diseño'), ('Ciencias'), ('Derecho'), ('Buceo')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la segunda tabla "investigadores"
        table = "investigadores";
        values = "(dni VARCHAR(8) PRIMARY KEY, nombreAp NVARCHAR(100), facultad INT, FOREIGN KEY (facultad) REFERENCES facultades (codigo) ON DELETE CASCADE ON UPDATE CASCADE)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la segunda tabla
        columasAfectadas = "(dni, nombreAp, facultad)";
        values = "('11111111', 'Gabriela Sanchez','1'), ('22222222', 'Josep Capdevila', '2'), ('33333333', 'Ignacio Berzosa Engemann', '3'), ('44444444', 'Ariadna Rodriguez', '4'), ('55555555', 'Xavier Bahamonde', '5')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la tercera tabla "equipos"
        table = "equipos";
        values = "(num_serie NVARCHAR(4) PRIMARY KEY, nombre NVARCHAR(100), facultad INT, FOREIGN KEY (facultad) REFERENCES facultades (codigo) ON DELETE CASCADE ON UPDATE CASCADE)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la tercera tabla
        columasAfectadas = "(num_serie, nombre, facultad)";
        values = "('1111', 'Equipo mexicano', '1'), ('2222', 'Equipo Indones', '2'), ('3333', 'Equipo Español', '3'), ('4444', 'Equipo Frances', '4'), ('5555', 'Equipo Americano', '5')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la cuarta tabla "reserva"
        table = "reserva";
        values = "(dni VARCHAR(8), num_serie NVARCHAR(4), comienzo DATETIME, fin DATETIME, PRIMARY KEY (dni, num_serie), FOREIGN KEY (dni) REFERENCES investigadores (dni) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (num_serie) REFERENCES equipos (num_serie) ON DELETE CASCADE ON UPDATE CASCADE)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la cuarta tabla
        columasAfectadas = "(dni, num_serie, comienzo, fin)";
        values = "('11111111', '2222', '2020-06-15', '2024-06-15'), ('22222222', '3333', '2020-07-20', '2024-07-20'), ('33333333', '4444', '2020-08-25', '2024-08-25'), ('44444444', '5555', '2020-09-30', '2024-09-30'), ('55555555', '1111', '2020-10-05', '2024-10-05')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);
    }
}