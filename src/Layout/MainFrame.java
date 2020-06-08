package Layout;

import DataUtils.User.Admin;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import Layout.MainMenu.AdminMenuPanel;
import Layout.MainMenu.EndUserMenuPanel;
import Layout.SignIn.SignInPanel;

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
            add(new EndUserMenuPanel(systemUser));

            width = EndUserMenuPanel.getPanWidth();
            height = EndUserMenuPanel.getPanHeight();

            setSize(width, height);
            revalidate();
            repaint();
        }
        else if(arg instanceof Admin) {
            add(new AdminMenuPanel(systemUser));

            width = AdminMenuPanel.getPanWidth();
            height = AdminMenuPanel.getPanHeight();

            setSize(width, height);
            revalidate();
            repaint();
        }
    }
}
