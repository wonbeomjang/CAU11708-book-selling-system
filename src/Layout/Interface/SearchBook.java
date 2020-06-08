package Layout.Interface;

import DataUtils.Book.Book;
import DataUtils.Book.BookKeyType;

import java.util.Observable;

public abstract class SearchBook extends Observable {
    public abstract Book[] search(String key, BookKeyType keyType);
}
