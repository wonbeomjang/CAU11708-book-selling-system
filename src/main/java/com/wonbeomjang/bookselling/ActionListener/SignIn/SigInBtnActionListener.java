package com.wonbeomjang.bookselling.ActionListener.SignIn;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.Interface.SignIn;
import com.wonbeomjang.bookselling.Layout.SignIn.SignInTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

public class SigInBtnActionListener implements ActionListener {
    private final SignIn signIn = new com.wonbeomjang.bookselling.DataUtils.User.SignIn();
    private final SignInTextPanel signInTextPanel;

    public SigInBtnActionListener(Observer observer, SignInTextPanel signInTextPanel) {
        this.signInTextPanel = signInTextPanel;
        signIn.addObserver(observer);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = signInTextPanel.getUsername();
        String password = signInTextPanel.getPassword();
        User user = signIn.signIn(username, password);

        if(user == null) {
            JOptionPane.showMessageDialog(null, "존재하지 않거나/비활성화 된 계정입니다.");
        }
    }
}
