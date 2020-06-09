package Layout.BuyBook;

import ActionListener.BuyBook.BuyBtnActionListener;
import DataUtils.User.User;
import Layout.SearchBook.SearchBookPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class BuyBookPanel extends JPanel {
    SearchBookPanel searchBookPanel;
    JButton buyBtn;
    public BuyBookPanel(User systemUser, Observer observer) {
        searchBookPanel = new SearchBookPanel(observer);
        buyBtn = new JButton("사기");

        setLayout(new BorderLayout());

        add(searchBookPanel, BorderLayout.CENTER);
        add(buyBtn, BorderLayout.EAST);

        buyBtn.addActionListener(new BuyBtnActionListener(searchBookPanel, systemUser, observer));
    }

    public int getPanWidth() {
        return searchBookPanel.getPanWidth() + 50;
    }

    public int getPanHeight() {
        return searchBookPanel.getPanHeight();
    }

    public int getPanHeight(int numBooks) {
        return searchBookPanel.getPanHeight(numBooks);
    }
}
