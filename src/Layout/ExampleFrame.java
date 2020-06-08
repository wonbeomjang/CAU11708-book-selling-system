package Layout;

import DataUtils.Book.Book;
import DataUtils.Book.BookKeyType;
import DataUtils.Book.BookSaleList;
import DataUtils.Book.SearchBook;
import Layout.SearchBook.SearchBookPanel;

import javax.swing.*;
import java.awt.*;

public class ExampleFrame extends JFrame {
    public ExampleFrame() {
        SearchBook searchBook = new SearchBook(BookSaleList.getInstance());
        Book[] books = searchBook.search("asdfs", BookKeyType.Username);

        setLayout(new BorderLayout());
        add(new SearchBookPanel(books));
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
