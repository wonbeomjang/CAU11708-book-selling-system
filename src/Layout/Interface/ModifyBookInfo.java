package Layout.Interface;

import DataUtils.Book.BookCondition;
import DataUtils.Book.BookOnSale;
import DataUtils.User.User;

public interface ModifyBookInfo {
    boolean modifyPrice(User owner, BookOnSale book, String price);
    boolean modifyCondition(User owner, BookOnSale book, BookCondition condition);
}
