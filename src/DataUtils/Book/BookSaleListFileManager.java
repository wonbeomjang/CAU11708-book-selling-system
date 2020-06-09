package DataUtils.Book;


import DataUtils.User.SearchUser;
import DataUtils.User.User;
import DataUtils.User.UserList;

import java.io.*;
import java.util.ArrayList;

public class BookSaleListFileManager {
    String fileName;
    UserList userList;
    public BookSaleListFileManager(String fileName, UserList userList) {
        this.fileName = fileName;
        this.userList = userList;
    }
    public ArrayList<Book> readData() throws IOException {
        ArrayList<Book> bookList = new ArrayList<>();
        SearchUser searchUser = new SearchUser();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));

        String line;
        String[] bookInfo;
        User[] owner;
        BookCondition bookCondition;
        while ((line = bufferedReader.readLine()) != null){
            line = line.replaceAll(" ", "");
            bookInfo = line.split(":");
            owner = searchUser.search(bookInfo[7]);
            if (owner.length == 0)
                continue;

            bookList.add(new BookOnSale(bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], bookInfo[4], bookInfo[5], BookCondition.valueOf(bookInfo[6]), owner[0]));
        }
        return bookList;
    }
    public void saveData(BookSaleList bookList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
            bufferedWriter.write(bookList.toString());
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("Unknown FIle");
        }
    }
}
