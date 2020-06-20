package com.wonbeomjang.bookselling.DataUtils.Book;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wonbeomjang.bookselling.Utils.HashFunction;

import java.io.Serializable;

public class Book implements Serializable {
    private String id = "0";
    private String owner;
    private String price;
    private BookCondition condition;
    private final BookInfo bookInfo;

    public Book(String title, String public_year, String publisher, String author, String price, BookCondition condition, String owner) {
        if(!price.equals("")) Integer.parseInt(price);
        bookInfo = new BookInfo(title, HashFunction.hash(title + public_year + publisher), public_year, publisher, author);
        this.price = price;
        this.condition = condition;
        this.owner = owner;
    }

    @JsonCreator
    public Book(@JsonProperty("title") String title, @JsonProperty("isbn") String isbn, @JsonProperty("public_year") String public_year,
                @JsonProperty("publisher") String publisher, @JsonProperty("author") String author,
                @JsonProperty("price") String price, @JsonProperty("condition") BookCondition condition,
                @JsonProperty("owner") String owner, @JsonProperty("ID") String id) {
        if(!price.equals("")) Integer.parseInt(price);
        this.bookInfo = new BookInfo(title, isbn, public_year, publisher, author);
        this.price = price;
        this.condition = condition;
        this.owner = owner;
        this.id = id;
    }

    public Book(String title, String isbn, String publicYear, String publisher, String author, String price, BookCondition condition, String owner) {
        this(title, isbn, publicYear, publisher, author, price, condition, owner, BookSaleList.getInstance().getNextID());
    }

    @Override
    public String toString() {

        return getTitle() + ": " + getIsbn() +": " + getPublicYear() + ": " + getPublicYear() + ": " + getAuthor()
                + ": " + price + ": " + condition.toString() + ": " + owner + ": "  + id + '\n';
    }

    public String getTitle() {
        return bookInfo.getTitle();
    }

    public void setTitle(String title) {
        this.bookInfo.setTitle(title);
    }

    public String getIsbn() {
        return bookInfo.getIsbn();
    }

    public void setIsbn(String isbn) {
        this.bookInfo.setIsbn(isbn);
    }

    public String getPublicYear() {
        return bookInfo.getPublicYear();
    }

    public void setPublicYear(String publicYear) {
        this.bookInfo.setPublicYear(publicYear);
    }

    public String getPublisher() {
        return bookInfo.getPublisher();
    }

    public void setPublisher(String publisher) {
        bookInfo.setPublisher(publisher);
    }

    public String getAuthor() {
        return bookInfo.getAuthor();
    }

    public void setAuthor(String author) {
        bookInfo.setAuthor(author);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public BookCondition getCondition() {
        return condition;
    }

    public void setCondition(BookCondition condition) {
        this.condition = condition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
