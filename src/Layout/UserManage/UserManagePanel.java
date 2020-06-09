package Layout.UserManage;

import ActionListener.ManageUser.SaveBtnActionListener;
import DataUtils.User.User;
import Layout.Interface.SearchUser;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class UserManagePanel extends JPanel {
    SearchUser searchUser = new DataUtils.User.SearchUser();
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
