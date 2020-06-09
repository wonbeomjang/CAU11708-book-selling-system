package DataUtils.Book;

import DataUtils.User.User;
import Layout.Interface.RegisterBook;

public class AddBook extends RegisterBook {
    BookSaleList bookSaleList;

    public AddBook(BookSaleList bookSaleList) {
        this.bookSaleList = bookSaleList;
    }

    @Override
    public boolean addBook(String title, String publicYear, String publisher, String author, int price, BookCondition condition, User owner) {
        Book book = new BookOnSale(title, publicYear, publisher, author, price, condition, owner);
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
