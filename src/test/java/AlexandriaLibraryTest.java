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

class AlexandriaLibraryTest {
    private static AlexandriaLibrary alexandriaLibrary;

    @BeforeAll
    static void setUp() {
        alexandriaLibrary = new AlexandriaLibrary();
    }

    @BeforeEach
    void beforeEach() {
        alexandriaLibrary.clearItemList();
        alexandriaLibrary.clearUserList();
    }

    @Test
    void shouldAddUserToUserList() {
        //Given
        final User user = new User ("Pablo", "Picasso", "pablo@picasso.com", "pablo666", UserType.CLIENT);

        //When
        alexandriaLibrary.addUser(user);

        //Then
        assertEquals(Arrays.asList(user), alexandriaLibrary.getUserList());
    }

    @Test
    void shouldAddItemToItemList() {
        //Given
        final Item book = new Book("Mister Tadeusz", 10, 10, "Adam Mickiewicz", "Epopeja's narodowa", 1342, BookType.POETRY);

        //When
        alexandriaLibrary.addItem(book);

        //Then
        assertEquals(Arrays.asList(book), alexandriaLibrary.getItemList());
    }

    @Test
    void shouldFindItemByTitle() {
        //Given
        final Item vinyl = new Vinyl ("Dark side of the moon", 10, 10, "Pink Floyd", "one of the greatest albums",54.30, VinylType.ROCK);
        alexandriaLibrary.addItem(vinyl);

        //When
        List<Item> itemsFound = alexandriaLibrary.searchByTitle("side");

        //Then
        assertEquals(Arrays.asList(vinyl), itemsFound);
    }

    @Test
    void shouldClearItemList() {
        //Given
        Item book = new Book("title", 9, 8, "author", "description", 100, BookType.POETRY);
        alexandriaLibrary.addItem(book);

        //When
        alexandriaLibrary.clearItemList();

        //Then
        assertEquals(Collections.emptyList(), alexandriaLibrary.getItemList());
    }

    @Test
    void sholudClearUserList() {
        //Given
        User user = new User ("name", "surname", "email@email.com", "password", UserType.CLIENT);
        alexandriaLibrary.addUser(user);

        //When
        alexandriaLibrary.clearUserList();

        //Then
        assertEquals(Collections.emptyList(), alexandriaLibrary.getUserList());
    }

    @Test
    void shouldFindMoreItemsByTitle() {
        //Given
        Item item1 = new Vinyl ("title1", 10, 8, "author", "description", 102.12, VinylType.POP);
        Item item2 = new Vinyl ("somethingdifferent", 10, 8, "author", "description",102.12, VinylType.POP);
        Item item3 = new Vinyl ("isintittitle", 10, 8, "author", "description",102.12, VinylType.POP);
        Item item4 = new Vinyl ("itsnotthatword", 10, 8, "author", "description",102.12, VinylType.POP);
        alexandriaLibrary.addItem(item1);
        alexandriaLibrary.addItem(item2);
        alexandriaLibrary.addItem(item3);
        alexandriaLibrary.addItem(item4);

        //When
        List<Item> itemsFound = alexandriaLibrary.searchByTitle("titl");

        //Then
        assertEquals(Arrays.asList(item1, item3), itemsFound);
    }

}