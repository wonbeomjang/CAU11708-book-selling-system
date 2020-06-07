package DataUtils.Book;

import java.util.ArrayList;

public class BookSaleList {
    private ArrayList<Book> books = new ArrayList<>();
    private int numBooks = 0;

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
}
