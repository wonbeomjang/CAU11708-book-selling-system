package Controller;

import DataUtils.User.User;
import DataUtils.User.UserList;
import Layout.Interface.SignIn;
import Layout.SignIn.SignInTextPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SigInBtnActionListener implements ActionListener {
    public SigInBtnActionListener(SignInTextPanel signInTextPanel) {
        String username = signInTextPanel.getUsername();
        String password = signInTextPanel.getPassword();
        SignIn signIn = new DataUtils.User.SignIn(UserList.getInstance());

        User user = signIn.signIn(username, password);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
