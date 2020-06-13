package ActionListener.ManageUser;

import DataUtils.User.UserState;
import Layout.Interface.ManageUser;
import Layout.UserManage.UserInfoPanel;
import Layout.UserManage.UserListPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;

public class SaveBtnActionListener implements ActionListener {
    ArrayList<UserInfoPanel> userInfoPanels;
    UserListPanel userListPanel;
    ManageUser manageUser = new DataUtils.User.ManageUser();

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
