package users;

import items.Book;
import items.BookType;
import items.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User ("name", "surname", "email", "pass", UserType.CLIENT);
    }

    @Test
    void borrowItemShouldAddItemToUsersItemsArrayWhenArrayIsEmpty() {
        //given
        Item book = new Book ("title", 10, 9, "author", "description", 100, BookType.POETRY);

        //when
        boolean result = user.borrowItem(book);

        //then
        assertTrue(result);
        assertEquals(book, user.getItemsBorrowed()[0]);
    }

    @Test
    void borrowItemShouldAddItemToUsersItemsArrayWhenArrayIsNotEmpty() {
        //given
        Item book = new Book ("title", 10, 9, "author", "description", 100, BookType.POETRY);
        Item book2 = new Book ("title", 10, 9, "author", "description", 100, BookType.POETRY);
        Item book3 = new Book ("title", 10, 9, "author", "description", 100, BookType.POETRY);

        //when
        boolean result1 = user.borrowItem(book);
        boolean result2 = user.borrowItem(book2);
        boolean result3 = user.borrowItem(book3);

        //then
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertEquals(book, user.getItemsBorrowed()[0]);
        assertEquals(book2, user.getItemsBorrowed()[1]);
        assertEquals(book3, user.getItemsBorrowed()[2]);
    }

    @Test
    void borrowItemShouldNotAddItemToUsersItemsArrayWhenArrayIsFull() {
        //given
        Item book = new Book ("title", 10, 9, "author", "description", 100, BookType.POETRY);
        Item book2 = new Book ("title", 10, 9, "author", "description", 100, BookType.POETRY);
        Item book3 = new Book ("title", 10, 9, "author", "description", 100, BookType.POETRY);

        //when
        boolean result1 = user.borrowItem(book);
        boolean result2 = user.borrowItem(book2);
        boolean result3 = user.borrowItem(book3);
        boolean result4 = user.borrowItem(book3);

        //then
        assertFalse(result4);
        assertEquals(book, user.getItemsBorrowed()[0]);
        assertEquals(book2, user.getItemsBorrowed()[1]);
        assertEquals(book3, user.getItemsBorrowed()[2]);
    }
}