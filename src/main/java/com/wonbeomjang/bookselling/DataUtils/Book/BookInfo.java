package com.wonbeomjang.bookselling.DataUtils.Book;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookInfo {
    private String title;
    private String isbn;
    private String publicYear;
    private String publisher;
    private String author;

    public BookInfo(@JsonProperty("title") String title, @JsonProperty("isbn") String isbn,
                    @JsonProperty("public_year") String publicYear, @JsonProperty("publisher") String publisher,
                    @JsonProperty("author") String author) {
        this.title = title;
        this.isbn = isbn;
        this.publicYear = publicYear;
        this.publisher = publisher;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(String publicYear) {
        this.publicYear = publicYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
