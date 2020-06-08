package Layout.SignUp;

import ActionListener.SignUp.SignUpBtnActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class SignUpPanel extends JPanel {
    JButton signUpBtn = new JButton("signUp");
    SignUpTextPanel signUpTextPanel = new SignUpTextPanel();

    public SignUpPanel(Observer observer) {
        setLayout(new BorderLayout());
        add(new SignUpInfoPanel(), BorderLayout.WEST);
        add(signUpTextPanel, BorderLayout.CENTER);
        add(signUpBtn, BorderLayout.EAST);

        signUpBtn.addActionListener(new SignUpBtnActionListener(observer, signUpTextPanel));
    }
}
