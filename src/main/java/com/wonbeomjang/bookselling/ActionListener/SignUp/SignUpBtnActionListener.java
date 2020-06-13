package com.wonbeomjang.bookselling.ActionListener.SignUp;

import com.wonbeomjang.bookselling.Layout.Interface.SignUp;
import com.wonbeomjang.bookselling.Layout.SignUp.SignUpTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

public class SignUpBtnActionListener implements ActionListener {
    private final SignUp signUp = new com.wonbeomjang.bookselling.DataUtils.User.SignUp();
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

        if(username==null || password==null || email==null || phoneNumber==null || name==null)
            JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요");

        if(!signUp.signUp(username, password, email, phoneNumber, name)) {
            JOptionPane.showMessageDialog(null, "존재하는 아이디입니다.");
        }
    }
}
