package DataUtils.Book;

import DataUtils.User.User;
import Layout.Interface.BuyBook;

public class Sale implements BuyBook {
    private User seller;
    private User buyer;
    private Book book;

    public boolean buyBook() {
        return buyBook(seller, buyer, book);
    }

    @Override
    public boolean buyBook(User seller, User buyer, Book book) {
        this.seller = seller;
        this.buyer = buyer;
        this.book = book;

        book.owner = buyer;

        return true;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setBook(Book book) {
        this.book = book;
    }


}
