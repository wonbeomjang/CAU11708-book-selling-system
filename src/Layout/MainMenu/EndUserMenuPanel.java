package Layout.MainMenu;

import ActionListener.MainMenu.BuyBookBtnActionLister;
import ActionListener.MainMenu.RegisterBookBtnActionListener;
import ActionListener.MainMenu.SearchBookBtnActionLister;
import DataUtils.User.User;

import javax.swing.*;
import java.awt.*;

public class EndUserMenuPanel extends JPanel {
    private User user;

    public EndUserMenuPanel(User user) {
        this.user = user;

        RegisterBookMenuPanel registerBookMenuPanel = new RegisterBookMenuPanel();
        SearchBookMenuPanel searchBookMenuPanel = new SearchBookMenuPanel();
        BuyBookMenuPanel buyBookMenuPanel = new BuyBookMenuPanel();
        DeleteBookMenuPanel deleteBookMenuPanel = new DeleteBookMenuPanel();

        setLayout(new GridLayout(1, 4));

        add(registerBookMenuPanel);
        add(searchBookMenuPanel);
        add(buyBookMenuPanel);
        add(deleteBookMenuPanel);

        registerBookMenuPanel.getBtn().addActionListener(new RegisterBookBtnActionListener(user));
        searchBookMenuPanel.getBtn().addActionListener(new SearchBookBtnActionLister());
        buyBookMenuPanel.getBtn().addActionListener(new BuyBookBtnActionLister());
    }

    public static int getPanWidth() {
        return 800;
    }

    public static int getPanHeight() {
        return 150;
    }
}
