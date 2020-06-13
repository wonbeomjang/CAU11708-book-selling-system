package com.wonbeomjang.bookselling.Layout.Interface;

import com.wonbeomjang.bookselling.DataUtils.Book.BookCondition;
import com.wonbeomjang.bookselling.DataUtils.Book.BookOnSale;
import com.wonbeomjang.bookselling.DataUtils.User.User;

public interface ModifyBookInfo {
    boolean modifyPrice(User owner, BookOnSale book, String price);
    boolean modifyCondition(User owner, BookOnSale book, BookCondition condition);
}
