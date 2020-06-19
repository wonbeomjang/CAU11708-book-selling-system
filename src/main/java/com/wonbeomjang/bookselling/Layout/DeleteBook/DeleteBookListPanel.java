package com.wonbeomjang.bookselling.Layout.DeleteBook;

import com.wonbeomjang.bookselling.DataUtils.Book.*;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.DataUtils.User.UserRank;
import com.wonbeomjang.bookselling.Layout.BookListUp.BookOnSaleAttribFrtBlkPanel;
import com.wonbeomjang.bookselling.Layout.BookListUp.BookOnSaleLabelPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeleteBookListPanel extends JPanel {
    SearchBook searchBook = new SearchBook();
    ArrayList<BookOnSaleLabelPanel> bookOnSaleLabelPanels = new ArrayList<>();
    BookOnSaleLabelPanel bookOnSaleLabelPanel;
    Book[] books;
    public DeleteBookListPanel(User user) {
        if (user.getUserRank().equals(UserRank.EndUser)) {
            books = searchBook.search(user.getUsername(), BookKeyType.Username);
        }
        else {
            books = searchBook.search(null, BookKeyType.Username);
        }
        setLayout(new GridLayout(books.length + 1, 1));

        add(new BookOnSaleAttribFrtBlkPanel());

        for(Book book : books) {
            if(book instanceof Book) {
                bookOnSaleLabelPanel = new BookOnSaleLabelPanel((Book) book);

                bookOnSaleLabelPanels.add(bookOnSaleLabelPanel);
                add(bookOnSaleLabelPanel);
            }
        }
    }

    public ArrayList<BookOnSaleLabelPanel> getBookOnSaleLabelPanels() {
        return bookOnSaleLabelPanels;
    }

    public Book[] getbookOnSales() {
        return books;
    }

    public int getLength() {
        return bookOnSaleLabelPanels.size();
    }
}
