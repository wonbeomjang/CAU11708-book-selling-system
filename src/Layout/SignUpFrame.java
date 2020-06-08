package Layout;

import Layout.SignUp.SignUpPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SignUpFrame extends JFrame implements Observer {

    public SignUpFrame() {
        setLayout(new BorderLayout());
        SignUpPanel signUpPanel = new SignUpPanel(this);
        add(signUpPanel);

        setSize(500, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
        dispose();
    }
}
