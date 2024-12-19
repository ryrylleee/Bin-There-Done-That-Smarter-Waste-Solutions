package Users;

import Main.Main;
import Main.WasteManagementSystem;
import Waste.Waste;
import java.util.Scanner;

public class User {
    private String username;
    private String password;

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
                    } else {
                        System.out.println("=========================================================================");
                        System.out.println("\t\tUnable to categorize this item.");
                        System.out.println("=========================================================================");
                    }
                    break;
                case 2:
                    system.displayDisposalLog();
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
}
