package com.wonbeomjang.bookselling.DataUtils.Book;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.Interface.SearchUser;

public class BuyBook extends com.wonbeomjang.bookselling.Layout.Interface.BuyBook {
    @Override
    public boolean buyBook(User buyer, Book book) {
        if(book.owner.equals(buyer.getUsername()))
            return false;

        SearchUser searchUser = new com.wonbeomjang.bookselling.DataUtils.User.SearchUser();
        String[] strings = {book.getTitle(), ((User)searchUser.search(book.getOwner())[0]).getEmail(),
                ((User)buyer).getEmail()};
        book.owner = buyer.getUsername();
        BookSaleList.getInstance().saveData();

        setChanged();
        notifyObservers(strings);

        return true;
    }
}
