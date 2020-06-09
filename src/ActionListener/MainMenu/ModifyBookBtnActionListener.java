package ActionListener.MainMenu;

import DataUtils.User.User;
import Layout.ModifyBook.ModifyBookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyBookBtnActionListener implements ActionListener {
    User systemUser;

    public ModifyBookBtnActionListener(User systemUser) {
        this.systemUser = systemUser;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new ModifyBookFrame(systemUser);
    }
}
