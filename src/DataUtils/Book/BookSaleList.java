package DataUtils.Book;

import DataUtils.User.UserList;

import java.io.IOException;
import java.util.ArrayList;

public class BookSaleList {
    private ArrayList<Book> books;
    private int numBooks;
    String fileName;
    BookSaleListFileManager bookSaleListFileManager;
    public BookSaleList(String fileName, UserList userList) {
        numBooks = 0;
        bookSaleListFileManager = new BookSaleListFileManager(fileName, userList);
        try {
            books = bookSaleListFileManager.readData();
        }
        catch (IOException e) {
            books = new ArrayList<>();
        }
        numBooks = books.size();
    }

    public int getNumBooks() {
        return numBooks;
    }

    public boolean addBook(Book book) {
        books.add(book);
        numBooks++;
        return true;
    }

    public boolean deleteBook(Book book) {
        if (!books.contains(book)) {
            return false;
        }
        books.remove(book);
        numBooks--;
        return true;
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public boolean contain(Book book) {
        return books.contains(book);
    }

    public void saveData() {
        bookSaleListFileManager.saveData(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < numBooks; i++) {
            stringBuilder.append(books.get(i).toString());
        }
        return stringBuilder.toString();
    }
}
