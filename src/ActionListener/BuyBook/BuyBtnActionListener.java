package ActionListener.BuyBook;

import DataUtils.Book.Book;
import DataUtils.User.User;
import Layout.Interface.BuyBook;
import Layout.SearchBook.BookOnSaleInfoPanel;
import Layout.SearchBook.SearchBookPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;

public class BuyBtnActionListener implements ActionListener {
    SearchBookPanel searchBookPanel;
    BuyBook buyBook = new DataUtils.Book.BuyBook();
    User systemUser;
    Observer observer;

    public BuyBtnActionListener(SearchBookPanel searchBookPanel, User systemUser, Observer observer) {
        this.searchBookPanel = searchBookPanel;
        this.systemUser = systemUser;
        this.observer = observer;
        this.buyBook.addObserver(observer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<BookOnSaleInfoPanel> bookOnSaleInfoPanels = searchBookPanel.getBookOnSaleInfoPanels();

        for(BookOnSaleInfoPanel panel: bookOnSaleInfoPanels) {
            if(panel.isChecked()) {
                Book book = panel.getBook();
                buyBook.buyBook(systemUser, book);
            }
        }
    }
}
