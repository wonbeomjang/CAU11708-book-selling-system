package Layout.SignIn;

import javax.swing.*;
import java.awt.*;

public class SignInBtnPanel extends JPanel {
    private JButton signInBtn;
    private JButton signUpBtn;
    public SignInBtnPanel() {
        setLayout(new GridLayout(1, 2));
        add(signInBtn);
        add(signUpBtn);
    }

    public JButton getSignInBtn() {
        return signInBtn;
    }

    public JButton getSignUpBtn() {
        return signUpBtn;
    }
}
