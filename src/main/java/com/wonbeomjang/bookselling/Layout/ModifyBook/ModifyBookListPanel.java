package com.wonbeomjang.bookselling.Layout.ModifyBook;

import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.Book.BookKeyType;
import com.wonbeomjang.bookselling.DataUtils.Book.BookOnSale;
import com.wonbeomjang.bookselling.DataUtils.Book.SearchBook;
import com.wonbeomjang.bookselling.DataUtils.User.EndUser;
import com.wonbeomjang.bookselling.Layout.BookListUp.BookOnSaleAttribPanel;
import com.wonbeomjang.bookselling.Layout.BookListUp.BookOnSaleTextPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModifyBookListPanel extends JPanel {
    SearchBook searchBook = new SearchBook();
    ArrayList<BookOnSaleTextPanel> bookOnSaleTextPanels = new ArrayList<>();
    BookOnSaleTextPanel bookOnSaleTextPanel;
    Book[] books;
    EndUser systemUser;

    public ModifyBookListPanel(EndUser systemUser) {
        this.systemUser = systemUser;
        books = searchBook.search(systemUser.getUsername(), BookKeyType.Username);
        setLayout(new GridLayout(books.length + 1, 1));

        add(new BookOnSaleAttribPanel());

        for(Book book: books) {
            if(book instanceof BookOnSale) {
                bookOnSaleTextPanel = new BookOnSaleTextPanel((BookOnSale)book);

                bookOnSaleTextPanels.add(bookOnSaleTextPanel);
                add(bookOnSaleTextPanel);
            }
        }
    }

    public ArrayList<BookOnSaleTextPanel> getBookOnSaleTextPanels() {
        return bookOnSaleTextPanels;
    }

    public int getLength() {
        return bookOnSaleTextPanels.size();
    }
}
