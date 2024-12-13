package Users;

import Main.Main;
import Main.WasteManagementSystem;
import Waste.Waste;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    private HashMap<String, String> users;

    public User() {
        users = new HashMap<>();
        users.put("user1", "password1"); //default user
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void register(Scanner scanner) {
        clearScreen();
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\tUser Registration");
        System.out.println("=========================================================================");
        System.out.print("\t\t\tEnter a new username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("=========================================================================");
            System.out.println("\t\tUsername already exists. Try a different one.");
            return;
        }

        System.out.print("\t\t\tEnter a new password: ");
        String password = scanner.nextLine();

        users.put(username, password); 
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\tRegistration successful! You can now log in.");
        System.out.println("=========================================================================");
    }

    public boolean login(Scanner scanner) {
        clearScreen();
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\t\tUser Login");
        System.out.println("=========================================================================");
        System.out.print("\t\t\tEnter your username: ");
        String username = scanner.nextLine();
        System.out.print("\t\t\tEnter your password: ");
        String password = scanner.nextLine();
        System.out.println("=========================================================================");

        if (users.containsKey(username) && users.get(username).equals(password)) {
            Main.displayHeader();
            System.out.println("=========================================================================");
            System.out.println("\t\tLogin successful! Welcome, " + username + "!");
            System.out.println("=========================================================================");
            return true;
        } else {
            System.out.println("=========================================================================");
            System.out.println("\t\tInvalid username or password. Please try again.");
            System.out.println("=========================================================================");
            return false;
        }
    }

    public void displayUsers() {
        clearScreen();
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\t\t♻ Registered Users ♻");
        System.out.println("=========================================================================");
        if (users.isEmpty()) {
            System.out.println("\t\tNo users have registered yet.");
        } else {
            for (String username : users.keySet()) {
                System.out.println("\t\t- " + username);
            }
        }
        System.out.println("=========================================================================");
    }

    public void interactWithWasteManagement(Scanner scanner, WasteManagementSystem system) {
        boolean running = true;

        while (running) {
            Main.displayHeader();
            System.out.println("=========================================================================");
            System.out.println("\tEnter the item you want to dispose of (or type 'exit' to quit): ");
            System.out.println("=========================================================================");
            String itemName = scanner.nextLine().toLowerCase();

            if (itemName.equals("exit")) {
                running = false;
                break;
            }

            Waste wasteItem = system.categorizeWaste(itemName);

            if (wasteItem != null) {
                System.out.println("=========================================================================");
                System.out.println("You are disposing of a " + wasteItem.getClass().getSimpleName() + " item.");
                wasteItem.processWaste();
                System.out.println("=========================================================================");
                System.out.println("Would you like to log this disposal for environmental impact tracking? (yes/no): ");
                System.out.println("=========================================================================");
                String trackChoice = scanner.nextLine().toLowerCase();

                if (trackChoice.equals("yes")) {
                    system.logDisposal(wasteItem);
                }
            } else {
                Main.displayHeader();
                System.out.println("=========================================================================");
                System.out.println("Sorry, the item '" + itemName + "' is not recognized in our waste categories.");
                System.out.println("=========================================================================");
            }

            System.out.println("=========================================================================");
            System.out.println("\t\tWould you like an eco-friendly tip? (yes/no): ");
            System.out.println("=========================================================================");
            String tipChoice = scanner.nextLine().toLowerCase();

            if (tipChoice.equals("yes")) {
                System.out.println(wasteItem.getEcoFriendlyTip());
                Main.sleep(5000);
            }
        }
    }
}
