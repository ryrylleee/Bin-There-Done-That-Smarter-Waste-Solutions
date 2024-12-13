package Main;

import Waste.CompostableWaste;
import Waste.HazardousWaste;
import Waste.RecyclableWaste;
import Waste.Waste;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WasteManagementSystem {
    private final List<String> disposalLog;
    private final Scanner scanner;

    public WasteManagementSystem() {
        this.disposalLog = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public Waste categorizeWaste(String itemName) {
        if (itemName.contains("plastic") || itemName.contains("can") || itemName.contains("bottle") || itemName.contains("paper") || itemName.contains("glass") || itemName.contains("metal")) {
            return new RecyclableWaste(itemName);
        } else if (itemName.contains("banana") || itemName.contains("apple") || itemName.contains("peel") || itemName.contains("leaves") || itemName.contains("vegetables") || itemName.contains("egg shells") || itemName.contains("leftover")) {
            return new CompostableWaste(itemName);
        } else if (itemName.contains("battery") || itemName.contains("paint") || itemName.contains("fuel") || itemName.contains("gas")) {
            return new HazardousWaste(itemName);
        } else {
            return null;
        }
    }

    public void logDisposal(Waste wasteItem) {
        disposalLog.add(wasteItem.getName());
        Main.displayHeader();
        System.out.println("\tItem \"" + wasteItem.getName() + "\" has been added to your disposal log.");
        wasteItem.processWaste();
        wasteItem.getEcoFriendlyTip();
    }

    public void displayDisposalLog() {
        clearScreen();
        Main.displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\tWaste Disposal Summary");
        System.out.println("=========================================================================");
        if (disposalLog.isEmpty()) {
            System.out.println("\t\tNo items have been logged yet.");
        } else {
            for (String item : disposalLog) {
                System.out.println("\t\t\t\t\t- " + item);
            }
        }
        System.out.println("=========================================================================");
        System.out.println("\t\tContinue making a difference!");
        System.out.println("=========================================================================");
    }
}
