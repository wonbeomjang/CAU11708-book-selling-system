package com.wonbeomjang.bookselling.ActionListener.MainMenu;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.SearchBook.SearchBookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookBtnActionLister implements ActionListener {
    User systemUser;

    public SearchBookBtnActionLister(User systemUser) {
        this.systemUser = systemUser;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new SearchBookFrame(systemUser);
    }
}
