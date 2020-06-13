package com.wonbeomjang.bookselling.Layout.Interface;

import com.wonbeomjang.bookselling.DataUtils.Book.BookCondition;
import com.wonbeomjang.bookselling.DataUtils.User.User;

import java.util.Observable;

public abstract class RegisterBook extends Observable {
  public abstract boolean addBook(String title, String publicYear, String publisher, String author, String price, BookCondition condition, User owner);
  public abstract boolean addBook(String title, String isbn, String publicYear, String publisher, String author, String price, BookCondition condition, User owner);
}
