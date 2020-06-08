package Layout.Interface;

import DataUtils.Book.Book;
import DataUtils.User.User;

public interface BuyBook {
    boolean buyBook(User seller, User buyer, Book book);
}
