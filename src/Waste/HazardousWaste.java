package Waste;

import static Main.Main.displayHeader;

public class HazardousWaste extends Waste {
    public HazardousWaste(String name) {
        super(name);
    }

    @Override
    public void processWaste() {
        System.out.println("Processing hazardous waste...");
    }

    @Override
    public String getEcoFriendlyTip() {
        displayHeader();
        System.out.println("=========================================================================");
        System.out.println("\t\tThe item \"" + getName() + "\" is hazardous.");
        System.out.println("==============================================================================");
        System.out.println("Tip: Dispose of this item at a designated hazardous waste disposal center.");
        System.out.println("Tip: Avoid storing hazardous waste in areas accessible to children or pets.");
        System.out.println("Tip: Use appropriate protective gear when handling hazardous materials.");
        System.out.println("Tip: Do not mix different types of hazardous waste in the same container.");
        System.out.println("==============================================================================");
        return null;
    }
}
