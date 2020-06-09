package DataUtils.Book;

import java.util.ArrayList;

public class SearchBook extends Layout.Interface.SearchBook {
    BookSaleList bookSaleList;
    String key;
    BookKeyType keyType;

    public SearchBook() {
        this.bookSaleList = BookSaleList.getInstance();
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
        Book[] bookArray;
        ArrayList<Book> books = new ArrayList<>();

        if(key == null) return bookSaleList.getBooks();


        for(int i = 0; i < bookSaleList.getNumBooks(); i++) {
            if(compareByKey(bookSaleList.getBook(i), key, keyType)) {
                books.add(bookSaleList.getBook(i));
            }
        }

        bookArray = books.toArray(Book[]::new);

        setChanged();
        notifyObservers(bookArray);

        return bookArray;
    }
}
