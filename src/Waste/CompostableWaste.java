package Waste;

import static Main.Main.displayHeader;

public class CompostableWaste extends Waste {
    public CompostableWaste(String name) {
        super(name);
    }

    @Override
    public void processWaste() {
        System.out.println("Processing compostable waste...");
    }

    @Override
    public String getEcoFriendlyTip() {
        displayHeader();
        System.out.println("==============================================================================");
        System.out.println("\t\tThe item \"" + getName() + "\" is compostable.");
        System.out.println("==============================================================================");
        System.out.println("Tip: Add this item to your compost bin. Avoid adding any plastic or non-organic materials.");
        System.out.println("Tip: Chop larger items like vegetable scraps into smaller pieces to speed up decomposition.");
        System.out.println("Tip: Maintain a balance of greens (wet materials like fruit peels) and browns (dry materials like leaves).");
        System.out.println("Tip: Keep your compost pile moist but not too wet, similar to a damp sponge.");
        System.out.println("Tip: Turn or mix your compost pile regularly to aerate it and speed up decomposition.");
        System.out.println("Tip: Avoid adding dairy, meat, or oily food items as they attract pests.");
        System.out.println("==============================================================================");
        return null;
    }
}
