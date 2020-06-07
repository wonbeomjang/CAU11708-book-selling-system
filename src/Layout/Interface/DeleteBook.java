package Layout.Interface;

import DataUtils.Book.Book;
import DataUtils.User.User;

public interface DeleteBook {
    boolean deleteBook(User user, Book book);
}
