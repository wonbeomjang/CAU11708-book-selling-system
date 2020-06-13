package com.wonbeomjang.bookselling.Utils;

import com.wonbeomjang.bookselling.DataUtils.Book.BookSaleList;
import com.wonbeomjang.bookselling.DataUtils.User.UserList;

public class SetUp {
    public static String userDataFile = "UserTest.txt";
    public static String bookDataFile = "BookTest.txt";
    public static void setup(){

        UserList userList = UserList.getInstance();
        BookSaleList bookSaleList = BookSaleList.getInstance();

        userList.init(userDataFile);
        bookSaleList.init(bookDataFile);
    }
}
