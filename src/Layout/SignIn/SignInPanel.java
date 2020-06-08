package Layout.SignIn;

import javax.swing.*;

public class SignInPanel extends JPanel {
    SignInTextPanel signInTextPanel;
    SignInBtnPanel signInBtnPanel;

    public SignInPanel() {
        signInTextPanel = new SignInTextPanel();
        signInBtnPanel = new SignInBtnPanel();
    }
}
