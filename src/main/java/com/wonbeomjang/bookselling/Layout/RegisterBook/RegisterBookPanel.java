package com.wonbeomjang.bookselling.Layout.RegisterBook;

import com.wonbeomjang.bookselling.ActionListener.RegisterBook.RegisterBtnActionListener;
import com.wonbeomjang.bookselling.DataUtils.User.User;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class RegisterBookPanel extends JPanel {
    JButton registerBtn = new JButton("등록");
    RegisterBookTextPanel registerBookTextPanel = new RegisterBookTextPanel();

    public RegisterBookPanel(User user, Observer observer) {
        setLayout(new BorderLayout());
        add(new RegisterBookInfoPanel(), BorderLayout.WEST);
        add(registerBookTextPanel, BorderLayout.CENTER);
        add(registerBtn, BorderLayout.EAST);

        registerBtn.addActionListener(new RegisterBtnActionListener(registerBookTextPanel,user, observer));
    }
}
