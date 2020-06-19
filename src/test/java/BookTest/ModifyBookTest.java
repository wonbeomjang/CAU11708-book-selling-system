package BookTest;

import com.wonbeomjang.bookselling.DataUtils.Book.BookCondition;
import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.Book.BookSaleList;
import com.wonbeomjang.bookselling.DataUtils.Book.ModifyBook;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Utils.SetUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ModifyBookTest {
    ModifyBook modifyBook;
    User owner;
    Book oldBook;
    @BeforeEach
    void setUp() {

        SetUp.setup(true);

        BookSaleList bookSaleList = BookSaleList.getInstance();

        modifyBook = new ModifyBook();
        owner = new User("wonbeomjang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "01037937352", "jtiger958" );
        oldBook = new Book("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner.getUsername());

        bookSaleList.addBook(oldBook);

    }

    @Test
    void title() {
        Book newBook = new Book("Linux", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner.getUsername());
        modifyBook.modify(oldBook, newBook);
        assertEquals(oldBook.getTitle(), oldBook.getTitle());
    }

    @Test
    void publicYear() {
        Book newBook = new Book("Ubuntu", "2020", "장원범", "장원범", "1000", BookCondition.Excellent, owner.getUsername());
        modifyBook.modify(oldBook, newBook);
        assertEquals(oldBook.getPublicYear(), oldBook.getPublicYear());
    }

    @Test
    void publisher() {
        Book newBook = new Book("Ubuntu", "1999", "김혜성", "장원범", "1000", BookCondition.Excellent, owner.getUsername());
        modifyBook.modify(oldBook, newBook);
        assertEquals(newBook.getPublisher(), oldBook.getPublisher());
    }

    @Test
    void author() {
        Book newBook = new Book("Ubuntu", "1999", "장원범", "김혜성", "1000", BookCondition.Excellent, owner.getUsername());
        modifyBook.modify(oldBook, newBook);
        assertEquals(newBook.getAuthor(), oldBook.getAuthor());
    }

    @Test
    void price() {
        Book newBook = new Book("Ubuntu", "1999", "장원범", "장원범", "500", BookCondition.Excellent, owner.getUsername());
        modifyBook.modify(oldBook, newBook);
        assertEquals(newBook.getPrice(), oldBook.getPrice());
    }

    @Test
    void condition() {
        Book newBook = new Book("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Good, owner.getUsername());
        modifyBook.modify(oldBook, newBook);
        assertEquals(newBook.getCondition(), oldBook.getCondition());
    }

    @Test
    void user() {
        Book newBook = new Book("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Good, "");
        modifyBook.modify(oldBook, newBook);
        assertNotEquals(newBook.getOwner(), oldBook.getOwner());
    }
}