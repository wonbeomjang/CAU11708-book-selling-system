package com.wonbeomjang.bookselling.ActionListener.MainMenu;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.BuyBook.BuyBookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyBookBtnActionLister implements ActionListener {
    User systemUser;

    public BuyBookBtnActionLister(User systemUser) {
        this.systemUser = systemUser;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new BuyBookFrame(systemUser);
    }
}
