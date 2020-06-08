package Layout.SignUp;

import javax.swing.*;
import java.awt.*;

public class SignUpTextPanel extends JPanel {
    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JTextField email = new JTextField();
    JTextField phoneNumber = new JTextField();
    JTextField name = new JTextField();

    public SignUpTextPanel() {
        setLayout(new GridLayout(5, 1));
        add(username);
        add(password);
        add(email);
        add(phoneNumber);
        add(name);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPhoneNumber() {
        return phoneNumber.getText();
    }

    public String getName() {
        return name.getText();
    }
}
