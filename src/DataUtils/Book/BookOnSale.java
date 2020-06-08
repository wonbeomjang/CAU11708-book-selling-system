package DataUtils.Book;

import DataUtils.User.User;

public class BookOnSale extends Book {
    int price;
    BookCondition condition;

    public BookOnSale(String title, String public_year, String publisher, String author, int price,
               BookCondition condition, User owner) {
        super(title, "123", public_year, publisher, author, owner);
        this.price = price;
        this.condition = condition;
    }

    public BookOnSale(String title, String isbn, String public_year, String publisher, String author, String price,
                      BookCondition condition, User owner) {
        super(title, isbn, public_year, publisher, author, owner);
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

        return title + ": " + isbn +": " + public_year + ": " + publisher + ": " + author + ": " + price + ": " + condition.toString() +
                ": " + owner.getUsername() + '\n';
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
