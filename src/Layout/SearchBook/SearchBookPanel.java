package Layout.SearchBook;

import DataUtils.Book.Book;

import javax.swing.*;
import java.awt.*;

public class SearchBookPanel extends JPanel {
    SearchKeyWordPanel searchKeyWordPanel;
    BookInfoLabelPanel bookInfoLabelPanel;
    BookInfoPanel[] bookInfoPanels;
    BookInfoPanel bookInfoPanel;

    public SearchBookPanel(Book[] books) {
        String[] bookInfo;

        setLayout(new GridLayout(books.length + 2, 1));

        searchKeyWordPanel = new SearchKeyWordPanel();
        bookInfoLabelPanel = new BookInfoLabelPanel();
        bookInfoPanels = new BookInfoPanel[books.length];

        add(searchKeyWordPanel);
        add(bookInfoLabelPanel);

        for(int i = 0; i < books.length; i++) {
            bookInfo = books[i].toString().split(":");
            System.out.println(bookInfo.length);
            bookInfoPanel = new BookInfoPanel(bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], bookInfo[4], bookInfo[5], bookInfo[6], bookInfo[7]);
            bookInfoPanels[i] = bookInfoPanel;
        }
    }
}
