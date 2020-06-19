package com.wonbeomjang.bookselling.Layout.SignIn;

import com.wonbeomjang.bookselling.ActionListener.SignIn.SignInBtnActionListener;
import com.wonbeomjang.bookselling.ActionListener.SignIn.SignUpBtnActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class SignInPanel extends JPanel {

    public SignInPanel(Observer observer) {
        SignInTextPanel signInTextPanel = new SignInTextPanel();
        SignInBtnPanel signInBtnPanel = new SignInBtnPanel();

        setLayout(new BorderLayout());

        add(new SignInInfoPanel(), BorderLayout.WEST);
        add(signInTextPanel, BorderLayout.CENTER);
        add(signInBtnPanel, BorderLayout.EAST);

        signInBtnPanel.getSignInBtn().addActionListener(new SignInBtnActionListener(observer, signInTextPanel));
        signInBtnPanel.getSignUpBtn().addActionListener(new SignUpBtnActionListener());
    }
}
