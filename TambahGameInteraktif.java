import java.sql.*;
import java.util.Scanner; // Import untuk menerima input

public class TambahGameInteraktif {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/db_koleksi_game";
        String user = "root";
        String password = "";

        // Menerima input dari Sir Rangga
        System.out.println("=== INPUT KOLEKSI GAME RETRO ===");
        System.out.print("Judul Game: ");
        String judul = input.nextLine();
        System.out.print("Platform: ");
        String platform = input.nextLine();
        System.out.print("Genre: ");
        String genre = input.nextLine();
        System.out.print("Skor Personal (1-10): ");
        int skor = input.nextInt();

        String sql = "INSERT INTO tb_retro_games (judul_game, platform, genre, skor_personal) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, judul);
            pstmt.setString(2, platform);
            pstmt.setString(3, genre);
            pstmt.setInt(4, skor);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("\nBerhasil! Game '" + judul + "' sudah masuk ke koleksi Sir Rangga.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}