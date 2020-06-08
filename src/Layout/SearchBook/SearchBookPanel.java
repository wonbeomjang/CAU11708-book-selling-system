package Layout.SearchBook;

import ActionListener.SearchBook.SearchBtnActionListener;
import DataUtils.Book.Book;
import DataUtils.Book.BookSaleList;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SearchBookPanel extends JPanel implements Observer {
    SearchKeyWordPanel searchKeyWordPanel;
    BookInfoLabelPanel bookInfoLabelPanel;
    BookInfoPanel[] bookInfoPanels;
    BookInfoPanel bookInfoPanel;
    Book[] books;
    Observer observer;
    static int panWidth = 800;
    static int panHeight = 80;

    private void organizePanel(Book[] books) {
        this.books = books;
        panHeight = getPanHeight(books.length);
        String[] bookInfo;

        setLayout(new GridLayout(books.length + 2, 1));

        searchKeyWordPanel = new SearchKeyWordPanel();
        bookInfoLabelPanel = new BookInfoLabelPanel();
        bookInfoPanels = new BookInfoPanel[books.length];

        add(searchKeyWordPanel);
        add(bookInfoLabelPanel);

        for(int i = 0; i < books.length; i++) {
            bookInfo = books[i].toString().split(":");
            bookInfoPanel = new BookInfoPanel(bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], bookInfo[4], bookInfo[5], bookInfo[6], bookInfo[7]);
            bookInfoPanels[i] = bookInfoPanel;
            add(bookInfoPanel);
        }

        Observer[] observers = { this, this.observer };
        searchKeyWordPanel.getSearchBtn().addActionListener(new SearchBtnActionListener(searchKeyWordPanel, observers));
    }

    @Override
    public void update(Observable o, Object arg) {
        books = (Book[])arg;
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
        books = BookSaleList.getInstance().getBooks();
        organizePanel(books);
    }

    public static int getPanWidth() {
        return panWidth;
    }

    public static int getPanHeight() {
        return panHeight;
    }

    public static int getPanHeight(int numBooks) {
        return 30 * numBooks + 100;
    }

}
