package com.wonbeomjang.bookselling.Utils;

import com.wonbeomjang.bookselling.DataUtils.Book.BookSaleList;
import com.wonbeomjang.bookselling.DataUtils.User.UserList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

        File file = new File(Paths.get(dataDir, userDataFile).toString());

        if(!file.exists()) {
            try {
                OutputStream output = new FileOutputStream(Paths.get(dataDir, userDataFile).toString());
                String str ="[{\"username\":\"admin\",\"password\":\"a874ab55fce4a638755ef3482a280295bf63fe9f7c8a49d9d2fbacb8c4092beb\",\"email\":\"\",\"name\":\"\",\"phoneNumber\":\"\",\"userState\":\"Activate\",\"userRank\":\"Admin\"}]";
                output.write(str.getBytes());
            } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }

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
