package com.wonbeomjang.bookselling.ActionListener.MainMenu;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.UserManage.UserMangeFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageUserBtnActionListener implements ActionListener {
    User systemUser;
    public ManageUserBtnActionListener(User systemUser) {
        this.systemUser = systemUser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new UserMangeFrame(systemUser);
    }
}
