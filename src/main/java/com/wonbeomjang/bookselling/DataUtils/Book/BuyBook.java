package com.wonbeomjang.bookselling.DataUtils.Book;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.Interface.SearchUser;

public class BuyBook extends com.wonbeomjang.bookselling.Layout.Interface.BuyBook {
    @Override
    public boolean buyBook(User buyer, Book book) {
        if(book.getOwner().equals(buyer.getUsername()))
            return false;

        SearchUser searchUser = new com.wonbeomjang.bookselling.DataUtils.User.SearchUser();
        String[] strings = {book.getTitle(), searchUser.search(book.getOwner())[0].getEmail(), buyer.getEmail()};
        book.setOwner(buyer.getUsername());
        BookSaleList.getInstance().saveData();

        setChanged();
        notifyObservers(strings);

        return true;
    }
}
