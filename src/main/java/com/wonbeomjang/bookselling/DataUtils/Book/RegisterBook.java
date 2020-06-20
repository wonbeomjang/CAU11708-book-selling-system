package com.wonbeomjang.bookselling.DataUtils.Book;

import com.wonbeomjang.bookselling.DataUtils.User.User;

public class RegisterBook extends com.wonbeomjang.bookselling.Layout.Interface.RegisterBook {
    private final BookSaleList bookSaleList;

    public RegisterBook() {
        this.bookSaleList = BookSaleList.getInstance();
    }

    @Override
    public boolean addBook(String title, String publicYear, String publisher, String author, String price, BookCondition condition, User owner) {
        bookSaleList.addBook(title, publicYear, publisher, author, price, condition, owner);

        setChanged();
        notifyObservers();
        return true;
    }

    @Override
    public boolean addBook(String title, String isbn, String publicYear, String publisher, String author, String price, BookCondition condition, User owner) {
        bookSaleList.addBook(title, isbn, publicYear, publisher, author, price, condition, owner);

        setChanged();
        notifyObservers();
        return true;
    }

    public boolean addBook(Book book) {
        bookSaleList.addBook(book);

        setChanged();
        notifyObservers(book);
        return true;
    }


}
