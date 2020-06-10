package DataUtils.Book;

import DataUtils.User.User;

import java.io.IOException;
import java.util.ArrayList;

public class BookSaleList {
    private ArrayList<Book> books;
    private BookSaleListFileManager bookSaleListFileManager;
    private String fileName;
    private static final BookSaleList instance = new BookSaleList();

    private BookSaleList() {}

    public void init(String fileName) {
        this.fileName = fileName;
        bookSaleListFileManager = new BookSaleListFileManager(fileName);
        try {
            books = bookSaleListFileManager.readData();
        }
        catch (IOException e) {
            books = new ArrayList<>();
        }
    }

    public void refresh(User user) {
        books.removeIf(book -> book.getOwner().equals(user.getUsername()));
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
        for (Book book : books) {
            stringBuilder.append(book.toString());
        }
        return stringBuilder.toString();
    }
}
