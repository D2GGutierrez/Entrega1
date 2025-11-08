import java.sql.*;
import java.util.Scanner;

public class ModificarProducto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MODIFICAR PRODUCTO ===");

        System.out.print("Ingrese el ID del producto a modificar: ");
        int idProducto = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Nuevo stock: ");
        int stock = scanner.nextInt();

        System.out.print("Nuevo ID de categoría: ");
        int idCategoria = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Nuevo estado (ACTIVO/INACTIVO): ");
        String estado = scanner.nextLine();

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "system";
        String contraseña = "Abril131123";

        String sql = """
                UPDATE PRODUCTOS_TIENDA
                SET NOMBRE = ?, PRECIO = ?, STOCK = ?, ID_CATEGORIA = ?, ESTADO = ?
                WHERE ID_PRODUCTO = ?
                """;

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setDouble(2, precio);
            pstmt.setInt(3, stock);
            pstmt.setInt(4, idCategoria);
            pstmt.setString(5, estado);
            pstmt.setInt(6, idProducto);

            int filas = pstmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Producto actualizado correctamente.");
            } else {
                System.out.println("No se encontró un producto con ese ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar producto:");
            e.printStackTrace();
        }
    }
}
