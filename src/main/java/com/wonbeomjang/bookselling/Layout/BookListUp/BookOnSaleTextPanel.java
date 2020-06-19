package com.wonbeomjang.bookselling.Layout.BookListUp;

import com.wonbeomjang.bookselling.DataUtils.Book.BookCondition;
import com.wonbeomjang.bookselling.DataUtils.Book.Book;

import javax.swing.*;
import java.awt.*;

public class BookOnSaleTextPanel extends JPanel {
    Book book;
    JTextField title;
    JTextField isbn;
    JTextField publicYear;
    JTextField publisher;
    JTextField author;
    JTextField price;
    JComboBox<BookCondition> condition;

    public BookOnSaleTextPanel(Book book) {
        this.book = book;

        setLayout(new GridLayout(1, 7));

        title = new JTextField(book.getTitle());
        isbn = new JTextField(book.getIsbn());
        publicYear = new JTextField(book.getPublicYear());
        publisher = new JTextField(book.getPublisher());
        author = new JTextField(book.getAuthor());
        price = new JTextField(book.getPrice());
        condition = new JComboBox<>(BookCondition.values());
        condition.setSelectedItem(book.getCondition());

        add(title);
        add(isbn);
        add(publicYear);
        add(publisher);
        add(author);
        add(price);
        add(condition);
        add(new JLabel(book.getOwner()));
    }

    public Book getBook() {
        return book;
    }

    public String getTitle() {
        return title.getText();
    }

    public String getIsbn() {
        return isbn.getText();
    }

    public String getPublicYear() {
        return publicYear.getText();
    }

    public String getPublisher() {
        return publisher.getText();
    }

    public String getAuthor() {
        return author.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getCondition() {
        return condition.getSelectedItem().toString();
    }

    public Book getNewBook() {
        return new Book(getTitle(), getIsbn(), getPublicYear(), getPublisher(), getAuthor(),
                getPrice(), BookCondition.valueOf(getCondition()), "");
    }
}
