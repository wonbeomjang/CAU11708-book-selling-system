package com.wonbeomjang.bookselling.Layout.MainMenu;

import com.wonbeomjang.bookselling.ActionListener.MainMenu.BuyBookBtnActionLister;
import com.wonbeomjang.bookselling.ActionListener.MainMenu.DeleteBookBtnActionListener;
import com.wonbeomjang.bookselling.ActionListener.MainMenu.ModifyBookBtnActionListener;
import com.wonbeomjang.bookselling.ActionListener.MainMenu.RegisterBookBtnActionListener;
import com.wonbeomjang.bookselling.DataUtils.User.User;

import javax.swing.*;
import java.awt.*;

public class EndUserMenuPanel extends JPanel {

    public EndUserMenuPanel(User systemUser) {

        RegisterBookMenuPanel registerBookMenuPanel = new RegisterBookMenuPanel();
        ModifyBookMenuPanel modifyBookMenuPanel = new ModifyBookMenuPanel();
        BuyBookMenuPanel buyBookMenuPanel = new BuyBookMenuPanel();
        DeleteBookMenuPanel deleteBookMenuPanel = new DeleteBookMenuPanel();

        setLayout(new GridLayout(1, 4));

        add(registerBookMenuPanel);
        add(modifyBookMenuPanel);
        add(buyBookMenuPanel);
        add(deleteBookMenuPanel);

        modifyBookMenuPanel.getBtn().addActionListener(new ModifyBookBtnActionListener(systemUser));
        registerBookMenuPanel.getBtn().addActionListener(new RegisterBookBtnActionListener(systemUser));
        buyBookMenuPanel.getBtn().addActionListener(new BuyBookBtnActionLister(systemUser));
        deleteBookMenuPanel.getBtn().addActionListener(new DeleteBookBtnActionListener(systemUser));
    }

    public int getPanWidth() {
        return 700;
    }

    public int getPanHeight() {
        return 150;
    }
}
