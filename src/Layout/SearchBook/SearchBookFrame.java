package Layout.SearchBook;

import DataUtils.Book.Book;
import DataUtils.Book.BookSaleList;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SearchBookFrame extends JFrame implements Observer {
    public SearchBookFrame() {
        Book[] books = BookSaleList.getInstance().getBooks();

        setLayout(new BorderLayout());
        add(new SearchBookPanelWoChkBox(this));
        setSize(SearchBookPanelWoChkBox.getPanWidth(), SearchBookPanelWoChkBox.getPanHeight());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        Book[] books = (Book[])arg;
        setSize(SearchBookPanelWoChkBox.getPanWidth(), SearchBookPanelWoChkBox.getPanHeight(books.length));
    }
}
