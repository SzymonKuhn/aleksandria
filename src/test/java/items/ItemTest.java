package items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void shouldGetShortDescription() {
        //Given
        Item book = new Book("title", 10, 10, "author", "this is descpription of this book and it is long version of description", 100, BookType.POETRY);

        //When
        String shortDescr = book.getShortDescpription();

        //Then
        assertEquals("this is descpription of this", shortDescr);
    }


    @Test
    void shouldGetShortDescriptionWhenDescriptionIsShorter() {
        //Given
        Item book2 = new Book("title", 10, 10, "author", "this is description", 100, BookType.POETRY);
        Item book3 = new Book("title", 10, 10, "author", "", 100, BookType.POETRY);

        //When
        String shortDescr2 = book2.getShortDescpription();
        String shortDescr3 = book3.getShortDescpription();

        //Then
        assertEquals("this is description", shortDescr2);
        assertEquals("", shortDescr3);
    }

}