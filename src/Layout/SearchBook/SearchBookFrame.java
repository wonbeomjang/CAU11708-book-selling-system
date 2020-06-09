package Layout.SearchBook;

import DataUtils.Book.Book;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SearchBookFrame extends JFrame implements Observer {
    SearchBookPanelWoChkBox searchBookPanelWoChkBox;
    public SearchBookFrame() {
        searchBookPanelWoChkBox = new SearchBookPanelWoChkBox(this);

        setLayout(new BorderLayout());
        add(searchBookPanelWoChkBox);
        setSize(searchBookPanelWoChkBox.getPanWidth(), searchBookPanelWoChkBox.getPanHeight());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        Book[] books = (Book[])arg;
        setSize(searchBookPanelWoChkBox.getPanWidth(), searchBookPanelWoChkBox.getPanHeight(books.length));
    }
}
