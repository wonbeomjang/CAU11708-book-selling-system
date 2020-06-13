package com.wonbeomjang.bookselling.Layout;

import com.wonbeomjang.bookselling.DataUtils.User.Admin;
import com.wonbeomjang.bookselling.DataUtils.User.EndUser;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Layout.MainMenu.AdminMenuPanel;
import com.wonbeomjang.bookselling.Layout.MainMenu.EndUserMenuPanel;
import com.wonbeomjang.bookselling.Layout.SignIn.SignInPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MainFrame extends JFrame implements Observer {
    private User systemUser = null;
    int width = 300;
    int height = 100;

    private SignInPanel signInPanel = new SignInPanel(this);

    public MainFrame() {
        setLayout(new BorderLayout());
        add(signInPanel);

        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        systemUser = (User) arg;
        remove(signInPanel);
        if(arg instanceof EndUser) {
            EndUserMenuPanel endUserMenuPanel = new EndUserMenuPanel(systemUser);
            add(endUserMenuPanel);

            width = endUserMenuPanel.getPanWidth();
            height = endUserMenuPanel.getPanHeight();

            setSize(width, height);
            revalidate();
            repaint();
        }
        else if(arg instanceof Admin) {
            AdminMenuPanel adminMenuPanel = new AdminMenuPanel(systemUser);
            add(adminMenuPanel);

            width = adminMenuPanel.getPanWidth();
            height = adminMenuPanel.getPanHeight();

            setSize(width, height);
            revalidate();
            repaint();
        }
    }
}
