package Layout.MainMenu;

import ActionListener.MainMenu.SearchBookBtnActionLister;
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

        searchBookMenuPanel.getBtn().addActionListener(new SearchBookBtnActionLister());
    }

    public static int getPanWidth() {
        return 600;
    }

    public static int getPanHeight() {
        return 150;
    }
}
