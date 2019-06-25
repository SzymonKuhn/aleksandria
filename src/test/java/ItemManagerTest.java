import items.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import users.User;
import users.UserType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemManagerTest {
    private static ItemManager itemManager;

    @BeforeEach
    public void setUp() {
        itemManager = new ItemManager();
    }

    @Test
    void shouldAddItemToItemList() {
        //Given
        final Item book = new Book("Mister Tadeusz", 10, 10, "Adam Mickiewicz", "Epopeja's narodowa", 1342, BookType.POETRY);

        //When
        itemManager.addItem(book);

        //Then
        assertEquals(Arrays.asList(book), itemManager.getItemList());
    }

    @Test
    void shouldFindItemByTitle() {
        //Given
        final Item vinyl = new Vinyl ("Dark side of the moon", 10, 10, "Pink Floyd", "one of the greatest albums",54.30, VinylType.ROCK);
        itemManager.addItem(vinyl);

        //When
        List<Item> itemsFound = itemManager.searchItemByTitle("side");

        //Then
        assertEquals(Arrays.asList(vinyl), itemsFound);
    }

    @Test
    void shouldClearItemList() {
        //Given
        Item book = new Book("title", 9, 8, "author", "description", 100, BookType.POETRY);
        itemManager.addItem(book);

        //When
        itemManager.clearItemList();

        //Then
        assertEquals(Collections.emptyList(), itemManager.getItemList());
    }


    @Test
    void shouldFindMoreItemsByTitle() {
        //Given
        Item item1 = new Vinyl ("title1", 10, 8, "author", "description", 102.12, VinylType.POP);
        Item item2 = new Vinyl ("somethingdifferent", 10, 8, "author", "description",102.12, VinylType.POP);
        Item item3 = new Vinyl ("isintittitle", 10, 8, "author", "description",102.12, VinylType.POP);
        Item item4 = new Vinyl ("itsnotthatword", 10, 8, "author", "description",102.12, VinylType.POP);
        itemManager.addItem(item1);
        itemManager.addItem(item2);
        itemManager.addItem(item3);
        itemManager.addItem(item4);

        //When
        List<Item> itemsFound = itemManager.searchItemByTitle("titl");

        //Then
        assertEquals(Arrays.asList(item1, item3), itemsFound);
    }

    @Test
    void shouldFindAllItemsWhenEmptyStringIsSearching() {
        //Given
        Item item1 = new Vinyl ("title1", 10, 8, "author", "description", 102.12, VinylType.POP);
        Item item2 = new Vinyl ("somethingdifferent", 10, 8, "author", "description",102.12, VinylType.POP);
        Item item3 = new Vinyl ("isintittitle", 10, 8, "author", "description",102.12, VinylType.POP);
        Item item4 = new Vinyl ("itsnotthatword", 10, 8, "author", "description",102.12, VinylType.POP);
        itemManager.addItem(item1);
        itemManager.addItem(item2);
        itemManager.addItem(item3);
        itemManager.addItem(item4);

        //When
        List<Item> itemsFound = itemManager.searchItemByTitle("");

        //Then
        assertEquals(Arrays.asList(item1, item2, item3, item4), itemsFound);
    }

    @Test
    void searchShouldReturnEmptyListWhenItemListIsEmpty() {
        //Given

        //When
        List<Item> itemsFoundWithEmptyString = itemManager.searchItemByTitle("title");
        List<Item> itemsFoundWithFilledString = itemManager.searchItemByTitle("");

        //Then
        assertEquals(Collections.emptyList(), itemsFoundWithEmptyString);
        assertEquals(Collections.emptyList(), itemsFoundWithFilledString);
    }

    @Test
    void getItemListShouldGetItemList() {
        //Given
        Item item1 = new Vinyl ("title1", 10, 8, "author", "description", 102.12, VinylType.POP);
        Item item2 = new Vinyl ("somethingdifferent", 10, 8, "author", "description",102.12, VinylType.POP);
        Item item3 = new Vinyl ("isintittitle", 10, 8, "author", "description",102.12, VinylType.POP);
        Item item4 = new Vinyl ("itsnotthatword", 10, 8, "author", "description",102.12, VinylType.POP);
        itemManager.addItem(item1);
        itemManager.addItem(item2);
        itemManager.addItem(item3);
        itemManager.addItem(item4);

        //When
        List<Item> items = itemManager.getItemList();

        //Then
        assertEquals(Arrays.asList(item1, item2, item3, item4), items);
    }

    @Test
    void getItemShouldGetEmptyListWhenItlemListIsEmpty() {
        //Given

        //When
        List<Item> items = itemManager.getItemList();

        //Then
        assertEquals(Collections.emptyList(), items);
    }

    @Test
    void clearShouldClearItemList() {
        //Given
        Item item1 = new Vinyl ("title1", 10, 8, "author", "description", 102.12, VinylType.POP);
        Item item2 = new Vinyl ("somethingdifferent", 10, 8, "author", "description",102.12, VinylType.POP);
        Item item3 = new Vinyl ("isintittitle", 10, 8, "author", "description",102.12, VinylType.POP);
        Item item4 = new Vinyl ("itsnotthatword", 10, 8, "author", "description",102.12, VinylType.POP);
        itemManager.addItem(item1);
        itemManager.addItem(item2);
        itemManager.addItem(item3);
        itemManager.addItem(item4);

        //When
        itemManager.clearItemList();

        //Then
        assertEquals(Collections.emptyList(), itemManager.getItemList());
    }
}