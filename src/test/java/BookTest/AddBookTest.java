package BookTest;

import com.wonbeomjang.bookselling.DataUtils.Book.*;
import com.wonbeomjang.bookselling.DataUtils.User.EndUser;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Utils.SetUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddBookTest {
    User owner;
    AddBook addBook;
    BookSaleList bookSaleList;
    Book book;
    int numBooks = 0;

    @BeforeEach
    void setUp() {
        SetUp.setup();

        bookSaleList = BookSaleList.getInstance();

        addBook = new AddBook();
        owner = new EndUser("wonbeomjang", "20182592", "장원범", "01037937352", "jtiger958" );
    }

    @Test
    void addBookWithParam() {
        numBooks = bookSaleList.getNumBooks();
        addBook.addBook("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner);
        assertEquals(numBooks + 1, bookSaleList.getNumBooks());
    }

    @Test
    void addBookWithBookObject() {
        book = new BookOnSale("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner.getUsername());

        numBooks = bookSaleList.getNumBooks();
        addBook.addBook(book);

        assertEquals(numBooks + 1, bookSaleList.getNumBooks());
        assertTrue(bookSaleList.contain(book));
    }

}