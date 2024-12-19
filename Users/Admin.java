package Users;

import Main.Main;
import static Main.Main.sleep;
import Main.WasteManagementSystem;
import Utilities.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
    private final String adminUsername = "admin";
    private final String adminPassword = "admin123";

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean login(Scanner scanner) {
        clearScreen();
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\t\tAdmin Login:");
        System.out.println("=========================================================================");
        System.out.print("\t\t\tEnter admin username: ");
        String username = scanner.nextLine();
        System.out.print("\t\t\tEnter admin password: ");
        String password = scanner.nextLine();
        System.out.println("=========================================================================");

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            clearScreen();
            Main.displayHeader();
            System.out.println("=========================================================================");
            System.out.println("\t\tAdmin login successful! Welcome, Admin!");
            System.out.println("=========================================================================");
            return true;
        } else {
            System.out.println("=========================================================================");
            System.out.println("\t\tInvalid admin credentials. Please try again.");
            System.out.println("=========================================================================");
            return false;
        }
    }

    public void manageSystem(Scanner scanner, WasteManagementSystem system) {
        while (true) {
            Main.displayHeader();
            System.out.println("\t\t\tAdmin Menu:");
            System.out.println("=========================================================================");
            System.out.println("\t\t1. View Disposal Log");
            System.out.println("\t\t2. View Registered Users");
            System.out.println("\t\t3. Logout");
            System.out.println("=========================================================================");
            System.out.print("\t\tChoose an option: ");

            int adminChoice;
            try {
                adminChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("=========================================================================");
                System.out.println("\t\tInvalid input. Please enter a number.");
                System.out.println("=========================================================================");
                continue;
            }

            switch (adminChoice) {
                case 1:
                    system.displayDisposalLog();
                    sleep(5000);
                    break;
                case 2:
                    displayRegisteredUsers();
                    sleep(5000);
                    break;
                case 3:
                    Main.displayHeader();
                    System.out.println("=========================================================================");
                    System.out.println("\t\t\tLogging out as Admin. Goodbye!");
                    System.out.println("=========================================================================");
                    return;
                default:
                    System.out.println("=========================================================================");
                    System.out.println("\t\tInvalid option. Please try again.");
                    System.out.println("=========================================================================");
            }
        }
    }
    
    private void displayRegisteredUsers() {
        clearScreen();
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\tRegistered Users");
        System.out.println("=========================================================================");

        try (Connection conn = DatabaseConnection.connect()) {
            String query = "SELECT username, date_registered FROM users";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            boolean hasUsers = false;
            while (rs.next()) {
                hasUsers = true;
                String username = rs.getString("username");
                String dateRegistered = rs.getString("date_registered");

                System.out.println("\tUsername: " + username + " | Registered On: " + dateRegistered);
            }

            if (!hasUsers) {
                System.out.println("\t\tNo registered users found.");
            }
        } catch (SQLException e) {
            System.out.println("\tError fetching registered users.");
            e.printStackTrace();
        }

        System.out.println("=========================================================================");
    }
}
