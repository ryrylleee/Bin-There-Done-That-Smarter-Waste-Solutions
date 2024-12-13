package Users;

import Main.Main;
import static Main.Main.sleep;
import Main.WasteManagementSystem;
import Waste.Waste;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    
    private static final HashMap<String, String> registeredUsers = new HashMap<>();

    public void register(Scanner scanner) {
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\tUser Registration");
        System.out.println("=========================================================================");
        System.out.print("\t\t\tEnter a username: ");
        this.username = scanner.nextLine();
        System.out.print("\t\t\tEnter a password: ");
        this.password = scanner.nextLine();
        
        registeredUsers.put(username, password);
        
        System.out.println("=========================================================================");
        System.out.println("\t\tRegistration successful for " + username + "!");
        System.out.println("=========================================================================");
    }

    // Login Method for User
    public boolean login(Scanner scanner) {
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\tUser Login:");
        System.out.println("=========================================================================");
        System.out.print("\t\t\tEnter username: ");
        this.username = scanner.nextLine();
        System.out.print("\t\t\tEnter password: ");
        this.password = scanner.nextLine();
        System.out.println("=========================================================================");
        return true;
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
                        system.logDisposal(waste);
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
    public void displayUsers() {
        if (registeredUsers.isEmpty()) {
            Main.displayHeader();
            System.out.println("=========================================================================");
            System.out.println("\t\tNo users are currently registered.");
            System.out.println("=========================================================================");
            return;
        }
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\tList of Registered Users:");
        System.out.println("=========================================================================");
        for (String user : registeredUsers.keySet()) {
            System.out.println("\t\t- " + user);
        }
        System.out.println("=========================================================================");
    }
}
