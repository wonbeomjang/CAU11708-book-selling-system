package com.wonbeomjang.bookselling.Layout.MainMenu;

import javax.swing.*;
import java.awt.*;

public class MenuSubPanel extends JPanel {
    JButton btn;
    public MenuSubPanel(String menuName, String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);

        Image image = imageIcon.getImage();
        image = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        btn = new JButton(menuName, imageIcon);

        setLayout(new BorderLayout());
        btn.setBackground(Color.white);

        add(btn);
    }

    public JButton getBtn() {
        return btn;
    }
}
