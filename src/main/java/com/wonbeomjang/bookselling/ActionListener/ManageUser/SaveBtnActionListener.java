package com.wonbeomjang.bookselling.ActionListener.ManageUser;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.DataUtils.User.UserState;
import com.wonbeomjang.bookselling.Layout.Interface.ManageUser;
import com.wonbeomjang.bookselling.Layout.UserManage.UserInfoPanel;
import com.wonbeomjang.bookselling.Layout.UserManage.UserListPanel;

import javax.swing.*;
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
        User user;

        for(UserInfoPanel userInfoPanel: userInfoPanels) {
            user = userInfoPanel.getUser();
            if(userInfoPanel.getUserState().equals(UserState.Deleted)) {
                if (user.getUserState().equals(UserState.Activate)) {
                    int ans = JOptionPane.showConfirmDialog(null, String.format("'%s'는 Activation된 사용자입니다. 그래도 지우겠습니까?", user.getUsername()),
                            "Delete USer", JOptionPane.YES_NO_OPTION);
                    if (ans == JOptionPane.NO_OPTION)
                        continue;
                }
                manageUser.delete(user);
            }
            else
                manageUser.change(user, userInfoPanel.getUserState());
        }
    }
}
