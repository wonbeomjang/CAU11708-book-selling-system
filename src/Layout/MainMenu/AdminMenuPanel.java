package Layout.MainMenu;

import DataUtils.User.User;

import javax.swing.*;
import java.awt.*;

public class AdminMenuPanel extends JPanel {
    private SearchBookMenuPanel searchBookMenuPanel;
    private DeleteBookMenuPanel deleteBookMenuPanel;
    private ManageUserMenuPanel manageUserMenuPanel;
    private User user;
    public AdminMenuPanel(User user) {
        this.user = user;

        searchBookMenuPanel = new SearchBookMenuPanel();
        deleteBookMenuPanel = new DeleteBookMenuPanel();
        manageUserMenuPanel = new ManageUserMenuPanel();

        setLayout(new GridLayout(1, 3));

        add(searchBookMenuPanel);
        add(deleteBookMenuPanel);
        add(manageUserMenuPanel);
    }

    public static int getPanWidth() {
        return 500;
    }

    public static int getPanHeight() {
        return 150;
    }
}
