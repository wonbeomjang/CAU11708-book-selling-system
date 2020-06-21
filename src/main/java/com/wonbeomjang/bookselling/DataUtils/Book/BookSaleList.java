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
    static ArrayList<Book> books;
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
            System.out.println("Create New Book File");
            books = new ArrayList<>();
        }
        if (books.size() == 0) return;
        SortByID.sort(books);
    }

    public void refresh(User user) {
        books.removeIf(book -> book.getOwner().equals(user.getUsername()));
        saveData();
    }

    public static BookSaleList getInstance() {
        return instance;
    }

    public int getNumBooks() {
        return books.size();
    }

    public boolean addBook(Book book) {
        books.add(book);
        saveData();
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
        Thread thread = new Thread(() -> {
            try {
                mapper.writeValue(new File(fileName), books);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread.start();

    }

    public String getNextID() {
        if(books.size() == 0)
            return "0";
        return String.valueOf(Integer.parseInt(books.get(books.size() - 1).getId()) + 1);
    }

    public boolean addBook(String title, String publicYear, String publisher, String author, String price, BookCondition condition, User owner) {
        Book book = new Book(title, publicYear, publisher, author, price, condition, owner.getUsername());
        addBook(book);
        saveData();
        return true;
    }

    public boolean addBook(String title, String isbn, String publicYear, String publisher, String author, String price, BookCondition condition, User owner) {
        Book book = new Book(title, isbn, publicYear, publisher, author, price, condition, owner.getUsername());
        addBook(book);
        saveData();
        return true;
    }

}
