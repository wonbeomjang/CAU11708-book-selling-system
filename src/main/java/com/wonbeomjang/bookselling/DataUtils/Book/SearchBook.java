package com.wonbeomjang.bookselling.DataUtils.Book;

import java.util.ArrayList;

public class SearchBook extends com.wonbeomjang.bookselling.Layout.Interface.SearchBook {
    private final BookSaleList bookSaleList;

    public SearchBook() {
        this.bookSaleList = BookSaleList.getInstance();
    }

    public boolean compareByKey(Book book, String key, BookKeyType keyType) {
        if (keyType == BookKeyType.Title) return book.title.equals(key);
        if (keyType == BookKeyType.ISBN) return book.isbn.equals(key);
        if (keyType == BookKeyType.Author) return book.author.equals(key);
        if (keyType == BookKeyType.Username) return book.owner.equals(key);
        return false;
    }

    @Override
    public Book[] search(String key, BookKeyType keyType) {
        Book[] bookArray;
        ArrayList<Book> books = new ArrayList<>();

        if(key == null) return bookSaleList.getBooks();


        for(int i = 0; i < bookSaleList.getNumBooks(); i++) {
            if(compareByKey(bookSaleList.getBook(i), key, keyType)) {
                books.add(bookSaleList.getBook(i));
            }
        }

        bookArray = books.toArray(new Book[0]);

        setChanged();
        notifyObservers(bookArray);

        return bookArray;
    }
}
