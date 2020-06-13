package com.wonbeomjang.bookselling.Layout.UserManage;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.DataUtils.User.UserRank;
import com.wonbeomjang.bookselling.DataUtils.User.UserState;

import javax.swing.*;
import java.awt.*;

public class UserInfoPanel extends JPanel {
    JLabel username;
    JLabel email;
    JLabel phoneNumber;
    JLabel name;
    JComboBox<UserState> userState = new JComboBox<>(UserState.values());
    User user;

    public UserInfoPanel(User user) {
        this.user = user;

        setLayout(new GridLayout(1,5));

        this.username = new JLabel(user.getUsername());
        add(this.username, 0);

        if(user.getUserRank().equals(UserRank.EndUser)) {

            this.email = new JLabel(user.getEmail());
            this.phoneNumber = new JLabel(user.getPhoneNumber());
            this.name = new JLabel(user.getName());
            this.userState.setSelectedItem(user.getUserState());

            add(this.email);
            add(this.phoneNumber);
            add(this.name);
            add(this.userState);
        }

    }

    public User getUser() {
        return user;
    }

    public String getUsername() {
        return username.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPhoneNumber() {
        return phoneNumber.getText();
    }

    public String getName() {
        return name.getText();
    }

    public UserState getUserState() {
        return (UserState) userState.getSelectedItem();
    }
}
