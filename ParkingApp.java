import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParkingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Parking Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel licenseLabel = new JLabel("License Plate:");
        licenseLabel.setBounds(10, 20, 120, 25);
        panel.add(licenseLabel);

        JTextField licenseText = new JTextField(20);
        licenseText.setBounds(140, 20, 165, 25);
        panel.add(licenseText);

        JButton enterButton = new JButton("Enter Parking");
        enterButton.setBounds(10, 60, 150, 25);
        panel.add(enterButton);

        JButton exitButton = new JButton("Exit Parking");
        exitButton.setBounds(180, 60, 150, 25);
        panel.add(exitButton);

        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String licensePlate = licenseText.getText();
                VehicleDAO.enterVehicle(licensePlate);
                JOptionPane.showMessageDialog(null, "Vehicle Entered.");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String licensePlate = licenseText.getText();
                ExitVehicle.exitVehicle(licensePlate);
                JOptionPane.showMessageDialog(null, "Vehicle Exited.");
            }
        });
    }
}
