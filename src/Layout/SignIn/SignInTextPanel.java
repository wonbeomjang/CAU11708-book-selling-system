package Layout.SignIn;

import javax.swing.*;
import java.awt.*;

public class SignInTextPanel extends JPanel {
    private JTextField username;
    private JPasswordField password;

    public SignInTextPanel() {
        setLayout(new GridLayout(1, 2));

        username = new JTextField();
        password = new JPasswordField();

        add(username);
        add(password);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return String.valueOf(password.getPassword());
    }
}
