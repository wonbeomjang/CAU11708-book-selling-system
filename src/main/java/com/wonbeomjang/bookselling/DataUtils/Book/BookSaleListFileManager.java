package com.wonbeomjang.bookselling.DataUtils.Book;


import com.wonbeomjang.bookselling.DataUtils.User.User;

import java.io.*;
import java.util.ArrayList;

public class BookSaleListFileManager {
    private final String fileName;

    public BookSaleListFileManager(String fileName) {
        this.fileName = fileName;
    }
    public ArrayList<Book> readData() throws IOException {
        ArrayList<Book> bookList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));

        String line;
        String[] bookInfo;
        User[] owner;
        while ((line = bufferedReader.readLine()) != null){
            line = line.replaceAll(" ", "");
            bookInfo = line.split(":");

            bookList.add(new BookOnSale(bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], bookInfo[4], bookInfo[5], BookCondition.valueOf(bookInfo[6]), bookInfo[7]));
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
