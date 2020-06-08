package Layout.SignIn;

import javax.swing.*;
import java.awt.*;

public class SignInInfoPanel extends JPanel {
    public SignInInfoPanel() {
        setLayout(new GridLayout(2, 1));
        add(new JLabel("  username  "));
        add(new JLabel("  password  "));
    }
}
