package com.wonbeomjang.bookselling.DataUtils.Book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wonbeomjang.bookselling.DataUtils.User.User;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class BookSaleList  implements Serializable {
    private ArrayList<Book> books;
    private String fileName;
    private static final BookSaleList instance = new BookSaleList();
    ObjectMapper mapper = new ObjectMapper();

    private BookSaleList() {}

    public void init(String fileName) {
        this.fileName = fileName;
        try {
            Book[] book = mapper.readValue(new File(fileName), Book[].class);
            books = new ArrayList<>(Arrays.asList(book));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Create New Book File");
            books = new ArrayList<>();
        }
    }

    public void refresh(User user) {
        books.removeIf(new Predicate<Book>() {
            public boolean test(Book book) {
                return book.getOwner().equals(user.getUsername());
            }
        });
        saveData();
        init(fileName);
    }

    public static BookSaleList getInstance() {
        return instance;
    }

    public int getNumBooks() {
        return books.size();
    }

    public boolean addBook(Book book) {
        books.add(book);
        return true;
    }

    public boolean deleteBook(Book book) {
        if (!books.contains(book)) {
            return false;
        }
        books.remove(book);
        return true;
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public Book[] getBooks() {return books.toArray(new Book[0]);}

    public boolean contain(Book book) {
        return books.contains(book);
    }

    public void saveData() {
        try {
            mapper.writeValue(new File(fileName), books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books) {
            stringBuilder.append(book.toString());
        }
        return stringBuilder.toString();
    }
}
