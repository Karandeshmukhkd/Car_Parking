import java.sql.*;

public class DatabaseConnection {
    static final String URL = "jdbc:mysql://localhost:3306/ParkingDB";
    static final String USER = "root";
    static final String PASSWORD = "password";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
