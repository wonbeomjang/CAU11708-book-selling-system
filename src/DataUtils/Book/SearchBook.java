package DataUtils.Book;

import java.util.ArrayList;

public class SearchBook implements Layout.Interface.SearchBook {
    BookSaleList bookSaleList;
    String key;
    BookKeyType keyType;

    public SearchBook(BookSaleList bookSaleList) {
        this.bookSaleList = bookSaleList;
    }

    public boolean compareByKey(Book book, String key, BookKeyType keyType) {
        if (keyType == BookKeyType.Title) return book.title.equals(key);
        if (keyType == BookKeyType.ISBN) return book.isbn.equals(key);
        if (keyType == BookKeyType.Author) return book.author.equals(key);
        if (!(book instanceof BookOnSale)) return false;
        if (keyType == BookKeyType.Username) return ((BookOnSale)book).owner.getUsername().equals(key);
        return false;
    }

    @Override
    public Book[] search(String key, BookKeyType keyType) {
        this.key = key;
        this.keyType = keyType;

        ArrayList<Book> books = new ArrayList<>();
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
        BookOnSale[] books = (BookOnSale[])search(key, keyType);
        String[] outputs = new String[books.length];
        for(int i = 0; i < books.length; i++) {
            outputs[i] = books[i].toString();
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
