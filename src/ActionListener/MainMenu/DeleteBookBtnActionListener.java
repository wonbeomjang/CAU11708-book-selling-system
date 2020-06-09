package ActionListener.MainMenu;

import DataUtils.User.User;
import Layout.DeleteBook.DeleteBookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBookBtnActionListener implements ActionListener {
    User systemUser;

    public DeleteBookBtnActionListener(User systemUser) {
        this.systemUser = systemUser;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new DeleteBookFrame(systemUser);
    }
}
