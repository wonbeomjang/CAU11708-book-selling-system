package ActionListener.SearchBook;

import DataUtils.Book.Book;
import DataUtils.Book.BookKeyType;
import Layout.Interface.SearchBook;
import Layout.SearchBook.SearchKeyWordPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

public class SearchBtnActionListener implements ActionListener {
    SearchKeyWordPanel searchKeyWordPanel;
    SearchBook searchBook;
    public SearchBtnActionListener(SearchKeyWordPanel searchKeyWordPanel, Observer[] observers) {
        this.searchKeyWordPanel = searchKeyWordPanel;
        this.searchBook = new DataUtils.Book.SearchBook();
        for (Observer observer: observers)
            this.searchBook.addObserver(observer);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String key = searchKeyWordPanel.getKeyText().getText();
        String keyTypeStr = (String)searchKeyWordPanel.getSearchKeyType().getSelectedItem();
        BookKeyType keyType = BookKeyType.valueOf(keyTypeStr);

        Book[] books = searchBook.search(key, keyType);

    }
}
