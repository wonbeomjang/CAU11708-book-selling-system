package DataUtils.Book;

import DataUtils.User.User;

public class ModifyBookInfo implements Layout.Interface.ModifyBookInfo {
    User owner;
    BookOnSale book;
    int price;
    BookCondition condition;

    @Override
    public boolean modifyPrice(User owner, BookOnSale book, int price) {
        if (!book.getOwner().equals(owner)) {
            return false;
        }
        book.setPrice(price);
        return true;
    }

    @Override
    public boolean modifyCondition(User owner, BookOnSale book, BookCondition condition) {
        if (!book.getOwner().equals(owner)) {
            return false;
        }
        book.setCondition(condition);
        return false;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setBook(BookOnSale book) {
        this.book = book;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCondition(BookCondition condition) {
        this.condition = condition;
    }
}
