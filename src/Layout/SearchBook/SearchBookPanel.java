package Layout.SearchBook;

import ActionListener.SearchBook.SearchBtnActionListener;
import DataUtils.Book.Book;
import DataUtils.Book.BookKeyType;
import DataUtils.Book.BookOnSale;
import Layout.Interface.SearchBook;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SearchBookPanel extends JPanel implements Observer {
    SearchKeyWordPanel searchKeyWordPanel;
    BookOnSaleInfoLabelPanel bookOnSaleInfoLabelPanel;
    SearchBook searchBook = new DataUtils.Book.SearchBook();
    ArrayList<BookOnSaleInfoPanel> bookOnSaleInfoPanels = new ArrayList<>();
    Observer observer;
    int panWidth = 800;
    int panHeight = 80;

    protected void organizePanel(Book[] books) {
        searchKeyWordPanel = new SearchKeyWordPanel();
        bookOnSaleInfoLabelPanel = new BookOnSaleInfoLabelPanel();

        setLayout(new GridLayout(books.length + 2, 1));


        panHeight = getPanHeight(books.length);

        add(searchKeyWordPanel);
        add(bookOnSaleInfoLabelPanel);

        BookOnSaleInfoPanel bookOnSaleInfoPanel;

        for(Book book: books) {
            bookOnSaleInfoPanel = new BookOnSaleInfoPanel((BookOnSale) book);
            bookOnSaleInfoPanels.add(bookOnSaleInfoPanel);
            add(bookOnSaleInfoPanel);
        }

        Observer[] observers = { this, this.observer };
        searchKeyWordPanel.getSearchBtn().addActionListener(new SearchBtnActionListener(searchKeyWordPanel, observers));
    }

    protected void organizePanel() {
        organizePanel(searchBook.search(null, BookKeyType.Title));
    }

    @Override
    public void update(Observable o, Object arg) {
        Book[] books = (Book[])arg;
        panHeight = getPanHeight(books.length);

        Component component = getComponent(0);
        removeAll();
        organizePanel(books);
        remove(0);
        add(component, 0);
        revalidate();
        repaint();
    }

    public SearchBookPanel(Observer observer) {
        this.observer = observer;
        organizePanel();
    }

    public int getPanWidth() {
        return panWidth;
    }

    public int getPanHeight() {
        return panHeight;
    }

    public int getPanHeight(int numBooks) {
        return 30 * numBooks + 100;
    }

    public ArrayList<BookOnSaleInfoPanel> getBookOnSaleInfoPanels() {
        return bookOnSaleInfoPanels;
    }
}
