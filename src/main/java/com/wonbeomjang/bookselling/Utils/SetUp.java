package com.wonbeomjang.bookselling.Utils;

import com.wonbeomjang.bookselling.DataUtils.Book.BookSaleList;
import com.wonbeomjang.bookselling.DataUtils.User.UserList;

import java.io.File;
import java.nio.file.Paths;

public class SetUp {
    public static String userDataFile = "user.json";
    public static String bookDataFile = "books.json";
    public static String testUserDataFile = "userTest.json";
    public static String testBookDataFile = "booksTest.json";
    public static String dataDir = "data";
    public static File folder = new File(dataDir);

    public static void setup() {

        if(!folder.exists())
            folder.mkdir();

        UserList userList = UserList.getInstance();
        BookSaleList bookSaleList = BookSaleList.getInstance();

        userList.init(Paths.get(dataDir, userDataFile).toString());
        bookSaleList.init(Paths.get(dataDir, bookDataFile).toString());
    }

    public static void setup(boolean isTest) {
        if(!isTest) setup();

        File folder = new File(dataDir);
        if(!folder.exists())
            folder.mkdir();

        UserList userList = UserList.getInstance();
        BookSaleList bookSaleList = BookSaleList.getInstance();

        userList.init(Paths.get(dataDir, testUserDataFile).toString());
        bookSaleList.init(Paths.get(dataDir, testBookDataFile).toString());
    }
}
