package Layout.Interface;

import DataUtils.Book.BookCondition;
import DataUtils.User.User;

public interface RegisterBook  {
  boolean  addBook(String title, String publicYear, String publisher, String author, int price, BookCondition condition, User owner);
}
