package Layout.SignUp;

import javax.swing.*;
import java.awt.*;

public class SignUpInfoPanel extends JPanel {
    public SignUpInfoPanel() {
        setLayout(new GridLayout(5, 1));
        add(new JLabel("  username  "));
        add(new JLabel("  password  "));
        add(new JLabel("  email  "));
        add(new JLabel("  phone number  "));
        add(new JLabel("  name  "));
    }
}
