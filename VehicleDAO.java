import java.sql.*;

public class VehicleDAO {
    public static void enterVehicle(String licensePlate) {
        Connection conn = DatabaseConnection.getConnection();
        String query = "INSERT INTO vehicles (license_plate, slot_id) VALUES (?, (SELECT slot_id FROM parking_slots WHERE is_occupied = FALSE LIMIT 1))";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, licensePlate);
            pstmt.executeUpdate();
            System.out.println("Vehicle entered and assigned a slot.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
