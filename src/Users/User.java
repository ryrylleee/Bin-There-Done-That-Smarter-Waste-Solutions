package Users;

import Main.Main;
import static Main.Main.sleep;
import Main.WasteManagementSystem;
import Waste.Waste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
    private String username;
    private String password;

    public void register(Scanner scanner, Connection conn) {
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\tUser Registration");
        System.out.println("=========================================================================");
        System.out.print("\t\t\tEnter a username: ");
        this.username = scanner.nextLine();
        System.out.print("\t\t\tEnter a password: ");
        this.password = scanner.nextLine();

        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();

            System.out.println("=========================================================================");
            System.out.println("\t\tRegistration successful for " + username + "!");
            System.out.println("=========================================================================");
        } catch (SQLException e) {
            System.err.println("Error during registration: " + e.getMessage());
        }
    }

    public boolean login(Scanner scanner, Connection conn) {
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\tUser Login:");
        System.out.println("=========================================================================");
        System.out.print("\t\t\tEnter username: ");
        this.username = scanner.nextLine();
        System.out.print("\t\t\tEnter password: ");
        this.password = scanner.nextLine();
        System.out.println("=========================================================================");

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("\t\tLogin successful! Welcome, " + username + "!");
                System.out.println("=========================================================================");
                return true;
            } else {
                System.out.println("\t\tInvalid username or password. Please try again.");
                System.out.println("=========================================================================");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error during login: " + e.getMessage());
            return false;
        }
    }

    public void interactWithWasteManagement(Scanner scanner, WasteManagementSystem system) {
        boolean exit = false;
        while (!exit) {
            Main.displayHeader();
            System.out.println("=========================================================================");
            System.out.println("\t\t\t\tUser Menu");
            System.out.println("=========================================================================");
            System.out.println("\t\t1. Dispose of Waste");
            System.out.println("\t\t2. View Disposal Log");
            System.out.println("\t\t3. Exit");
            System.out.println("=========================================================================");
            System.out.print("\t\tChoose an option: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("=========================================================================");
                System.out.println("\t\tInvalid input. Please enter a number.");
                System.out.println("=========================================================================");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("\t\tEnter the waste item to dispose of: ");
                    String wasteName = scanner.nextLine();
                    Waste waste = system.categorizeWaste(wasteName);
                    if (waste != null) {
                        system.logDisposal(username, wasteName); // Passing username and waste item name
                        sleep(5000);
                    } else {
                        System.out.println("=========================================================================");
                        System.out.println("\t\tUnable to categorize this item.");
                        System.out.println("=========================================================================");
                    }
                    break;
                case 2:
                    system.displayDisposalLog();
                    sleep(5000);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("=========================================================================");
                    System.out.println("\t\tInvalid option. Please try again.");
                    System.out.println("=========================================================================");
            }
        }
    }

    public void displayUsers(Connection conn) {
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\tList of Registered Users:");
        System.out.println("=========================================================================");

        String sql = "SELECT username FROM users";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            boolean hasUsers = false;
            while (rs.next()) {
                hasUsers = true;
                System.out.println("\t\t- " + rs.getString("username"));
            }

            if (!hasUsers) {
                System.out.println("\t\tNo users are currently registered.");
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving users: " + e.getMessage());
        }

        System.out.println("=========================================================================");
    }
}