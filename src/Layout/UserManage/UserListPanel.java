package Layout.UserManage;

import DataUtils.User.EndUser;
import DataUtils.User.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserListPanel extends JPanel {
    ArrayList<UserInfoPanel> userInfoPanels = new ArrayList<>();
    public UserListPanel(User[] users) {
        UserInfoPanel userInfoPanel;
        ArrayList<EndUser> endUsers = new ArrayList<>();

        for(User user: users)
            if (user instanceof EndUser)
                endUsers.add((EndUser) user);

        setLayout(new GridLayout(1 + endUsers.size(), 1));

        add(new UserListInfoLabelPanel());
        for(EndUser endUser: endUsers) {

            userInfoPanel = new UserInfoPanel(endUser);

            add(userInfoPanel);
            userInfoPanels.add(userInfoPanel);
        }
    }

    public ArrayList<UserInfoPanel> getUserInfoPanels() {
        return userInfoPanels;
    }
}
