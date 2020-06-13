package com.wonbeomjang.bookselling.DataUtils.Book;

public class ModifyBook extends com.wonbeomjang.bookselling.Layout.Interface.ModifyBook {
    private BookSaleList bookSaleList;
    @Override
    public boolean modify(Book oldBook, Book newBook) {
        bookSaleList = BookSaleList.getInstance();

        if(!bookSaleList.contain(oldBook))
            return false;

        oldBook.setTitle(newBook.getTitle());
        oldBook.setIsbn(newBook.getIsbn());
        oldBook.setPublic_year(newBook.getPublic_year());
        oldBook.setPublisher(newBook.getPublisher());
        oldBook.setAuthor(newBook.getAuthor());

        if(oldBook instanceof BookOnSale && newBook instanceof BookOnSale) {
            BookOnSale oldBookOnSale = (BookOnSale) oldBook;
            BookOnSale newBookOnSale = (BookOnSale) newBook;
            oldBookOnSale.setPrice(newBookOnSale.getPrice());
            oldBookOnSale.setCondition(newBookOnSale.getCondition());
        }

        bookSaleList.saveData();

        setChanged();
        notifyObservers(oldBook);

        return true;
    }
}
