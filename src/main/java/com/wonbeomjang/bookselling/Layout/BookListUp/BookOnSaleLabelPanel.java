package com.wonbeomjang.bookselling.Layout.BookListUp;

import com.wonbeomjang.bookselling.DataUtils.Book.Book;

import javax.swing.*;
import java.awt.*;

public class BookOnSaleLabelPanel extends JPanel {
    JCheckBox buyChk;
    Book book;
    public BookOnSaleLabelPanel(Book book) {
        this.book = book;
        buyChk = new JCheckBox();

        setLayout(new GridLayout(1, 9));

        add(buyChk);
        add(new JLabel(book.getId()));
        add(new JLabel(book.getTitle()));
        add(new JLabel(book.getIsbn()));
        add(new JLabel(book.getPublicYear()));
        add(new JLabel(book.getPublisher()));
        add(new JLabel(book.getAuthor()));
        add(new JLabel(book.getPrice()));
        add(new JLabel(book.getCondition().toString()));
        add(new JLabel(book.getOwner()));
    }

    public JCheckBox getBuyChk() {
        return buyChk;
    }

    public boolean isChecked() {
        return buyChk.isSelected();
    }

    public Book getBook() {
        return book;
    }
}
