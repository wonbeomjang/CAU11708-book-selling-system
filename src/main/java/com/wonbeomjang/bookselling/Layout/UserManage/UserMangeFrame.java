package com.wonbeomjang.bookselling.Layout.UserManage;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.DataUtils.User.UserRank;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class UserMangeFrame extends JFrame implements Observer {
    public UserMangeFrame(User systemUser) {
        if(systemUser.getUserRank().equals(UserRank.EndUser)) dispose();

        UserManagePanel userManagePanel = new UserManagePanel(this);
        add(userManagePanel);

        setSize(userManagePanel.getPanWidth(), userManagePanel.getPanHeight());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

        dispose();
    }
}
