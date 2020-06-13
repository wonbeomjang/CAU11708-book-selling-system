package ActionListener.MainMenu;

import DataUtils.User.User;
import Layout.SearchBook.SearchBookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookBtnActionLister implements ActionListener {
    User systemUser;

    public SearchBookBtnActionLister(User systemUser) {
        this.systemUser = systemUser;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new SearchBookFrame(systemUser);
    }
}
