package com.wonbeomjang.bookselling.Layout.RegisterBook;

import javax.swing.*;
import java.awt.*;

public class RegisterBookInfoPanel extends JPanel {
    public RegisterBookInfoPanel() {
        setLayout(new GridLayout(7, 1));
        add(new JLabel("  제목  "));
        add(new JLabel("  ISBN  "));
        add(new JLabel("  출판 년도  "));
        add(new JLabel("  출판사  "));
        add(new JLabel("  저자  "));
        add(new JLabel("  가격  "));
        add(new JLabel("  상태  "));
    }
}
