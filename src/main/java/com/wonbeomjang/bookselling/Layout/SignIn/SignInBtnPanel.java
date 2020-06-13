package com.wonbeomjang.bookselling.Layout.SignIn;

import javax.swing.*;
import java.awt.*;

public class SignInBtnPanel extends JPanel {
    private final JButton signInBtn = new JButton("SignIn");
    private final JButton signUpBtn = new JButton("SignUp");
    public SignInBtnPanel() {
        setLayout(new GridLayout(2, 1));
        add(signInBtn);
        add(signUpBtn);
    }

    public JButton getSignInBtn() {
        return signInBtn;
    }

    public JButton getSignUpBtn() {
        return signUpBtn;
    }
}
