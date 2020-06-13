package DataUtils.Book;

import DataUtils.User.User;
import Utils.HashFunction;

import java.io.Serializable;

public class BookOnSale extends Book implements Serializable {
    String price;
    BookCondition condition;

    public BookOnSale(String title, String public_year, String publisher, String author, String price,
               BookCondition condition, String owner) {
        //ISBN설정해야함
        super(title, HashFunction.hash(title + public_year + publisher), public_year, publisher, author, owner);
        if(!price.equals("")) Integer.parseInt(price);
        this.price = price;
        this.condition = condition;
    }

    public BookOnSale(String title, String isbn, String public_year, String publisher, String author, String price,
                      BookCondition condition, String owner) {
        super(title, isbn, public_year, publisher, author, owner);
        this.price = price;
        this.condition = condition;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCondition(BookCondition condition) {
        this.condition = condition;
    }

    public String getPrice() {
        return price;
    }

    public BookCondition getCondition() {
        return condition;
    }

    @Override
    public String toString() {

        return title + ": " + isbn +": " + public_year + ": " + publisher + ": " + author + ": " + price + ": " + condition.toString() +
                ": " + owner + '\n';
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner.toString();
    }
}
