package Main;

import Utilities.DatabaseConnection;
import Waste.CompostableWaste;
import Waste.HazardousWaste;
import Waste.RecyclableWaste;
import Waste.Waste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class WasteManagementSystem {
    private final Scanner scanner;

    public WasteManagementSystem() {
        this.scanner = new Scanner(System.in);
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public Waste categorizeWaste(String itemName) {
        if (itemName.contains("plastic") || itemName.contains("can") || itemName.contains("bottle")
                || itemName.contains("paper") || itemName.contains("glass") || itemName.contains("metal")) {
            return new RecyclableWaste(itemName);
        } else if (itemName.contains("banana") || itemName.contains("apple") || itemName.contains("peel")
                || itemName.contains("leaves") || itemName.contains("vegetables") || itemName.contains("egg shells")
                || itemName.contains("leftover")) {
            return new CompostableWaste(itemName);
        } else if (itemName.contains("battery") || itemName.contains("paint") || itemName.contains("fuel")
                || itemName.contains("gas")) {
            return new HazardousWaste(itemName);
        } else {
            return null;
        }
    }

    public void logDisposal(String username, String waste) {
        Waste wasteItem = categorizeWaste(waste);
        if (wasteItem == null) {
            System.out.println("=========================================================================");
            System.out.println("\tError: The item \"" + waste + "\" could not be categorized.");
            System.out.println("=========================================================================");
            return;
        }
    
        try (Connection conn = DatabaseConnection.connect()) {
            String query = "INSERT INTO disposal_logs (username, waste_item, waste_type) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, wasteItem.getName());
            ps.setString(3, wasteItem.getClass().getSimpleName());
    
            int rowsAffected = ps.executeUpdate();
    
            Main.displayHeader();
            if (rowsAffected > 0) {
                System.out.println("=========================================================================");
                System.out.println("\tItem \"" + wasteItem.getName() + "\" has been successfully logged.");
                System.out.println("=========================================================================");
                wasteItem.processWaste();
                wasteItem.getEcoFriendlyTip();
            } else {
                System.out.println("=========================================================================");
                System.out.println("\tFailed to log the item. Please try again.");
                System.out.println("=========================================================================");
            }
        } catch (SQLException e) {
            System.out.println("=========================================================================");
            System.out.println("\tError while logging the waste item.");
            System.out.println("=========================================================================");
            e.printStackTrace();
        }
    }
    
    public void displayDisposalLog() {
        clearScreen();
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\tWaste Disposal Log");
        System.out.println("=========================================================================");

        try (Connection conn = DatabaseConnection.connect()) {
            String query = "SELECT username, waste_item, waste_type, date_logged FROM disposal_logs";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            boolean hasLogs = false;
            while (rs.next()) {
                hasLogs = true;
                String username = rs.getString("username");
                String wasteItem = rs.getString("waste_item");
                String wasteType = rs.getString("waste_type");
                String dateLogged = rs.getString("date_logged");
                System.out.println("=========================================================================");
                System.out.println("User: " + username + " | Item: " + wasteItem + " | Type: " + wasteType
                        + " | Date: " + dateLogged);
                System.out.println("=========================================================================");
            }

            if (!hasLogs) {
                System.out.println("=========================================================================");
                System.out.println("\t\t\tNo disposal logs found.");
                System.out.println("=========================================================================");
            }
        } catch (SQLException e) {
            System.out.println("=========================================================================");
            System.out.println("\tError fetching the disposal logs.");
            System.out.println("=========================================================================");
            e.printStackTrace();
        }

        System.out.println("=========================================================================");
        System.out.println("\t\tThank you for helping the environment!");
        System.out.println("=========================================================================");
    }
}