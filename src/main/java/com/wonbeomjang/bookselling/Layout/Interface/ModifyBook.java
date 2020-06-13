package com.wonbeomjang.bookselling.Layout.Interface;

import com.wonbeomjang.bookselling.DataUtils.Book.Book;

import java.util.Observable;

public abstract class ModifyBook extends Observable {
    public abstract boolean modify(Book oldBook, Book newBook);
}
