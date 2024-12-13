package Waste;

public abstract class Waste {   
    private final String wasteItemString;

    public Waste(String name) {
        this.wasteItemString = name;
    }

    public String getName() {
        return wasteItemString;
    }

    public abstract void processWaste();

    public abstract String getEcoFriendlyTip();
}
