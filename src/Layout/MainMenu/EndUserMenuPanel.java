package Layout.MainMenu;

import ActionListener.MainMenu.BuyBookBtnActionLister;
import ActionListener.MainMenu.SearchBookBtnActionLister;
import DataUtils.User.User;

import javax.swing.*;
import java.awt.*;

public class EndUserMenuPanel extends JPanel {
    private User user;
    private SearchBookMenuPanel searchBookMenuPanel;
    private DeleteBookMenuPanel deleteBookMenuPanel;
    private RegisterBookMenuPanel registerBookMenuPanel;
    private BuyBookMenuPanel buyBookMenuPanel;

    public EndUserMenuPanel(User user) {
        this.user = user;

        registerBookMenuPanel = new RegisterBookMenuPanel();
        searchBookMenuPanel = new SearchBookMenuPanel();
        buyBookMenuPanel = new BuyBookMenuPanel();
        deleteBookMenuPanel = new DeleteBookMenuPanel();

        setLayout(new GridLayout(1, 4));

        add(registerBookMenuPanel);
        add(searchBookMenuPanel);
        add(buyBookMenuPanel);
        add(deleteBookMenuPanel);

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
