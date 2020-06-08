package Layout.MainMenu;

import DataUtils.User.User;

import javax.swing.*;
import java.awt.*;

public class EndUserMenuPanel extends JPanel {
    private User user;
    private SearchBookMenuPanel searchBookMenuPanel;
    private DeleteBookMenuPanel deleteBookMenuPanel;
    private RegisterBookMenuPanel registerBookMenuPanel;

    public EndUserMenuPanel(User user) {
        this.user = user;

        searchBookMenuPanel = new SearchBookMenuPanel();
        deleteBookMenuPanel = new DeleteBookMenuPanel();
        registerBookMenuPanel = new RegisterBookMenuPanel();

        setLayout(new GridLayout(1, 3));

        add(searchBookMenuPanel);
        add(registerBookMenuPanel);
        add(deleteBookMenuPanel);
    }

    public static int getPanWidth() {
        return 500;
    }

    public static int getPanHeight() {
        return 150;
    }
}
