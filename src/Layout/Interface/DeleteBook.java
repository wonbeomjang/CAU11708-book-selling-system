package Layout.Interface;

import DataUtils.Book.Book;
import DataUtils.User.User;

import java.util.Observable;

public abstract class DeleteBook extends Observable {
    public abstract boolean deleteBook(User user, Book book);
}
