
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "SYSTEM";
        String contraseña = "Abril131123";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             Statement stmt = conexion.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCTOS_TIENDA");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_PRODUCTO"));
                System.out.println("Nombre: " + rs.getString("NOMBRE"));
                System.out.println("Precio: " + rs.getDouble("PRECIO"));
                System.out.println("Stock: " + rs.getInt("STOCK"));
                System.out.println("Categoría: " + rs.getInt("ID_CATEGORIA"));
                System.out.println("Fecha de registro: " + rs.getDate("FECHA_REGISTRO"));
                System.out.println("Estado: " + rs.getString("ESTADO"));
                System.out.println("-------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}