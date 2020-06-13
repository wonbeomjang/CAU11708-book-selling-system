package com.wonbeomjang.bookselling.Layout.UserManage;

import javax.swing.*;
import java.awt.*;

public class UserListInfoLabelPanel extends JPanel {
    public UserListInfoLabelPanel() {
        setLayout(new GridLayout());

        add(new JLabel("아이디"));
        add(new JLabel("이메일"));
        add(new JLabel("전화번호"));
        add(new JLabel("이름"));
        add(new JLabel("회원상태"));
    }
}
