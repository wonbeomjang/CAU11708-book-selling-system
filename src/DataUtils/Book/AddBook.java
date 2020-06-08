package DataUtils.Book;

import DataUtils.User.User;
import Layout.Interface.RegisterBook;

import java.time.Year;

public class AddBook implements RegisterBook {
    BookSaleList bookSaleList;
    String title;
    Year publicYear;
    String author;
    String publisher;
    int price = 0;
    BookCondition condition = BookCondition.Fair;
    User owner;

    public AddBook(BookSaleList bookSaleList) {
        this.bookSaleList = bookSaleList;
    }

    @Override
    public boolean addBook(String title, Year publicYear, String publisher, String author, int price, BookCondition condition, User owner) {
        this.title = title;
        this.publicYear = publicYear;
        this.author = author;
        this.price = price;
        this.condition = condition;
        this.owner = owner;

        return addBook();
    }

    public boolean addBook() {
        bookSaleList.addBook(new BookOnSale(title, publicYear, publisher, author, price, condition, owner));

        return true;
    }

    public boolean addBook(Book book) {
        bookSaleList.addBook(book);
        return true;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicYear(Year publicYear) {
        this.publicYear = publicYear;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setCondition(BookCondition condition) {
        this.condition = condition;
    }

}
