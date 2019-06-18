package items;

public class Vinyl extends Item {
    private double time;
    private VinylType vinylType;

    public Vinyl(String title, int amount, int availableAmount, String author, String description, double time, VinylType vinylType) {
        super(title, amount, availableAmount, author, description);
        this.time = time;
        this.vinylType = vinylType;
    }

    public double getTime() {
        return time;
    }

    public VinylType getVinylType() {
        return vinylType;
    }
}
