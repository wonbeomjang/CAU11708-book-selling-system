package Layout.SearchBook;

import ActionListener.SearchBook.SearchBtnActionListener;
import DataUtils.Book.Book;
import DataUtils.Book.BookKeyType;
import DataUtils.Book.BookOnSale;
import DataUtils.User.User;
import Layout.BookListUp.BookOnSaleAttribFrtBlkPanel;
import Layout.BookListUp.BookOnSaleLabelPanel;
import Layout.Interface.SearchBook;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SearchBookPanel extends JPanel implements Observer {
    SearchKeyWordPanel searchKeyWordPanel;
    BookOnSaleAttribFrtBlkPanel bookOnSaleAttribFrtBlkPanel;
    SearchBook searchBook = new DataUtils.Book.SearchBook();
    ArrayList<BookOnSaleLabelPanel> bookOnSaleLabelPanels = new ArrayList<>();
    Observer observer;
    User systemUser;
    int panWidth = 800;
    int panHeight = 80;

    protected void organizePanel(User systemUser, Book[] books) {
        searchKeyWordPanel = new SearchKeyWordPanel();
        bookOnSaleAttribFrtBlkPanel = new BookOnSaleAttribFrtBlkPanel();

        setLayout(new GridLayout(books.length + 2, 1));


        panHeight = getPanHeight(books.length);

        add(searchKeyWordPanel);
        add(bookOnSaleAttribFrtBlkPanel);

        BookOnSaleLabelPanel bookOnSaleLabelPanel;

        for(Book book: books) {
            bookOnSaleLabelPanel = new BookOnSaleLabelPanel((BookOnSale) book);
            if(systemUser.getUsername().equals(book.getOwner())) {
                bookOnSaleLabelPanel.remove(0);
                bookOnSaleLabelPanel.add(new JLabel(" "), 0);
            }
            bookOnSaleLabelPanels.add(bookOnSaleLabelPanel);
            add(bookOnSaleLabelPanel);
        }

        Observer[] observers = { this, this.observer };
        searchKeyWordPanel.getSearchBtn().addActionListener(new SearchBtnActionListener(searchKeyWordPanel, observers));
    }

    protected void organizePanel() {
        organizePanel(systemUser, searchBook.search(null, BookKeyType.Title));
    }

    @Override
    public void update(Observable o, Object arg) {
        Book[] books = (Book[])arg;
        panHeight = getPanHeight(books.length);

        Component component = getComponent(0);
        removeAll();
        organizePanel(systemUser, books);
        remove(0);
        add(component, 0);
        revalidate();
        repaint();
    }

    public SearchBookPanel(User systemUser, Observer observer) {
        this.systemUser = systemUser;
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

    public ArrayList<BookOnSaleLabelPanel> getBookOnSaleLabelPanels() {
        return bookOnSaleLabelPanels;
    }
}
