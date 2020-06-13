package com.wonbeomjang.bookselling.DataUtils.Book;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.Interface.RegisterBook;

public class AddBook extends RegisterBook {
    private final BookSaleList bookSaleList;

    public AddBook() {
        this.bookSaleList = BookSaleList.getInstance();
    }

    @Override
    public boolean addBook(String title, String publicYear, String publisher, String author, String price, BookCondition condition, User owner) {
        Book book = new BookOnSale(title, publicYear, publisher, author, price, condition, owner.getUsername());
        bookSaleList.addBook(book);
        bookSaleList.saveData();

        setChanged();
        notifyObservers(book);
        return true;
    }

    @Override
    public boolean addBook(String title, String isbn, String publicYear, String publisher, String author, String price, BookCondition condition, User owner) {
        Book book = new BookOnSale(title, isbn, publicYear, publisher, author, price, condition, owner.getUsername());
        bookSaleList.addBook(book);
        bookSaleList.saveData();

        setChanged();
        notifyObservers(book);
        return true;
    }

    public boolean addBook(Book book) {
        bookSaleList.addBook(book);
        bookSaleList.saveData();

        setChanged();
        notifyObservers(book);
        return true;
    }

}
