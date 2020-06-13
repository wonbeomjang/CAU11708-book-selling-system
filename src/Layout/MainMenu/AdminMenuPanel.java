package Layout.MainMenu;

import ActionListener.MainMenu.DeleteBookBtnActionListener;
import ActionListener.MainMenu.ManageUserBtnActionListener;
import ActionListener.MainMenu.SearchBookBtnActionLister;
import DataUtils.User.User;

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
