import java.sql.*;
import java.util.Scanner;

public class EliminarProducto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ELIMINAR PRODUCTO ===");

        System.out.print("Ingrese el ID del producto a eliminar: ");
        int idProducto = scanner.nextInt();

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "system";
        String contraseña = "Abril131123";

        String sql = "DELETE FROM PRODUCTOS_TIENDA WHERE ID_PRODUCTO = ?";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idProducto);

            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("No se encontró un producto con ese ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar producto:");
            e.printStackTrace();
        }
    }
}
