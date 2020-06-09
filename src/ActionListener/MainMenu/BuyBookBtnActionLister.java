package ActionListener.MainMenu;

import DataUtils.User.User;
import Layout.BuyBook.BuyBookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyBookBtnActionLister implements ActionListener {
    User systemUser;

    public BuyBookBtnActionLister(User systemUser) {
        this.systemUser = systemUser;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new BuyBookFrame(systemUser);
    }
}
