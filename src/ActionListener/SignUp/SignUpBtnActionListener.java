package ActionListener.SignUp;

import DataUtils.User.UserList;
import Layout.Interface.SignUp;
import Layout.SignUp.SignUpTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

public class SignUpBtnActionListener implements ActionListener {
    private final SignUp signUp = new DataUtils.User.SignUp();
    SignUpTextPanel signUpTextPanel;
    public SignUpBtnActionListener(Observer observer, SignUpTextPanel signUpTextPanel) {
        this.signUpTextPanel = signUpTextPanel;
        signUp.addObserver(observer);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = signUpTextPanel.getUsername();
        String password = signUpTextPanel.getPassword();
        String email = signUpTextPanel.getEmail();
        String phoneNumber = signUpTextPanel.getPhoneNumber();
        String name = signUpTextPanel.getName();

        if(!signUp.signUp(username, password, email, phoneNumber, name)) {
            JOptionPane.showMessageDialog(null, "존재하는 아이디입니다.");
        }
    }
}
