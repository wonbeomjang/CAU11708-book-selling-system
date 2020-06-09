package Layout.UserManage;

import DataUtils.User.EndUser;
import DataUtils.User.User;
import DataUtils.User.UserState;

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

        if(user instanceof EndUser) {
            EndUser endUser = (EndUser) user;

            this.email = new JLabel(endUser.getEmail());
            this.phoneNumber = new JLabel(endUser.getPhoneNumber());
            this.name = new JLabel(endUser.getName());
            this.userState.setSelectedItem(endUser.getUserState());

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
