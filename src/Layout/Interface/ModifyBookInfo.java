package Layout.Interface;

import DataUtils.Book.BookCondition;
import DataUtils.Book.BookKeyType;
import DataUtils.Book.BookOnSale;
import DataUtils.User.User;

public interface ModifyBookInfo extends UpdateUnit {
    boolean modifyPrice(User owner, BookOnSale book, int price);
    boolean modifyCondition(User owner, BookOnSale book, BookCondition condition);
}
