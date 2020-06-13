package com.wonbeomjang.bookselling.Layout.SearchBook;

import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.User.User;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SearchBookFrame extends JFrame implements Observer {
    SearchBookPanelWoChkBox searchBookPanelWoChkBox;
    public SearchBookFrame(User systemUser) {
        searchBookPanelWoChkBox = new SearchBookPanelWoChkBox(systemUser, this);

        setLayout(new BorderLayout());
        add(searchBookPanelWoChkBox);
        setSize(searchBookPanelWoChkBox.getPanWidth(), searchBookPanelWoChkBox.getPanHeight());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        Book[] books = (Book[])arg;
        setSize(searchBookPanelWoChkBox.getPanWidth(), searchBookPanelWoChkBox.getPanHeight(books.length));
    }
}
