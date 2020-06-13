package com.wonbeomjang.bookselling.Layout.UserManage;

import com.wonbeomjang.bookselling.ActionListener.ManageUser.SaveBtnActionListener;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.Interface.SearchUser;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class UserManagePanel extends JPanel {
    SearchUser searchUser = new com.wonbeomjang.bookselling.DataUtils.User.SearchUser();
    User[] users = searchUser.search(null);
    public UserManagePanel(Observer observer) {
        JButton saveBtn = new JButton("저장");
        UserListPanel userListPanel = new UserListPanel(users);

        setLayout(new BorderLayout());

        add(userListPanel, BorderLayout.CENTER);
        add(saveBtn, BorderLayout.EAST);

        saveBtn.addActionListener(new SaveBtnActionListener(userListPanel, observer));
    }

    public int getPanWidth() {
        return 800;
    }

    public int getPanHeight() {
        return users.length * 30 + 30;
    }
}
