package Layout.UserManage;

import ActionListener.ManageUser.SaveBtnActionListener;
import DataUtils.User.User;
import DataUtils.User.UserList;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class UserManagePanel extends JPanel {
    User[] users = UserList.getInstance().getUsers();
    public UserManagePanel(Observer observer) {
        JButton saveBtn = new JButton("저장");
        UserListPanel userListPanel = new UserListPanel(users);

        setLayout(new BorderLayout());

        add(userListPanel, BorderLayout.CENTER);
        add(saveBtn, BorderLayout.EAST);

        saveBtn.addActionListener(new SaveBtnActionListener(userListPanel, observer));
    }

    public static int getPanWidth() {
        return 800;
    }

    public static int getPanHeight() {
        return UserList.getInstance().getNumUsers() * 30 + 30;
    }
}
