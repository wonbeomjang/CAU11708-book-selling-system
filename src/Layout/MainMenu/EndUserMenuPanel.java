package Layout.MainMenu;

import ActionListener.MainMenu.BuyBookBtnActionLister;
import ActionListener.MainMenu.DeleteBookBtnActionListener;
import ActionListener.MainMenu.RegisterBookBtnActionListener;
import DataUtils.User.User;

import javax.swing.*;
import java.awt.*;

public class EndUserMenuPanel extends JPanel {
    private User systemUser;

    public EndUserMenuPanel(User systemUser) {
        this.systemUser = systemUser;

        RegisterBookMenuPanel registerBookMenuPanel = new RegisterBookMenuPanel();
//        SearchBookMenuPanel searchBookMenuPanel = new SearchBookMenuPanel();
        BuyBookMenuPanel buyBookMenuPanel = new BuyBookMenuPanel();
        DeleteBookMenuPanel deleteBookMenuPanel = new DeleteBookMenuPanel();

        setLayout(new GridLayout(1, 3));
//        setLayout(new GridLayout(1, 4));

        add(registerBookMenuPanel);
//        add(searchBookMenuPanel);
        add(buyBookMenuPanel);
        add(deleteBookMenuPanel);

        registerBookMenuPanel.getBtn().addActionListener(new RegisterBookBtnActionListener(systemUser));
//        searchBookMenuPanel.getBtn().addActionListener(new SearchBookBtnActionLister());
        buyBookMenuPanel.getBtn().addActionListener(new BuyBookBtnActionLister(systemUser));
        deleteBookMenuPanel.getBtn().addActionListener(new DeleteBookBtnActionListener(systemUser));
    }

//    public int getPanWidth() {
//        return 800;
//    }

    public int getPanWidth() {
        return 600;
    }

    public int getPanHeight() {
        return 150;
    }
}
