package com.wonbeomjang.bookselling.Layout.RegisterBook;

import com.wonbeomjang.bookselling.DataUtils.User.User;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class RegisterBookFrame extends JFrame implements Observer {

    public RegisterBookFrame(User user) {
        setLayout(new BorderLayout());
        RegisterBookPanel signUpPanel = new RegisterBookPanel(user, this);
        add(signUpPanel);

        setSize(500, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg) {
        JOptionPane.showMessageDialog(null, "정상적으로 책 등록이 되었습니다.");
        dispose();
    }
}
