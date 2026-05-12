import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_koleksi_game";
        String user = "root"; 
        String password = ""; 

        try {
            // Baris baru: Memaksa Java untuk memuat Driver MySQL ke memori
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Luar biasa Sir Rangga! Java sudah terhubung ke database Laragon.");
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver MySQL tidak ditemukan.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Koneksi gagal. Silakan periksa pesan error berikut:");
            e.printStackTrace();
        }
    }
}