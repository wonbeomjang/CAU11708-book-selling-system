package com.wonbeomjang.bookselling.DataUtils.Book;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.DataUtils.User.UserRank;

public class DeleteBook extends com.wonbeomjang.bookselling.Layout.Interface.DeleteBook {
    private final BookSaleList bookSaleList;

    public DeleteBook() {
        this.bookSaleList = BookSaleList.getInstance();
    }

    @Override
    public boolean deleteBook(User owner, Book book) {
        if (book.getOwner().equals(owner.getUsername()) || owner.getUserRank().equals(UserRank.Admin)) {
            bookSaleList.deleteBook(book);
            setChanged();
            notifyObservers(book);
            bookSaleList.saveData();
            return true;
        }
        return false;
    }
}
