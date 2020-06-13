package com.wonbeomjang.bookselling.ActionListener.MainMenu;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.DeleteBook.DeleteBookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBookBtnActionListener implements ActionListener {
    User systemUser;

    public DeleteBookBtnActionListener(User systemUser) {
        this.systemUser = systemUser;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new DeleteBookFrame(systemUser);
    }
}
