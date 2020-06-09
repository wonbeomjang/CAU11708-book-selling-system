package DataUtils.Book;

import DataUtils.User.UserList;

import java.io.IOException;
import java.util.ArrayList;

public class BookSaleList {
    private ArrayList<Book> books;
    private int numBooks;
    BookSaleListFileManager bookSaleListFileManager;
    private static final BookSaleList instance = new BookSaleList();
    String fileName;
    private BookSaleList() {}

    public void init(String fileName, UserList userList) {
        this.fileName = fileName;
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

    public void refresh(UserList userList) {
        init(fileName, userList);
        saveData();
    }

    public static BookSaleList getInstance() {
        return instance;
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

    public Book[] getBooks() {return books.toArray(Book[]::new);}

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
