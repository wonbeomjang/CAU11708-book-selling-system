package DataUtils.Book;

import DataUtils.User.User;
import Layout.Interface.RegisterBook;

public class AddBook implements RegisterBook {
    BookSaleList bookSaleList;

    public AddBook(BookSaleList bookSaleList) {
        this.bookSaleList = bookSaleList;
    }

    @Override
    public boolean addBook(String title, String publicYear, String publisher, String author, int price, BookCondition condition, User owner) {
        bookSaleList.addBook(new BookOnSale(title, publicYear, publisher, author, price, condition, owner));
        return true;
    }

    public boolean addBook(Book book) {
        bookSaleList.addBook(book);
        return true;
    }

}
