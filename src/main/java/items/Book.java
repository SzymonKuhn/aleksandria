package items;

public class Book extends Item {
    private final int pages;
    private final BookType bookType;

    public Book(String title, int amount, int availableAmount, String author, String description, int pages, BookType bookType) {
        super(title, amount, availableAmount, author, description);
        this.pages = pages;
        this.bookType = bookType;
    }

    public int getPages() {
        return pages;
    }

    public BookType getBookType() {
        return bookType;
    }
}
