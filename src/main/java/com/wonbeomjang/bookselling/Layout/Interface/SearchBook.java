package com.wonbeomjang.bookselling.Layout.Interface;

import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.Book.BookKeyType;

import java.util.Observable;

public abstract class SearchBook extends Observable {
    public abstract Book[] search(String key, BookKeyType keyType);
}
