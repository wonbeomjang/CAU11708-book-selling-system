package DataUtils.Book;

import DataUtils.User.User;

import java.time.Year;

public class BookOnSale extends Book {
    int price;
    BookCondition condition;

    public BookOnSale(String title, Year public_year, String publisher, String author, int price,
               BookCondition condition, User owner) {
        super(title, "123", public_year, publisher, author, owner);
        this.price = price;
        this.condition = condition;
    }

    public BookOnSale(String title, String public_year, String publisher, String author, String price,
                      BookCondition condition, User owner) {
        super(title, "123", Year.of(Integer.parseInt(public_year)), publisher, author, owner);
        this.price = Integer.parseInt(price);
        this.condition = condition;
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
        String condition;
        if(this.condition.equals(BookCondition.Excellent)) condition = "Excellent";
        else if(this.condition.equals(BookCondition.Good)) condition = "Good";
        else condition = "Fair";

        return title + ':' + public_year.toString() + ':' + publisher + ':' + author + ':' + price + ':' + condition +
                ':' + owner.getUsername() + '\n';
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
