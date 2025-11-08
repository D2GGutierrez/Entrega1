
import java.sql.*;
import java.util.Scanner;
public class InsertarProductos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== INSERTAR PRODUCTO ===");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        System.out.print("ID de categoría: ");
        int idCategoria = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Estado (ACTIVO/INACTIVO): ");
        String estado = scanner.nextLine();

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "system";
        String contraseña = "Abril131123";

        String sql = "INSERT INTO PRODUCTOS_TIENDA (NOMBRE, PRECIO, STOCK, ID_CATEGORIA, ESTADO) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.setInt(3, stock);
            pstmt.setInt(4, idCategoria);
            pstmt.setString(5, estado);

            int filas = pstmt.executeUpdate();
            System.out.println("Producto insertado correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al insertar producto:");
            e.printStackTrace();
        }
    }
}
