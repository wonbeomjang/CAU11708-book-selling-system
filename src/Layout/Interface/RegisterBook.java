package Layout.Interface;

import DataUtils.Book.BookCondition;
import DataUtils.User.User;

import java.util.Observable;

public abstract class RegisterBook extends Observable {
  public abstract boolean addBook(String title, String publicYear, String publisher, String author, int price, BookCondition condition, User owner);
}
