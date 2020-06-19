package com.wonbeomjang.bookselling.Layout.SearchBook;

import com.wonbeomjang.bookselling.ActionListener.SearchBook.SearchBtnActionListener;
import com.wonbeomjang.bookselling.DataUtils.Book.BookKeyType;
import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.BookListUp.BookOnSaleAttribFrtBlkPanel;
import com.wonbeomjang.bookselling.Layout.BookListUp.BookOnSaleLabelPanel;
import com.wonbeomjang.bookselling.Layout.Interface.SearchBook;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SearchBookPanel extends JPanel implements Observer {
    SearchKeyWordPanel searchKeyWordPanel;
    BookOnSaleAttribFrtBlkPanel bookOnSaleAttribFrtBlkPanel;
    SearchBook searchBook = new com.wonbeomjang.bookselling.DataUtils.Book.SearchBook();
    ArrayList<BookOnSaleLabelPanel> bookOnSaleLabelPanels = new ArrayList<>();
    Observer observer;
    User systemUser;
    int panWidth = 800;
    int panHeight = 80;

    protected void organizePanel(User systemUser, Book[] books) {
        searchKeyWordPanel = new SearchKeyWordPanel();
        bookOnSaleAttribFrtBlkPanel = new BookOnSaleAttribFrtBlkPanel();

        setLayout(new GridLayout(books.length + 2, 1));


        panHeight = getPanHeight(books.length);

        add(searchKeyWordPanel);
        add(bookOnSaleAttribFrtBlkPanel);

        BookOnSaleLabelPanel bookOnSaleLabelPanel;

        for(Book book : books) {
            bookOnSaleLabelPanel = new BookOnSaleLabelPanel(book);
            if(systemUser.getUsername().equals(book.getOwner())) {
                bookOnSaleLabelPanel.remove(0);
                bookOnSaleLabelPanel.add(new JLabel(" "), 0);
            }
            bookOnSaleLabelPanels.add(bookOnSaleLabelPanel);
            add(bookOnSaleLabelPanel);
        }

        Observer[] observers = { this, this.observer };
        searchKeyWordPanel.getSearchBtn().addActionListener(new SearchBtnActionListener(searchKeyWordPanel, observers));
    }

    protected void organizePanel() {
        organizePanel(systemUser, searchBook.search(null, BookKeyType.Title));
    }

    @Override
    public void update(Observable o, Object arg) {
        Book[] books = (Book[])arg;
        panHeight = getPanHeight(books.length);

        Component component = getComponent(0);
        removeAll();
        organizePanel(systemUser, books);
        remove(0);
        add(component, 0);
        revalidate();
        repaint();
    }

    public SearchBookPanel(User systemUser, Observer observer) {
        this.systemUser = systemUser;
        this.observer = observer;
        organizePanel();
    }

    public int getPanWidth() {
        return panWidth;
    }

    public int getPanHeight() {
        return panHeight;
    }

    public int getPanHeight(int numBooks) {
        return 30 * numBooks + 100;
    }

    public ArrayList<BookOnSaleLabelPanel> getBookOnSaleLabelPanels() {
        return bookOnSaleLabelPanels;
    }
}
