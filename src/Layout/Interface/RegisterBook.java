package Layout.Interface;

import DataUtils.Book.BookCondition;
import DataUtils.User.User;

import java.time.Year;

public interface RegisterBook  {
  boolean addBook(String title, Year publicYear, String publisher, String author, int price, BookCondition condition, User owner);
}
