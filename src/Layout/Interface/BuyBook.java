package Layout.Interface;

import DataUtils.Book.Book;
import DataUtils.User.User;

import java.util.Observable;

public abstract class BuyBook extends Observable {
    public abstract boolean buyBook(User buyer, Book book);
}
