import java.sql.Connection;

public class ejercicio02 {
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
        database = "departamentos_empleados_ej02";
        conec = BasesDeDatos.crearDataBase(conec, database);

        // Crear la primera tabla "departamentos"
        table = "departamentos";
        values = "(codigo INT AUTO_INCREMENT PRIMARY KEY, nombre NVARCHAR(100), presupuesto INT)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la primera tabla
        columasAfectadas = "(nombre, presupuesto)";
        values = "('Dep. Tecnologico', 60000), ('Dep. Finanzas', 50000), ('Dep. Social', 15000), ('Dep. Individual', 100000), ('Dep. Colectivo', 75000)";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);

        // Crear la segunda tabla "empleados"
        table = "empleados";
        values = "(dni VARCHAR(8) PRIMARY KEY, nombre NVARCHAR(100), apellidos NVARCHAR(255), departamento INT, FOREIGN KEY (departamento) REFERENCES departamentos (codigo) ON DELETE CASCADE ON UPDATE CASCADE)";
        conec = BasesDeDatos.crearTabla(conec, database, table, values);

        // Inserción de cinco registros en la segunda tabla
        columasAfectadas = "(dni, nombre, apellidos, departamento)";
        values = "('11111111', 'Tirone José', 'González Orama', 3), ('22222222', 'Javier', 'Ibarra Ramos', 2), ('33333333', 'Pedro', 'Navarro Utrera', 1), ('44444444', 'Tupac', 'Amaru Shakur', 4), ('55555555', 'Christopher George', 'Latore Wallace', 5)";
        conec = BasesDeDatos.insertarValues(conec, database, table, columasAfectadas, values);
    }
}