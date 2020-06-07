package DataUtils.Book;

import DataUtils.User.User;

import java.time.Year;

public class BookOnSale extends Book {
    int price;
    BookCondition condition;
    User owner;

    public BookOnSale(String title, Year public_year, String publisher, String author, int price,
               BookCondition status, User owner) {
        super(title, "123", public_year, publisher, author);
        this.price = price;
        this.condition = status;
        this.owner = owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCondition(BookCondition condition) {
        this.condition = condition;
    }

    public int getPrice() {
        return price;
    }

    public BookCondition getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "domain.BookOnSale{" +
                "price=" + price +
                ", condition=" + condition +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", public_year=" + public_year +
                ", publisher='" + publisher + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
