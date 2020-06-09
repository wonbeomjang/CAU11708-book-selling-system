package ActionListener.MainMenu;

import DataUtils.User.User;
import Layout.RegisterBook.RegisterBookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterBookBtnActionListener implements ActionListener {
    User user;
    public RegisterBookBtnActionListener(User user) {
       this.user = user;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new RegisterBookFrame(user);
    }
}
