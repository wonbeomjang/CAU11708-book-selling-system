package ActionListener.MainMenu;

import Layout.BuyBook.BuyBookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyBookBtnActionLister implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new BuyBookFrame();
    }
}
