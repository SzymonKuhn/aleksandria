package items;

public abstract class Item {
    private final String title;
    private final String author;
    private final int amount;
    private int availableAmount;
    private final String description;

    public Item(String title, int amount, int availableAmount, String author, String description) {
        this.title = title;
        this.amount = amount;
        this.availableAmount = availableAmount;
        this.author = author;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAmount() {
        return amount;
    }

    public boolean titleContains(String title) {
        return (this.title.contains(title));
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescpription () { //miało być 50 znaków w zaokrągleniu do pełnego wyrazu...
        String[] descriptionArray = getDescription().split(" ");
        if (descriptionArray.length < 6) return getDescription();

        StringBuilder shortDescription = new StringBuilder();
        for (int i = 0; i < 4; i ++) {
            shortDescription.append(descriptionArray[i] + " ");
        }
        shortDescription.append(descriptionArray[4]);
        return shortDescription.toString();
    }
}
