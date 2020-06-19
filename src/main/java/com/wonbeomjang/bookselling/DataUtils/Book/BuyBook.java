package com.wonbeomjang.bookselling.DataUtils.Book;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.Interface.SearchBook;
import com.wonbeomjang.bookselling.Layout.Interface.SearchUser;

public class BuyBook extends com.wonbeomjang.bookselling.Layout.Interface.BuyBook {
    @Override
    public boolean buyBook(User buyer, Book book) {
        if(book.getOwner().equals(buyer.getUsername()))
            return false;

        SearchBook searchBook = new com.wonbeomjang.bookselling.DataUtils.Book.SearchBook();
        SearchUser searchUser = new com.wonbeomjang.bookselling.DataUtils.User.SearchUser();

        Book modifyingBook = searchBook.search(book.getId(), BookKeyType.ID)[0];
        modifyingBook.setOwner(buyer.getUsername());

        BookSaleList.getInstance().saveData();

        String[] strings = {book.getTitle(), searchUser.search(book.getOwner())[0].getEmail(), buyer.getEmail()};
        setChanged();
        notifyObservers(strings);

        return true;
    }
}
