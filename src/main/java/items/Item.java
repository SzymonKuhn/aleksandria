package items;

import java.time.LocalDateTime;

public abstract class Item {
    private final String title;
    private final String author;
    private final int amount;
    private int availableAmount;
    private final String description;
    private LocalDateTime borrowStart;
    private LocalDateTime boorowEnd;

    public Item(String title, int amount, int availableAmount, String author, String description) {
        this.title = title;
        this.amount = amount;
        this.availableAmount = availableAmount;
        this.author = author;
        this.description = description;
    }

    public int getAvailableAmount() {
        return availableAmount;
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
        if (description == null) return null;
        if (description.length() <=50) return description;
        String[] descriptionArray = getDescription().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < descriptionArray.length; i++) {
            result.append(descriptionArray[i]);
            if (result.length() > 50) return result.toString();
            result.append(" ");
        }
        return result.toString();
    }
}
