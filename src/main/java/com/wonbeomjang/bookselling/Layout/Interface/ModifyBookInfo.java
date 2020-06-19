package com.wonbeomjang.bookselling.Layout.Interface;

import com.wonbeomjang.bookselling.DataUtils.Book.BookCondition;
import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.User.User;

public interface ModifyBookInfo {
    boolean modifyPrice(User owner, Book book, String price);
    boolean modifyCondition(User owner, Book book, BookCondition condition);
}
