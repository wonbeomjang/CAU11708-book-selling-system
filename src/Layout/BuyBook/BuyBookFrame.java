package Layout.BuyBook;

import DataUtils.Book.Book;
import DataUtils.Book.BookSaleList;
import Layout.SearchBook.SearchBookPanel;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class BuyBookFrame extends JFrame implements Observer {
    public BuyBookFrame() {

        add(new BuyBookPanel(this));
        setSize(BuyBookPanel.getPanWidth(), BuyBookPanel.getPanHeight());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        Book[] books = (Book[])arg;
        setSize(BuyBookPanel.getPanWidth(), BuyBookPanel.getPanHeight(books.length));
    }
}
