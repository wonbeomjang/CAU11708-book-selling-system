package com.wonbeomjang.bookselling.ActionListener.BuyBook;

import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.BookListUp.BookOnSaleLabelPanel;
import com.wonbeomjang.bookselling.Layout.Interface.BuyBook;
import com.wonbeomjang.bookselling.Layout.Interface.SearchUser;
import com.wonbeomjang.bookselling.Layout.SearchBook.SearchBookPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;

public class BuyBtnActionListener implements ActionListener {
    SearchBookPanel searchBookPanel;
    BuyBook buyBook = new com.wonbeomjang.bookselling.DataUtils.Book.BuyBook();
    SearchUser searchUser = new com.wonbeomjang.bookselling.DataUtils.User.SearchUser();
    User systemUser;
    Observer observer;

    public BuyBtnActionListener(SearchBookPanel searchBookPanel, User systemUser, Observer observer) {
        this.searchBookPanel = searchBookPanel;
        this.systemUser = systemUser;
        this.observer = observer;
        this.buyBook.addObserver(observer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<BookOnSaleLabelPanel> bookOnSaleLabelPanels = searchBookPanel.getBookOnSaleLabelPanels();

        for(BookOnSaleLabelPanel panel: bookOnSaleLabelPanels) {
            if(panel.isChecked()) {
                Book book = panel.getBook();
                User seller = searchUser.search(book.getOwner())[0];
                buyBook.buyBook(seller, systemUser, book);
            }
        }
    }
}
