package DataUtils.Book;

import java.util.ArrayList;

public class SearchBook implements Layout.Interface.SearchBook {
    BookSaleList bookSaleList;
    String key;
    BookKeyType keyType;
    ArrayList<Book> books;

    public SearchBook(BookSaleList bookSaleList) {
        this.bookSaleList = bookSaleList;
        this.books = new ArrayList<>();
    }

    public boolean compareByKey(Book book, String key, BookKeyType keyType) {
        if (keyType == BookKeyType.Title) return book.title.equals(key);
        if (keyType == BookKeyType.ISBN) return book.isbn.equals(key);
        if (keyType == BookKeyType.Author) return book.author.equals(key);
        if (keyType == BookKeyType.Username) return book.owner.getUsername().equals(key);
        return false;
    }

    @Override
    public Book[] search(String key, BookKeyType keyType) {
        this.key = key;
        this.keyType = keyType;

        books.clear();
        int numBooks = bookSaleList.getNumBooks();
        Book book;
        for(int i = 0; i < numBooks; i++) {
            book = bookSaleList.getBook(i);
            if(compareByKey(book, key, keyType)) {
                books.add(book);
            }
        }

        return books.toArray(new Book[0]);
    }

    @Override
    public String[] getInfo() {
        String[] outputs = new String[books.size()];
        for(int i = 0; i < books.size(); i++) {
            outputs[i] = books.get(i).toString();
        }
        return outputs;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setKeyType(BookKeyType keyType) {
        this.keyType = keyType;
    }

    public int getNumBooks() {
        return bookSaleList.getNumBooks();
    }

}
