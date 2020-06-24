package com.wonbeomjang.bookselling.DataUtils.Book;

public class ModifyBook extends com.wonbeomjang.bookselling.Layout.Interface.ModifyBook {
    @Override
    public boolean modify(Book oldBook, Book newBook) {
        BookSaleList bookSaleList = BookSaleList.getInstance();

        if(!bookSaleList.contain(oldBook))
            return false;

        oldBook.setTitle(newBook.getTitle());
        oldBook.setIsbn(newBook.getIsbn());
        oldBook.setPublicYear(newBook.getPublicYear());
        oldBook.setPublisher(newBook.getPublisher());
        oldBook.setAuthor(newBook.getAuthor());

        oldBook.setPrice(newBook.getPrice());
        oldBook.setCondition(newBook.getCondition());

        bookSaleList.saveData();

        setChanged();
        notifyObservers(oldBook);

        return true;
    }
}
