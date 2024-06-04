import java.sql.Connection;

public class ejercicio07 {
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
        database = "cientificos_proyectos_ej07";
        conec = BasesDeDatos.crearDataBase(conec, database);

        // Crear la primera tabla "cientificos"
        table = "cientificos";
        values = "("
                + "dni VARCHAR(8) PRIMARY KEY, "
                + "nombreAp NVARCHAR(100))";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la primera tabla
        columasAfectadas = "(dni, nombreAp)";
        values = "('11111111', 'Javier Santaolalla'), "
                + "('22222222', 'Jose Luis Crespo'), "
                + "('33333333', 'Jorge Mendel'), "
                + "('44444444', 'Isaac Newton'), "
                + "('55555555', 'Marie Curie')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la segunda tabla "proyectos"
        table = "proyectos";
        values = "("
                + "id CHAR(4) PRIMARY KEY, "
                + "nombre NVARCHAR(255), "
                + "horas INT)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la segunda tabla
        columasAfectadas = "(id, nombre, horas)";
        values = "('1111', 'Presión atmosferica', '90'), "
                + "('2222', 'Lupa con gota de agua', '160'), "
                + "('3333', 'Separando las aguas', '220'), "
                + "('4444', 'El submarino', '360'), "
                + "('5555', 'Gases pesados', '450')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la tercera tabla "asignado_a"
        table = "asignado_a";
        values = "("
                + "cientifico VARCHAR(8), "
                + "proyecto CHAR(4), "
                + "PRIMARY KEY(cientifico, proyecto), "
                + "FOREIGN KEY (cientifico) "
                + "REFERENCES cientificos (dni) "
                + "ON DELETE CASCADE ON UPDATE CASCADE, "
                + "FOREIGN KEY (proyecto) "
                + "REFERENCES proyectos (id) "
                + "ON DELETE CASCADE ON UPDATE CASCADE)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la tercera tabla
        columasAfectadas = "(cientifico, proyecto)";
        values = "('11111111', '2222'), "
                + "('22222222', '4444'), "
                + "('33333333', '5555'), "
                + "('44444444', '1111'), "
                + "('55555555', '3333')";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);
    }
}