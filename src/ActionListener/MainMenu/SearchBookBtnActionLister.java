package ActionListener.MainMenu;

import Layout.SearchBook.SearchBookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookBtnActionLister implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new SearchBookFrame();
    }
}
