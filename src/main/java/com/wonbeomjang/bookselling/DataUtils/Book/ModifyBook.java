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
        oldBook.setPublicYear(newBook.getPublicYear());
        oldBook.setPublisher(newBook.getPublisher());
        oldBook.setAuthor(newBook.getAuthor());

        if(oldBook instanceof Book && newBook instanceof Book) {
            Book oldBookOnSale = (Book) oldBook;
            Book newBookOnSale = (Book) newBook;
            oldBookOnSale.setPrice(newBookOnSale.getPrice());
            oldBookOnSale.setCondition(newBookOnSale.getCondition());
        }

        bookSaleList.saveData();

        setChanged();
        notifyObservers(oldBook);

        return true;
    }
}
