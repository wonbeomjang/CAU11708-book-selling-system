package Layout.Interface;

import DataUtils.Book.Book;

import java.util.Observable;

public abstract class ModifyBook extends Observable {
    public abstract boolean modify(Book oldBook, Book newBook);
}
