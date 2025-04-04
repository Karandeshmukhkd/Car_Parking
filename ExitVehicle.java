import java.sql.*;

public class ExitVehicle {
    public static void exitVehicle(String licensePlate) {
        Connection conn = DatabaseConnection.getConnection();
        String query = "UPDATE vehicles SET exit_time = NOW(), parking_fee = TIMESTAMPDIFF(HOUR, entry_time, NOW()) * 5 WHERE license_plate = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, licensePlate);
            pstmt.executeUpdate();
            System.out.println("Vehicle exited. Fee calculated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
