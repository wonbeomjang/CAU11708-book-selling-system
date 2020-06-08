package ActionListener.SignIn;

import Layout.SignUp.SignUpFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpBtnActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        new SignUpFrame();
    }
}
