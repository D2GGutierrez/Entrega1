import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static void main(String[] args) {
        // Parámetros de conexión
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "system";
        String contraseña = "Abril131123";

        try {
            // Cargar el driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Crear conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            System.out.println("Conexión exitosa a Oracle Database");

            conexion.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" Driver JDBC no encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(" Error al conectar con la base de datos");
            e.printStackTrace();
        }
    }
}
