package Layout.BuyBook;

import Layout.SearchBook.SearchBookPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class BuyBookPanel extends JPanel {
    SearchBookPanel searchBookPanel;
    JButton buyBtn;
    public BuyBookPanel(Observer observer) {
        searchBookPanel = new SearchBookPanel(observer);
        buyBtn = new JButton("사기");

        setLayout(new BorderLayout());

        add(searchBookPanel, BorderLayout.CENTER);
        add(buyBtn, BorderLayout.EAST);
    }

    public static int getPanWidth() {
        return SearchBookPanel.getPanWidth() + 50;
    }

    public static int getPanHeight() {
        return SearchBookPanel.getPanHeight();
    }

    public static int getPanHeight(int numBooks) {
        return SearchBookPanel.getPanHeight(numBooks);
    }
}
