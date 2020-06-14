package BookTest;

import com.wonbeomjang.bookselling.DataUtils.Book.*;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Utils.SetUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DeleteBookTest {
    User owner, other;
    DeleteBook deleteBook;
    BookSaleList bookSaleList;
    AddBook addBook;
    Book book;

    int numBooks;

    @BeforeEach
    void setUp() {

        SetUp.setup(true);

        bookSaleList = BookSaleList.getInstance();

        addBook = new AddBook();
        deleteBook = new DeleteBook();
        owner = new User("wonbeomjang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "01037937352", "jtiger958" );
        other = new User("wonbeom", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "jtiger958", "01037937352");
        book = new BookOnSale("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner.getUsername());

        addBook.addBook(book);
    }

    @Test
    void deleteBook() {
        numBooks = bookSaleList.getNumBooks();
        deleteBook.deleteBook(owner, book);
        assertEquals(numBooks - 1, bookSaleList.getNumBooks());
        assertFalse(bookSaleList.contain(book));
        assertFalse(deleteBook.deleteBook(other, book));
    }
}