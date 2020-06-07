package DataUtils.Book;

import java.time.Year;

public abstract class Book {
    protected final String title;
    protected final String isbn;
    protected final Year public_year;
    protected final String publisher;
    protected final String author;

    Book(String title, String isbn, Year public_year, String publisher, String author) {
        this.title = title;
        this.isbn = isbn;
        this.public_year = public_year;
        this.publisher = publisher;
        this.author = author;
    }
}
