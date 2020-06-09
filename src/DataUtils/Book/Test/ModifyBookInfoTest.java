package DataUtils.Book.Test;

import DataUtils.Book.BookCondition;
import DataUtils.Book.BookOnSale;
import DataUtils.Book.ModifyBookInfo;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ModifyBookInfoTest {
    ModifyBookInfo modifyBookInfo;
    BookCondition condition;
    User owner;
    BookOnSale book;
    String price;
    @BeforeEach
    void setUp() {
        modifyBookInfo = new ModifyBookInfo();
        owner= new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        book = new BookOnSale("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner);
        condition = BookCondition.Fair;
        price = "900";
    }

    @Test
    void modifyPrice() {
        BookCondition pastCondition = book.getCondition();
        modifyBookInfo.modifyCondition(owner, book, condition);

        assertEquals(condition, book.getCondition());
        assertNotEquals(pastCondition, book.getCondition());
    }

    @Test
    void modifyCondition() {
        String pastPrice = book.getPrice();
        modifyBookInfo.modifyPrice(owner, book, price);

        assertEquals(price, book.getPrice());
        assertNotEquals(pastPrice, book.getPrice());
    }
}