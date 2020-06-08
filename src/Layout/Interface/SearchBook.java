package Layout.Interface;

import DataUtils.Book.Book;
import DataUtils.Book.BookKeyType;
import DataUtils.Book.UndefinedBookKeyException;

public interface SearchBook {
    Book[] search(String key, BookKeyType keyType) throws UndefinedBookKeyException;
}
