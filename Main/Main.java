package Main;

import Users.Admin;
import Users.User;
import Utilities.DatabaseConnection;
import java.sql.Connection;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted!");
        }
    }

    public static void displayHeader() {
        clearScreen();
        System.out.println(" ____   ____  ____       ______  __ __    ___  ____     ___         ");
        System.out.println("|    \\ l    j|    \\     |      T|  T  T  /  _]|    \\   /  _]        ");
        System.out.println("|  o  ) |  T |  _  Y    |      ||  l  | /  [_ |  D  ) /  [_         ");
        System.out.println("|     T |  | |  |  |    l_j  l_j|  _  |Y    _]|    / Y    _]        ");
        System.out.println("|  O  | |  | |  |  |      |  |  |  |  ||   [_ |    \\ |   [_  __     ");
        System.out.println("|     | j  l |  |  |      |  |  |  |  ||     T|  .  Y|     TT  |    ");
        System.out.println("l_____j|____jl__j__j      l__j  l__j__jl_____jl__j\\_jl_____jl_ |    ");
        System.out.println(" ___     ___   ____     ___      ______  __ __   ____  ______ \\l    ");
        System.out.println("|   \\   /   \\ |    \\   /  _]    |      T|  T  T /    T|      T      ");
        System.out.println("|    \\ Y     Y|  _  Y /  [_     |      ||  l  |Y  o  ||      |      ");
        System.out.println("|  D  Y|  O  ||  |  Y    _]    l_j  l_j|  _  ||     |l_j  l_j      ");
        System.out.println("|     ||     ||  |  ||   [_       |  |  |  |  ||  _  |  |  |        ");
        System.out.println("|     |l     !|  |  ||     T      |  |  |  |  ||  |  |  |  |        ");
        System.out.println("l_____j \\___/ l__j__jl_____j      l__j  l__j__jl__j__j  l__j        ");
        System.out.println("                                                                     ");
    }

    public static void mainMenu(User userSystem, Admin adminSystem, WasteManagementSystem system, Connection conn) {
        boolean authenticated = false;
        boolean isAdmin = false;

        while (!authenticated) {
            displayHeader();
            System.out.println("=========================================================================");
            System.out.println("\t\t\t\tMenu");
            System.out.println("=========================================================================");
            System.out.println("\t\t\t1. Register (User)");
            System.out.println("\t\t\t2. Login (User)");
            System.out.println("\t\t\t3. Admin Login");
            System.out.println("\t\t\t4. Exit");
            System.out.println("=========================================================================");
            System.out.print("\t\t\tChoose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("=========================================================================");
                System.out.println("\t\tInvalid input. Please enter a number.");
                System.out.println("=========================================================================");
                sleep(1000);
                continue;
            }

            switch (choice) {
                case 1:
                    userSystem.register(scanner, conn);
                    break;
                case 2:
                    if (userSystem.login(scanner, conn)) {
                        authenticated = true;
                        isAdmin = false;
                        System.out.println("=========================================================================");
                        System.out.println("\t\t\tYou are now logged in!");
                        System.out.println("=========================================================================");
                        sleep(1000);
                    }
                    break;
                case 3:
                    if (adminSystem.login(scanner)) {
                        authenticated = true;
                        isAdmin = true;
                        sleep(1000);
                    }
                    break;
                case 4:
                    sleep(1000);
                    clearScreen();
                    displayHeader();
                    System.out.println("=========================================================================");
                    System.out.println("\t\t\tExiting the system. Goodbye!");
                    System.out.println("=========================================================================");
                    scanner.close();
                    return;
                default:
                    System.out.println("=========================================================================");
                    System.out.println("\t\tInvalid option. Please try again.");
                    System.out.println("=========================================================================");
                    sleep(1000);
            }
        }

        if (isAdmin) {
            adminSystem.manageSystem(scanner, system);
        } else {
            userSystem.interactWithWasteManagement(scanner, system);
        }
    }

    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.connect()) {
            User userSystem = new User();
            Admin adminSystem = new Admin();
            WasteManagementSystem system = new WasteManagementSystem();

        while (true) { // Loop to allow restarting the program
            mainMenu(userSystem, adminSystem, system);
            clearScreen();
            displayHeader();
            System.out.println("=========================================================================");
            System.out.println("\tDo you want to restart the program? (yes/no): ");
            System.out.println("=========================================================================");
            String restartChoice = scanner.nextLine().toLowerCase();

                if (!restartChoice.equals("yes")) {
                    clearScreen();
                    displayHeader();
                    System.out.println("=========================================================================");
                    System.out.println("\tThank you for using Bin There, Done That! \n\tContinue making a difference! \n\t\tGoodbye!");
                    System.out.println("=========================================================================");
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
        scanner.close();
    }
}
