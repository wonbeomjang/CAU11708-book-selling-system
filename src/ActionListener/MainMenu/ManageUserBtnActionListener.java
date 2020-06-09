package ActionListener.MainMenu;

import DataUtils.User.User;
import Layout.UserManage.UserMangeFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageUserBtnActionListener implements ActionListener {
    User systemUser;
    public ManageUserBtnActionListener(User systemUser) {
        this.systemUser = systemUser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new UserMangeFrame(systemUser);
    }
}
