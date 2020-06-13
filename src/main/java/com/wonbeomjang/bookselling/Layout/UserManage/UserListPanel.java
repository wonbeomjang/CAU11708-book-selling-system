package com.wonbeomjang.bookselling.Layout.UserManage;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.DataUtils.User.UserRank;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserListPanel extends JPanel {
    ArrayList<UserInfoPanel> userInfoPanels = new ArrayList<>();
    public UserListPanel(User[] users) {
        UserInfoPanel userInfoPanel;
        ArrayList<User> endUsers = new ArrayList<>();

        for(User user: users)
            if (user.getUserRank().equals(UserRank.EndUser))
                endUsers.add(user);

        setLayout(new GridLayout(1 + endUsers.size(), 1));

        add(new UserListInfoLabelPanel());
        for(User user : endUsers) {

            userInfoPanel = new UserInfoPanel(user);

            add(userInfoPanel);
            userInfoPanels.add(userInfoPanel);
        }
    }

    public ArrayList<UserInfoPanel> getUserInfoPanels() {
        return userInfoPanels;
    }
}
