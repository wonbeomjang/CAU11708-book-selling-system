package com.wonbeomjang.bookselling.ActionListener.ManageUser;

import com.wonbeomjang.bookselling.DataUtils.User.UserState;
import com.wonbeomjang.bookselling.Layout.Interface.ManageUser;
import com.wonbeomjang.bookselling.Layout.UserManage.UserInfoPanel;
import com.wonbeomjang.bookselling.Layout.UserManage.UserListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;

public class SaveBtnActionListener implements ActionListener {
    ArrayList<UserInfoPanel> userInfoPanels;
    UserListPanel userListPanel;
    ManageUser manageUser = new com.wonbeomjang.bookselling.DataUtils.User.ManageUser();

    public SaveBtnActionListener(UserListPanel userListPanel, Observer observer) {
        this.userListPanel = userListPanel;
        this.manageUser.addObserver(observer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userInfoPanels = userListPanel.getUserInfoPanels();

        for(UserInfoPanel userInfoPanel: userInfoPanels) {
            if(userInfoPanel.getUserState().equals(UserState.Deleted))
                manageUser.delete(userInfoPanel.getUser());
            else
                manageUser.change(userInfoPanel.getUser(), userInfoPanel.getUserState());
        }
    }
}
