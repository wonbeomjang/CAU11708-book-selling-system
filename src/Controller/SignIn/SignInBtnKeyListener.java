package Controller.SignIn;

import DataUtils.User.User;
import DataUtils.User.UserList;
import Layout.Interface.SignIn;
import Layout.SignIn.SignInTextPanel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observer;

public class SignInBtnKeyListener extends KeyAdapter {
    private final SignIn signIn = new DataUtils.User.SignIn(UserList.getInstance());
    private final SignInTextPanel signInTextPanel;

    public SignInBtnKeyListener(Observer observer, SignInTextPanel signInTextPanel) {
        this.signInTextPanel = signInTextPanel;
        signIn.addObserver(observer);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            String username = signInTextPanel.getUsername();
            String password = signInTextPanel.getPassword();
            User user = signIn.signIn(username, password);

            if (user == null) {
                JOptionPane.showMessageDialog(null, "존재하지 않거나/비활성화 된 계정입니다.");
            }
        }
    }
}
