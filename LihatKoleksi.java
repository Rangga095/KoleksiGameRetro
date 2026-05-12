import java.sql.*;

public class LihatKoleksi {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_koleksi_game";
        String user = "root";
        String password = "";

        // Query untuk mengambil semua data dari tabel
        String sql = "SELECT id, judul_game, platform, genre, skor_personal FROM tb_retro_games";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("====================================================");
            System.out.println("      DAFTAR KOLEKSI GAME RETRO SIR RANGGA          ");
            System.out.println("====================================================");
            System.out.printf("%-4s | %-20s | %-10s | %-5s\n", "ID", "JUDUL GAME", "PLATFORM", "SKOR");
            System.out.println("----------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String judul = rs.getString("judul_game");
                String platform = rs.getString("platform");
                int skor = rs.getInt("skor_personal");

                // Menampilkan data dengan format rapi
                System.out.printf("%-4d | %-20s | %-10s | %-5d/10\n", id, judul, platform, skor);
            }
            System.out.println("====================================================");

        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat mengambil data:");
            e.printStackTrace();
        }
    }
}