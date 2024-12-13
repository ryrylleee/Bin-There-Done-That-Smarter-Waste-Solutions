package Users;

import Main.Main;
import Main.WasteManagementSystem;
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

    public void manageSystem(Scanner scanner, WasteManagementSystem system, User userSystem) {
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
                    break;
                case 2:
                    userSystem.displayUsers();
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
}
