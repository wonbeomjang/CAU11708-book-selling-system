package ActionListener.ManageUser;

import DataUtils.User.ManageUser;
import DataUtils.User.UserState;
import Layout.Interface.ChangeUserState;
import Layout.Interface.DeleteUser;
import Layout.UserManage.UserInfoPanel;
import Layout.UserManage.UserListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;

public class SaveBtnActionListener implements ActionListener {
    ArrayList<UserInfoPanel> userInfoPanels;
    UserListPanel userListPanel;
    DeleteUser deleteUser = new ManageUser();
    ChangeUserState changeUserState = new ManageUser();

    public SaveBtnActionListener(UserListPanel userListPanel, Observer observer) {
        this.userListPanel = userListPanel;
        this.changeUserState.addObserver(observer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userInfoPanels = userListPanel.getUserInfoPanels();

        for(UserInfoPanel userInfoPanel: userInfoPanels) {
            if(userInfoPanel.getUserState().equals(UserState.Deleted))
                deleteUser.delete(userInfoPanel.getUser());
            else
                changeUserState.change(userInfoPanel.getUser(), userInfoPanel.getUserState());
        }
    }
}
