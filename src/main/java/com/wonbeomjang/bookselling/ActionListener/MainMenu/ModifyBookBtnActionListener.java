package com.wonbeomjang.bookselling.ActionListener.MainMenu;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.ModifyBook.ModifyBookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyBookBtnActionListener implements ActionListener {
    User systemUser;

    public ModifyBookBtnActionListener(User systemUser) {
        this.systemUser = systemUser;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new ModifyBookFrame(systemUser);
    }
}
