package com.wonbeomjang.bookselling.DataUtils.Book;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.DataUtils.User.UserState;
import com.wonbeomjang.bookselling.Layout.Interface.SearchBook;
import com.wonbeomjang.bookselling.Layout.Interface.SearchUser;

public class BuyBook extends com.wonbeomjang.bookselling.Layout.Interface.BuyBook {
    @Override
    public boolean buyBook(User seller, User buyer, Book book) {
        if(book.getOwner().equals(buyer.getUsername()))
            return false;

        if (seller.getUserState().equals(UserState.Deactivate))
            return false;

        book.setOwner(buyer.getUsername());

        BookSaleList.getInstance().saveData();

        String[] strings = {book.getTitle(), seller.getEmail(), buyer.getEmail()};
        setChanged();
        notifyObservers(strings);

        return true;
    }
}
