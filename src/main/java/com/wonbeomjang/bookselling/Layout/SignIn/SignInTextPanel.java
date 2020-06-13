package com.wonbeomjang.bookselling.Layout.SignIn;

import javax.swing.*;
import java.awt.*;

public class SignInTextPanel extends JPanel {
    private final JTextField username;
    private final JPasswordField password;

    public SignInTextPanel() {
        setLayout(new GridLayout(2, 1));

        username = new JTextField();
        password = new JPasswordField();

        add(username);
        add(password);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return String.valueOf(password.getPassword());
    }
}
