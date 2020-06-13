package com.wonbeomjang.bookselling.Layout.MainMenu;

import com.wonbeomjang.bookselling.ActionListener.MainMenu.DeleteBookBtnActionListener;
import com.wonbeomjang.bookselling.ActionListener.MainMenu.ManageUserBtnActionListener;
import com.wonbeomjang.bookselling.ActionListener.MainMenu.SearchBookBtnActionLister;
import com.wonbeomjang.bookselling.DataUtils.User.User;

import javax.swing.*;
import java.awt.*;

public class AdminMenuPanel extends JPanel {
    public AdminMenuPanel(User user) {

        SearchBookMenuPanel searchBookMenuPanel = new SearchBookMenuPanel();
        DeleteBookMenuPanel deleteBookMenuPanel = new DeleteBookMenuPanel();
        ManageUserMenuPanel manageUserMenuPanel = new ManageUserMenuPanel();

        setLayout(new GridLayout(1, 3));

        add(searchBookMenuPanel);
        add(deleteBookMenuPanel);
        add(manageUserMenuPanel);

        searchBookMenuPanel.getBtn().addActionListener(new SearchBookBtnActionLister(user));
        manageUserMenuPanel.getBtn().addActionListener(new ManageUserBtnActionListener(user));
        deleteBookMenuPanel.getBtn().addActionListener(new DeleteBookBtnActionListener(user));
    }

    public int getPanWidth() {
        return 600;
    }

    public int getPanHeight() {
        return 150;
    }
}
