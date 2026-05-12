import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TambahGame {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_koleksi_game";
        String user = "root";
        String password = "";

        // Data game yang ingin dimasukkan
        String judul = "Battlefield 3";
        String platform = "PS 5";
        String genre = "FPS";
        int skor = 10;
        String sql = "INSERT INTO tb_retro_games (judul_game, platform, genre, skor_personal) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Mengisi parameter (?) dengan data
            pstmt.setString(1, judul);
            pstmt.setString(2, platform);
            pstmt.setString(3, genre);
            pstmt.setInt(4, skor);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Sip Sir Rangga! Game '" + judul + "' berhasil disimpan ke database.");
            }

        } catch (SQLException e) {
            System.out.println("Waduh, gagal simpan data:");
            e.printStackTrace();
        }
    }
}