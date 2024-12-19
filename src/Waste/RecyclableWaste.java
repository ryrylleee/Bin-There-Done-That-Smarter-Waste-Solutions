package Waste;

import static Main.Main.displayHeader;

public class RecyclableWaste extends Waste {
    public RecyclableWaste(String name) {
        super(name);
    }

    @Override
    public void processWaste() {
        System.out.println("Processing recyclable waste...");
    }

    @Override
    public String getEcoFriendlyTip() {
        displayHeader();
        System.out.println("==============================================================================");
        System.out.println("\t\tThe item \"" + getName() + "\" is recyclable.");
        System.out.println("==============================================================================");
        System.out.println("\tTip for bottles, cans, and plastic wastes: \nRinse the item before recycling. Remove caps or lids and recycle them separately.\n");
        System.out.println("\t\tTip for glass waste: \nClean it thoroughly before using it for other purposes. \nIf BROKEN, please wrap it in a paper before disposing it in a garbage bin.\n");
        System.out.println("\t\tTip for paper waste: \nAvoid shredding paper excessively as it reduces its recyclability. \nEnsure the paper is clean and dry.\n");
        System.out.println("\t\tTip for metal waste: \nSeparate aluminum and steel items. Use a magnet to identify steel (it sticks).\nFlatten cans to save space when recycling.\n");
        System.out.println("==============================================================================");
        return null;
    }
}
