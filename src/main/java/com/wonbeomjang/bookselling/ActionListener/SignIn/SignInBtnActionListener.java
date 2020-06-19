package com.wonbeomjang.bookselling.ActionListener.SignIn;

import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.Interface.SignIn;
import com.wonbeomjang.bookselling.Layout.SignIn.SignInTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

public class SignInBtnActionListener implements ActionListener {
    private final SignIn signIn = new com.wonbeomjang.bookselling.DataUtils.User.SignIn();
    private final SignInTextPanel signInTextPanel;

    public SignInBtnActionListener(Observer observer, SignInTextPanel signInTextPanel) {
        this.signInTextPanel = signInTextPanel;
        signIn.addObserver(observer);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = signInTextPanel.getUsername();
        String password = signInTextPanel.getPassword();
        if (username == null) {
            JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
        }
        else if (password == null) {
            JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
        }
        else {
            User user = signIn.signIn(username, password);
            if (user == null) {
                JOptionPane.showMessageDialog(null, "존재하지 않거나/비활성화 된 계정입니다.");
            }
        }
    }
}
