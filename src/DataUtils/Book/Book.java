package DataUtils.Book;

public abstract class Book {
    protected String title;
    protected String isbn;
    protected String public_year;
    protected String publisher;
    protected String author;
    protected String owner;

    Book(String title, String isbn, String public_year, String publisher, String author, String owner) {
        if(!public_year.equals("")) Integer.parseInt(public_year);
        this.title = title;
        this.isbn = isbn;
        this.public_year = public_year;
        this.publisher = publisher;
        this.author = author;
        this.owner = owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublic_year(String public_year) {
        this.public_year = public_year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublic_year() {
        return public_year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }



    @Override
    public String toString() {
        return title + ": " + isbn + ": " + public_year + ": " + publisher + ": " + author + ": " + " " + ": " + " " + ": " +
                owner + '\n';
    }
}
