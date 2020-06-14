package BookTest;

import com.wonbeomjang.bookselling.DataUtils.Book.*;
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
        SetUp.setup(true);

        bookSaleList = BookSaleList.getInstance();

        addBook = new AddBook();
        owner = new User("wonbeomjang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "01037937352", "jtiger958" );
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