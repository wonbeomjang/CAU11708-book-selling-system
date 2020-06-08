package Layout;

import DataUtils.User.User;
import Layout.SignIn.SignInPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MainFrame extends JFrame implements Observer {
    private User systemUser = null;

    private SignInPanel signInPanel = new SignInPanel(this);

    public MainFrame() {
        setLayout(new BorderLayout());
        add(signInPanel);

        setSize(500, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof User) {
            systemUser = (User) arg;
            remove(signInPanel);
            repaint();
        }
    }
}
